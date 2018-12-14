package io.mverse.client.infusionsoft.infrastructure

import kotlinx.serialization.KSerializer
import okhttp3.HttpUrl
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.File
import java.io.IOException
import java.util.regex.Pattern

open class ApiClient(val baseUrl: String, bearerToken: String) {

  val authHeaders: Map<String, String> = mapOf("Authorization" to "Bearer $bearerToken")

  companion object {

    val fileNamePattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?")
    protected const val ContentType = "Content-Type"
    protected const val Accept = "Accept"
    protected const val JsonMediaType = "application/json"
    protected const val FormDataMediaType = "multipart/form-data"
    protected const val XmlMediaType = "application/xml"

    @JvmStatic
    val client by lazy {
      builder.build()
    }

    @JvmStatic
    val builder: OkHttpClient.Builder = OkHttpClient.Builder()

    @JvmStatic
    var defaultHeaders: Map<String, String> by setOnce(mapOf(ContentType to JsonMediaType, Accept to JsonMediaType))

    @JvmStatic
    val jsonHeaders: Map<String, String> = mapOf(ContentType to JsonMediaType, Accept to JsonMediaType)
  }

  protected inline fun <reified T> requestBody(content: T?, mediaType: String = JsonMediaType, serializer: KSerializer<T>): RequestBody {
    when {
      content is File -> return RequestBody.create(MediaType.parse(mediaType), content)
      mediaType == FormDataMediaType -> {
        val requestBodyBuilder = MultipartBody.Builder().setType(MultipartBody.FORM)

        // content's type *must* be Map<String, Any>
        @Suppress("UNCHECKED_CAST")
        (content as Map<String, Any>).forEach { key, value ->
          if (value::class == File::class) {
            val file = value as File
            requestBodyBuilder.addFormDataPart(key, file.name, RequestBody.create(MediaType.parse("application/octet-stream"), file))
          } else {
            val stringValue = value as String
            requestBodyBuilder.addFormDataPart(key, stringValue)
          }
          TODO("Handle other types inside FormDataMediaType")
        }

        return requestBodyBuilder.build()
      }
      mediaType == JsonMediaType -> return RequestBody.create(
          MediaType.parse(mediaType),
          when (content) {
            null -> ""
            else -> json.stringify(serializer, content)
          }
      )
      mediaType == XmlMediaType -> TODO("xml not currently supported.")
    }

    // TODO: this should be extended with other serializers
    TODO("requestBody currently only supports JSON body and File body.")
  }

  protected inline fun <reified T> responseBody(response: Response, serializer: KSerializer<T>): T? {
    val contentType = response.header("Content-Type") ?: JsonMediaType
    return when {
      response.body() == null -> null
      T::class == java.io.File::class -> downloadFileFromResponse(response) as T
      T::class == kotlin.Unit::class -> kotlin.Unit as T
      contentType.isJson -> {
        val inbound = response.body()?.string()
        when (inbound) {
          null -> null
          else -> json.parse(serializer, inbound)
        }
      }
      contentType == String::class.java.name -> response.body().toString() as T
      else -> TODO("Unknown response type")
    }
  }

  val String?.isJson: Boolean get() {
    val jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$"
    return this != null && (this.matches(jsonMime.toRegex()) || this == "*/*")
  }

  protected inline fun <reified R, reified T> request(requestConfig: RequestConfig, body: R? = null,
                                                      responseParser: KSerializer<T>,
                                                      requestSerializer: KSerializer<R>): ApiResponse<T?> {

    val httpUrl = HttpUrl.parse(baseUrl)
        ?: throw IllegalStateException("baseUrl $baseUrl is invalid.")

    var urlBuilder = httpUrl.newBuilder()
        .addPathSegments(requestConfig.path.trimStart('/'))

    requestConfig.query.forEach { query ->
      query.value.forEach { queryValue ->
        urlBuilder = urlBuilder.addQueryParameter(query.key, queryValue)
      }
    }

    val url = urlBuilder.build()
    val headers = defaultHeaders + requestConfig.headers + authHeaders

    if (headers[ContentType].isNullOrBlank()) {
      throw IllegalStateException("Missing Content-Type header. This is required.")
    }

    if (headers[Accept].isNullOrBlank()) {
      throw IllegalStateException("Missing Accept header. This is required.")
    }

    // TODO: support multiple contentType,accept options here.
    val contentType = (headers[ContentType])?.substringBefore(";")?.toLowerCase()
        ?: "application/json"
    val accept = (headers[Accept])?.substringBefore(";")?.toLowerCase() ?: "application/json"

    var request: Request.Builder = when (requestConfig.method) {
      RequestMethod.DELETE -> Request.Builder().url(url).delete()
      RequestMethod.GET -> Request.Builder().url(url)
      RequestMethod.HEAD -> Request.Builder().url(url).head()
      RequestMethod.PATCH -> Request.Builder().url(url).patch(requestBody(body, contentType, requestSerializer))
      RequestMethod.PUT -> Request.Builder().url(url).put(requestBody(body, contentType, requestSerializer))
      RequestMethod.POST -> Request.Builder().url(url).post(requestBody(body, contentType, requestSerializer))
      RequestMethod.OPTIONS -> Request.Builder().url(url).method("OPTIONS", null)
    }

    headers.forEach { request = request.addHeader(it.key, it.value) }

    val realRequest = request.build()
    val response = client.newCall(realRequest).execute()

    // TODO: handle specific mapping types. e.g. Map<int, Class<?>>
    when {
      response.isRedirect -> return Redirection(
          response.code(),
          response.headers().toMultimap()
      )
      response.isInformational -> return Informational(
          response.message(),
          response.code(),
          response.headers().toMultimap()
      )
      response.isSuccessful -> return Success(
          responseBody(response, responseParser),
          response.code(),
          response.headers().toMultimap()
      )
      response.isClientError -> return ClientError(
          response.body()?.string(),
          response.code(),
          response.headers().toMultimap()
      )
      else -> return ServerError(
          null,
          response.body()?.string(),
          response.code(),
          response.headers().toMultimap()
      )
    }
  }

  @Throws(IOException::class)
  fun downloadFileFromResponse(response: Response): File {
    val file = prepareDownloadFile(response)

    response.body()?.byteStream().use { input ->
      File(file.path).outputStream().use { input?.copyTo(it) }
    }

    return file
  }

  @Throws(IOException::class)
  fun prepareDownloadFile(response: Response): File {
    val filename: String?
    val contentDisposition = response.header("Content-Disposition")

    if (!contentDisposition.isNullOrBlank()) {
      val matcher = fileNamePattern.matcher(contentDisposition)

      if (matcher.find()) {
        filename = matcher.group(1)
      } else {
        filename = null
      }
    } else {
      filename = null
    }

    var prefix: String
    var suffix: String? = null

    if (filename == null) {
      prefix = "download-"
      suffix = ""
    } else {
      val pos = filename.lastIndexOf('.')

      if (pos == -1) {
        prefix = "$filename-";
      } else {
        prefix = filename.substring(0, pos) + "-"
        suffix = filename.substring(pos)
      }

      // File.createTempFile requires the prefix to be at least three characters long
      if (prefix.length < 3) {
        prefix = "download-"
      }
    }

    return File.createTempFile(prefix, suffix)
  }
}
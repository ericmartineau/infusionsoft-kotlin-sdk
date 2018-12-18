package io.mverse.client.infusionsoft.infrastructure

import com.google.gson.Gson
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

open class ApiClient(val basePath: String, val bearerToken: String, val gson: Gson) {

  val authHeaders: Map<String, String> = mapOf("Authorization" to "Bearer $bearerToken")

  companion object {
    val fileNamePattern:Pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?")
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

  protected fun <T> requestBody(content: T?, mediaType: String = JsonMediaType): RequestBody {
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
          illegalState("Handle other types inside FormDataMediaType")
        }

        return requestBodyBuilder.build()
      }
      mediaType == JsonMediaType -> return RequestBody.create(MediaType.parse(mediaType), gson.toJson(content))
      mediaType == XmlMediaType -> illegalState("No content negotiation for xml yet")
    }
    illegalState("requestBody currently only supports JSON body and File body.")
  }

  val String?.isJson: Boolean get() {
    val jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$"
    return this != null && (this.matches(jsonMime.toRegex()) || this == "*/*")
  }

  protected fun request(requestConfig: RequestConfig): ApiResponse {
    return request(requestConfig, null)
  }

  protected fun request(requestConfig: RequestConfig, body: Any?): ApiResponse {

    val httpUrl = HttpUrl.parse(basePath)
        ?: throw IllegalStateException("baseUrl $basePath is invalid.")

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

    var request: Request.Builder = when (requestConfig.method) {
      RequestMethod.DELETE -> Request.Builder().url(url).delete()
      RequestMethod.GET -> Request.Builder().url(url)
      RequestMethod.HEAD -> Request.Builder().url(url).head()
      RequestMethod.PATCH -> Request.Builder().url(url).patch(requestBody(body, contentType))
      RequestMethod.PUT -> Request.Builder().url(url).put(requestBody(body, contentType))
      RequestMethod.POST -> Request.Builder().url(url).post(requestBody(body, contentType))
      RequestMethod.OPTIONS -> Request.Builder().url(url).method("OPTIONS", null)
    }

    headers.forEach { request = request.addHeader(it.key, it.value) }

    val realRequest = request.build()
    val response = client.newCall(realRequest).execute()

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
          response.body()?.string(),
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
}
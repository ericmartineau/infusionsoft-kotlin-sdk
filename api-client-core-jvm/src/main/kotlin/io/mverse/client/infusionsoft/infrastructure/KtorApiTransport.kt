@file:Suppress("EXPERIMENTAL_API_USAGE")

package io.mverse.client.infusionsoft.infrastructure

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.HttpClientCall
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.CIOEngineConfig
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.http.takeFrom
import java.util.regex.Pattern

open class KtorApiTransport(val basePath: String, val bearerToken: String, val gson: Gson, configure: (HttpClientConfig<CIOEngineConfig>.() -> Unit)? = null) {
  val authHeaders: Map<String, String> = mapOf("Authorization" to "Bearer $bearerToken")
  val client = HttpClient(CIO) {
    install(JsonFeature) {
      serializer = GsonSerializer(gson)
    }
    when (configure) {
      null -> engine {
        maxConnectionsCount = 1000 // Maximum number of socket connections.
        endpoint.apply {
          maxConnectionsPerRoute = 100 // Maximum number of requests for a specific endpoint route.
          pipelineMaxSize = 50 // Max number of opened endpoints.
          keepAliveTime = 5000 // Max number of milliseconds to keep each connection alive.
          connectTimeout = 5000 // Number of milliseconds to wait trying to connect to the server.
          connectRetryAttempts = 5 // Maximum number of attempts for retrying a connection.
        }
      }
      else -> this.configure()
    }
  }

  companion object {
    val fileNamePattern: Pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?")
  }

  //  protected fun <T> requestBody(content: T?, mediaType: String = JsonMediaType): RequestBody {
  //    when {
  //      content is File -> return RequestBody.create(MediaType.parse(mediaType), content)
  //      mediaType == FormDataMediaType -> {
  //        val requestBodyBuilder = MultipartBody.Builder().setType(MultipartBody.FORM)
  //
  //        // content's type *must* be Map<String, Any>
  //        @Suppress("UNCHECKED_CAST")
  //        (content as Map<String, Any>).forEach { key, value ->
  //          if (value::class == File::class) {
  //            val file = value as File
  //            requestBodyBuilder.addFormDataPart(key, file.name, RequestBody.create(MediaType.parse("application/octet-stream"), file))
  //          } else {
  //            val stringValue = value as String
  //            requestBodyBuilder.addFormDataPart(key, stringValue)
  //          }
  //          illegalState("Handle other types inside FormDataMediaType")
  //        }
  //
  //        return requestBodyBuilder.build()
  //      }
  //      mediaType == JsonMediaType -> return RequestBody.create(MediaType.parse(mediaType), gson.toJson(content))
  //      mediaType == XmlMediaType -> illegalState("No content negotiation for xml yet")
  //    }
  //    illegalState("requestBody currently only supports JSON body and File body.")
  //  }

  //  val String?.isJson: Boolean
  //    get() {
  //      val jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$"
  //      return this != null && (this.matches(jsonMime.toRegex()) || this == "*/*")
  //    }

  protected suspend fun request(path: String, map: Map<String, Any>, block: HttpRequestBuilder.() -> Unit): HttpClientCall {
    val builder = HttpRequestBuilder()
    var merged = path
    map.forEach { query, replacement -> merged = merged.replace("{$query}", "$replacement") }
    builder.url.takeFrom(basePath + merged.trimStart('/'))
    builder.block()
    authHeaders.forEach(builder::header)
    return client.execute(builder)
  }
}

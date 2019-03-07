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
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.http.takeFrom
import java.net.URI

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

  protected fun uriTemplate(path: String): UriTemplate {
    return UriTemplate(basePath.trimEnd('/') + path)
  }

  protected suspend fun get(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Get, block)

  protected suspend fun post(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Post, block)

  protected suspend fun patch(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Patch, block)

  protected suspend fun put(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Put, block)

  protected suspend fun delete(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Delete, block)

  protected suspend fun head(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Head, block)

  protected suspend fun options(uri: URI, block: HttpRequestBuilder.() -> Unit): HttpClientCall =
      request(uri, HttpMethod.Options, block)

  protected suspend fun request(uri: URI, httpMethod: HttpMethod, block: HttpRequestBuilder.() -> Unit): HttpClientCall {
    val builder = HttpRequestBuilder()
    with(builder) {
      method = httpMethod
      url.takeFrom(uri)
      accept(Application.Json)
      block()
      authHeaders.forEach(::header)
    }
    return client.execute(builder)
  }

  fun HttpRequestBuilder.queryParam(name: String, value: Any?): HttpRequestBuilder = apply {
    when (value) {
      null -> { /* Do nothing*/
      }
      is Iterable<*> -> url.parameters.appendAll(name, value.map { "$it" })
      else -> url.parameters.append(name, "$value")
    }
  }

}

package io.mverse.client.infusionsoft.infrastructure

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.client.call.TypeInfo
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.ContentType
import io.ktor.http.content.OutgoingContent
import io.ktor.http.content.TextContent

/**
 * Allows [Gson] instance to serve as the [JsonSerializer] for a ktor client
 */
class GsonSerializer(private val backend: Gson) : JsonSerializer {
  constructor(block: GsonBuilder.() -> Unit = {}) : this(GsonBuilder().apply(block).create())

  override fun write(data: Any): OutgoingContent = TextContent(backend.toJson(data), ContentType.Application.Json)
  override suspend fun read(type: TypeInfo, response: HttpResponse): Any {
    val text = response.readText()
    return backend.fromJson(text, type.reifiedType)
  }
}

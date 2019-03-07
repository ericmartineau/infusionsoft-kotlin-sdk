package io.mverse.client.infusionsoft.infrastructure

import java.net.URI

/**
 * Simple utility that merges path parameters into a uri template.
 */
data class UriTemplate(private var uri: String) {
  fun parameter(key: String, value: Any?): UriTemplate = apply {
    uri = uri.replace("{$key}", "${value ?: ""}")
  }

  fun build(): URI {
    return URI(uri)
  }
}

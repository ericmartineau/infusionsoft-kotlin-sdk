package io.mverse.client.infusionsoft.infrastructure

import java.time.OffsetDateTime

data class OAuthToken(val accessToken:String, val refreshToken: String, val expiry: OffsetDateTime)

interface AccessTokenGenerator {
  fun accessToken(auth:OAuthToken, baseUrl: String): String
}
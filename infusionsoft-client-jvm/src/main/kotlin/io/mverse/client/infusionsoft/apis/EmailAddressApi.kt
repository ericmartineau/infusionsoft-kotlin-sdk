@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestEmailAddress
import io.mverse.client.infusionsoft.models.UpdateEmailAddress


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface EmailAddressApi {

  /**
    *  Replace an Email Address
    *  Replaces all of the values of a given email address
    *  * @param email email (optional)
    *  * @param update update (optional)
    *  * @return RestEmailAddress
    */
  suspend fun replaceEmailAddress(email: String, update: UpdateEmailAddress) : RestEmailAddress
  
  /**
    *  Asynchronous implementation of Replace an Email Address
    *  Replaces all of the values of a given email address
    *  * @param email email (optional)
    *  * @param update update (optional)
    *  * @return A deferred reference to the final RestEmailAddress  
    */
  fun replaceEmailAddressAsync(email: String, update: UpdateEmailAddress) : Deferred<RestEmailAddress>

}

class EmailAddressApiImpl(bearerToken:String, basePath: String, gson: Gson) : EmailAddressApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Replace an Email Address
    *  Replaces all of the values of a given email address
    *  * @param email email (optional)
    *  * @param update update (optional)
    *  * @return RestEmailAddress
    */
  override suspend fun replaceEmailAddress(email: String, update: UpdateEmailAddress) : RestEmailAddress {
    val uri = uriTemplate("/emailAddresses/{email}")
      .parameter("email", email)
      .build()
    val call = put(uri) {
      body = update ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Replace an Email Address
    *  Replaces all of the values of a given email address
    *  * @param email email (optional)
    *  * @param update update (optional)
    *  * @return A deferred reference to the final RestEmailAddress  
    */
  override fun replaceEmailAddressAsync(email: String, update: UpdateEmailAddress)  = 
        client.async { replaceEmailAddress(email, update) }

}
   

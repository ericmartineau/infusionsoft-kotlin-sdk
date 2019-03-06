@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestEmailAddress
import io.mverse.client.infusionsoft.models.UpdateEmailAddress


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface EmailAddressApi {

  /**
    *  Replace an Email Address
    *  Replaces all of the values of a given email address
    *  * @param email email (optional)
    *  * @param update update (optional)
    *  * @return RestEmailAddress
    */
  suspend fun replaceEmailAddress(email: String? = null, update: UpdateEmailAddress? = null) : RestEmailAddress
    
}

class EmailAddressApiImpl(bearerToken:String, basePath: String, gson: Gson) : EmailAddressApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Replace an Email Address
    *  Replaces all of the values of a given email address
    *  * @param email email (optional)
    *  * @param update update (optional)
    *  * @return RestEmailAddress
    */
  override suspend fun replaceEmailAddress(email: String?, update: UpdateEmailAddress?) : RestEmailAddress {
    val call = request( "/emailAddresses/{email}", mapOf("email" to "$email")) {
      method = HttpMethod.parse("PUT")
      body = update ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

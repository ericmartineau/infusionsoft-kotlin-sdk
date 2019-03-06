@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestMerchantAccountResponse


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface MerchantApi {

  /**
    *  List Merchants
    *  Retrieves a list of all merchant accounts
    *  * @return RestMerchantAccountResponse
    */
  suspend fun getMerchantAccounts() : RestMerchantAccountResponse
    
}

class MerchantApiImpl(bearerToken:String, basePath: String, gson: Gson) : MerchantApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  List Merchants
    *  Retrieves a list of all merchant accounts
    *  * @return RestMerchantAccountResponse
    */
  override suspend fun getMerchantAccounts() : RestMerchantAccountResponse {
    val call = request( "/merchants", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

}
   

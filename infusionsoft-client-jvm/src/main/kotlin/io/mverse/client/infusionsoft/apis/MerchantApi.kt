@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestMerchantAccountResponse


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


interface MerchantApi {

  /**
    *  List Merchants
    *  Retrieves a list of all merchant accounts
    *  * @return RestMerchantAccountResponse
    */
  suspend fun getMerchantAccounts() : RestMerchantAccountResponse
  
  /**
    *  Asynchronous implementation of List Merchants
    *  Retrieves a list of all merchant accounts
    *  * @return A deferred reference to the final RestMerchantAccountResponse  
    */
  fun getMerchantAccountsAsync() : Deferred<RestMerchantAccountResponse>

}

class MerchantApiImpl(bearerToken:String, basePath: String, gson: Gson) : MerchantApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  List Merchants
    *  Retrieves a list of all merchant accounts
    *  * @return RestMerchantAccountResponse
    */
  override suspend fun getMerchantAccounts() : RestMerchantAccountResponse {
    val uri = uriTemplate("/merchants")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Merchants
    *  Retrieves a list of all merchant accounts
    *  * @return A deferred reference to the final RestMerchantAccountResponse  
    */
  override fun getMerchantAccountsAsync()  = 
        client.async { getMerchantAccounts() }

}
   

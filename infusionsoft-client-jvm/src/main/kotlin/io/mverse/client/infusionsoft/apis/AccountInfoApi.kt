@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.AccountProfile
import io.mverse.client.infusionsoft.models.Error


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


interface AccountInfoApi {

  /**
    *  Retrieve account profile
    *  Retrieves profile/company info for an account.
    *  * @return AccountProfile
    */
  suspend fun getAccountProfile() : AccountProfile
  
  /**
    *  Asynchronous implementation of Retrieve account profile
    *  Retrieves profile/company info for an account.
    *  * @return A deferred reference to the final AccountProfile  
    */
  fun getAccountProfileAsync() : Deferred<AccountProfile>

  /**
    *  Updates an account profile
    *  Updates profile/company info for an account.
    *  * @param accountInfo accountInfo (optional)
    *  * @return AccountProfile
    */
  suspend fun updateAccountInfo(accountInfo: AccountProfile) : AccountProfile
  
  /**
    *  Asynchronous implementation of Updates an account profile
    *  Updates profile/company info for an account.
    *  * @param accountInfo accountInfo (optional)
    *  * @return A deferred reference to the final AccountProfile  
    */
  fun updateAccountInfoAsync(accountInfo: AccountProfile) : Deferred<AccountProfile>

}

class AccountInfoApiImpl(bearerToken:String, basePath: String, gson: Gson) : AccountInfoApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve account profile
    *  Retrieves profile/company info for an account.
    *  * @return AccountProfile
    */
  override suspend fun getAccountProfile() : AccountProfile {
    val uri = uriTemplate("/account/profile")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve account profile
    *  Retrieves profile/company info for an account.
    *  * @return A deferred reference to the final AccountProfile  
    */
  override fun getAccountProfileAsync()  = 
        client.async { getAccountProfile() }

  /**
    *  Updates an account profile
    *  Updates profile/company info for an account.
    *  * @param accountInfo accountInfo (optional)
    *  * @return AccountProfile
    */
  override suspend fun updateAccountInfo(accountInfo: AccountProfile) : AccountProfile {
    val uri = uriTemplate("/account/profile")
      .build()
    val call = put(uri) {
      body = accountInfo ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Updates an account profile
    *  Updates profile/company info for an account.
    *  * @param accountInfo accountInfo (optional)
    *  * @return A deferred reference to the final AccountProfile  
    */
  override fun updateAccountInfoAsync(accountInfo: AccountProfile)  = 
        client.async { updateAccountInfo(accountInfo) }

}
   

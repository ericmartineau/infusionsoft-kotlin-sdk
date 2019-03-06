@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.AccountProfile
import io.mverse.client.infusionsoft.models.Error


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface AccountInfoApi {

  /**
    *  Retrieve account profile
    *  Retrieves profile/company info for an account.
    *  * @return AccountProfile
    */
  suspend fun getAccountProfile() : AccountProfile
    
  /**
    *  Updates an account profile
    *  Updates profile/company info for an account.
    *  * @param accountInfo accountInfo (optional)
    *  * @return AccountProfile
    */
  suspend fun updateAccountInfo(accountInfo: AccountProfile? = null) : AccountProfile
    
}

class AccountInfoApiImpl(bearerToken:String, basePath: String, gson: Gson) : AccountInfoApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve account profile
    *  Retrieves profile/company info for an account.
    *  * @return AccountProfile
    */
  override suspend fun getAccountProfile() : AccountProfile {
    val call = request( "/account/profile", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Updates an account profile
    *  Updates profile/company info for an account.
    *  * @param accountInfo accountInfo (optional)
    *  * @return AccountProfile
    */
  override suspend fun updateAccountInfo(accountInfo: AccountProfile?) : AccountProfile {
    val call = request( "/account/profile", mapOf()) {
      method = HttpMethod.parse("PUT")
      body = accountInfo ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

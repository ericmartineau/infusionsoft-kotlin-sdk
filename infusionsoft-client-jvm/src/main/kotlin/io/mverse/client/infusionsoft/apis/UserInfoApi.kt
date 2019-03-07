@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.UserInfoDTO


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


interface UserInfoApi {

  /**
    *  Retrieve User Info
    *  Retrieves information for the current authenticated end-user, as outlined by the [OpenID Connect specification](http://openid.net/specs/openid-connect-core-1_0.html#UserInfo).
    *  * @return UserInfoDTO
    */
  suspend fun getUserInfo() : UserInfoDTO
  
  /**
    *  Asynchronous implementation of Retrieve User Info
    *  Retrieves information for the current authenticated end-user, as outlined by the [OpenID Connect specification](http://openid.net/specs/openid-connect-core-1_0.html#UserInfo).
    *  * @return A deferred reference to the final UserInfoDTO  
    */
  fun getUserInfoAsync() : Deferred<UserInfoDTO>

}

class UserInfoApiImpl(bearerToken:String, basePath: String, gson: Gson) : UserInfoApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve User Info
    *  Retrieves information for the current authenticated end-user, as outlined by the [OpenID Connect specification](http://openid.net/specs/openid-connect-core-1_0.html#UserInfo).
    *  * @return UserInfoDTO
    */
  override suspend fun getUserInfo() : UserInfoDTO {
    val uri = uriTemplate("/oauth/connect/userinfo")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve User Info
    *  Retrieves information for the current authenticated end-user, as outlined by the [OpenID Connect specification](http://openid.net/specs/openid-connect-core-1_0.html#UserInfo).
    *  * @return A deferred reference to the final UserInfoDTO  
    */
  override fun getUserInfoAsync()  = 
        client.async { getUserInfo() }

}
   

@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.CreateUser
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestUser
import io.mverse.client.infusionsoft.models.Users


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


interface UsersApi {

  /**
    *  Create a User
    *  Creates a new user record. NB: Users will be invited to the application and remain in the \"Invited\" status until the user accepts the invite. \"Inactive\" users will not take up a user license.
    *  * @param user user 
    *  * @return RestUser
    */
  suspend fun createUser(user: CreateUser? = null) : RestUser
  
  /**
    *  Asynchronous implementation of Create a User
    *  Creates a new user record. NB: Users will be invited to the application and remain in the \"Invited\" status until the user accepts the invite. \"Inactive\" users will not take up a user license.
    *  * @param user user 
    *  * @return A deferred reference to the final RestUser  
    */
  fun createUserAsync(user: CreateUser? = null) : Deferred<RestUser>

  /**
    *  List Users
    *  Retrieves a list of all users
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param includeInactive Include users that are Inactive in results, defaults to TRUE 
    *  * @param includePartners Include partner users in results, defaults to TRUE 
    *  * @return Users
    */
  suspend fun listUsers(limit: Int? = null, offset: Int? = null, includeInactive: Boolean? = null, includePartners: Boolean? = null) : Users
  
  /**
    *  Asynchronous implementation of List Users
    *  Retrieves a list of all users
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param includeInactive Include users that are Inactive in results, defaults to TRUE 
    *  * @param includePartners Include partner users in results, defaults to TRUE 
    *  * @return A deferred reference to the final Users  
    */
  fun listUsersAsync(limit: Int? = null, offset: Int? = null, includeInactive: Boolean? = null, includePartners: Boolean? = null) : Deferred<Users>

}

class UsersApiImpl(bearerToken:String, basePath: String, gson: Gson) : UsersApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a User
    *  Creates a new user record. NB: Users will be invited to the application and remain in the \"Invited\" status until the user accepts the invite. \"Inactive\" users will not take up a user license.
    *  * @param user user 
    *  * @return RestUser
    */
  override suspend fun createUser(user: CreateUser?) : RestUser {
    val uri = uriTemplate("/users")
      .build()
    val call = post(uri) {
      body = user ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a User
    *  Creates a new user record. NB: Users will be invited to the application and remain in the \"Invited\" status until the user accepts the invite. \"Inactive\" users will not take up a user license.
    *  * @param user user 
    *  * @return A deferred reference to the final RestUser  
    */
  override fun createUserAsync(user: CreateUser?)  = 
        client.async { createUser(user) }

  /**
    *  List Users
    *  Retrieves a list of all users
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param includeInactive Include users that are Inactive in results, defaults to TRUE 
    *  * @param includePartners Include partner users in results, defaults to TRUE 
    *  * @return Users
    */
  override suspend fun listUsers(limit: Int?, offset: Int?, includeInactive: Boolean?, includePartners: Boolean?) : Users {
    val uri = uriTemplate("/users")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("include_inactive",  includeInactive)
      queryParam("include_partners",  includePartners)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Users
    *  Retrieves a list of all users
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param includeInactive Include users that are Inactive in results, defaults to TRUE 
    *  * @param includePartners Include partner users in results, defaults to TRUE 
    *  * @return A deferred reference to the final Users  
    */
  override fun listUsersAsync(limit: Int?, offset: Int?, includeInactive: Boolean?, includePartners: Boolean?)  = 
        client.async { listUsers(limit, offset, includeInactive, includePartners) }

}
   

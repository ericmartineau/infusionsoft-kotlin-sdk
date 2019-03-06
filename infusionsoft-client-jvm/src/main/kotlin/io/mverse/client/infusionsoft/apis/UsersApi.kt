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
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface UsersApi {

  /**
    *  Create a User
    *  Creates a new user record. NB: Users will be invited to the application and remain in the \"Invited\" status until the user accepts the invite. \"Inactive\" users will not take up a user license.
    *  * @param user user 
    *  * @return RestUser
    */
  suspend fun createUser(user: CreateUser) : RestUser
    
  /**
    *  List Users
    *  Retrieves a list of all users
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param includeInactive Include users that are Inactive in results, defaults to TRUE 
    *  * @param includePartners Include partner users in results, defaults to TRUE 
    *  * @return Users
    */
  suspend fun listUsers(limit: Int, offset: Int, includeInactive: Boolean, includePartners: Boolean) : Users
    
}

class UsersApiImpl(bearerToken:String, basePath: String, gson: Gson) : UsersApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a User
    *  Creates a new user record. NB: Users will be invited to the application and remain in the \"Invited\" status until the user accepts the invite. \"Inactive\" users will not take up a user license.
    *  * @param user user 
    *  * @return RestUser
    */
  override suspend fun createUser(user: CreateUser) : RestUser {
    val call = request( "/users", mapOf()) {
      method = HttpMethod.parse("POST")
      body = user ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  List Users
    *  Retrieves a list of all users
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param includeInactive Include users that are Inactive in results, defaults to TRUE 
    *  * @param includePartners Include partner users in results, defaults to TRUE 
    *  * @return Users
    */
  override suspend fun listUsers(limit: Int, offset: Int, includeInactive: Boolean, includePartners: Boolean) : Users {
    val call = request( "/users", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (includeInactive != null) url.parameters.append("include_inactive", "$includeInactive")
      
    
      if (includePartners != null) url.parameters.append("include_partners", "$includePartners")
      
    
    }
    return call.receive()
  }

}
   

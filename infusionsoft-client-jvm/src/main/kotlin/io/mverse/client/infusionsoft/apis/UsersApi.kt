/**
* Infusionsoft REST API
* No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
*
* OpenAPI spec version: 1.70.0.72014
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.CreateUser
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestUser
import io.mverse.client.infusionsoft.models.Users

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*




class UsersApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Create a User
    * Creates a new user record. NB: Users will be invited to the application and remain in the \&quot;Invited\&quot; status until the user accepts the invite. \&quot;Inactive\&quot; users will not take up a user license.
    * @param user user (optional)
    * @return RestUser
    */
    @Suppress("UNCHECKED_CAST")
    fun createUser(user: CreateUser? = null) : RestUser {
       val requestBody = user
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/users",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           
           
           RestUser.serializer()
           
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as RestUser
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Users
    * Retrieves a list of all users
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param includeInactive Include users that are Inactive in results, defaults to TRUE (optional)
    * @param includePartners Include partner users in results, defaults to TRUE (optional)
    * @return Users
    */
    @Suppress("UNCHECKED_CAST")
    fun listUsers(limit: Int? = null, offset: Int? = null, includeInactive: Boolean? = null, includePartners: Boolean? = null) : Users {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")
      if (includeInactive != null) localVariableQuery["include_inactive"] = listOf("$includeInactive")
      if (includePartners != null) localVariableQuery["include_partners"] = listOf("$includePartners")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/users",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           
           
           Users.serializer()
           
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Users
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

}

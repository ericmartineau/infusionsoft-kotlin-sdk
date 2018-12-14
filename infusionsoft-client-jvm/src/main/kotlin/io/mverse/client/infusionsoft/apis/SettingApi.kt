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

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.Setting

import io.mverse.client.infusionsoft.infrastructure.*

class SettingApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Retrieve application status
    * Retrieves whether the application is enabled
    * @return Setting
    */
    @Suppress("UNCHECKED_CAST")
    fun getApplicationEnabled() : Setting {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/setting/application/enabled",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, Setting>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Setting
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Contact types
    * Lists the Contact types in a comma-separated list
    * @return Setting
    */
    @Suppress("UNCHECKED_CAST")
    fun getContactOptionTypes() : Setting {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/setting/contact/optionTypes",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, Setting>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Setting
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

}

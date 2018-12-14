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
import io.mverse.client.infusionsoft.models.RestMerchantAccountResponse

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*




class MerchantApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * List Merchants
    * Retrieves a list of all merchant accounts
    * @return RestMerchantAccountResponse
    */
    @Suppress("UNCHECKED_CAST")
    fun getMerchantAccounts() : RestMerchantAccountResponse {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/merchants",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           
           
           RestMerchantAccountResponse.serializer()
           
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as RestMerchantAccountResponse
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

}

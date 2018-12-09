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

import io.mverse.client.infusionsoft.models.AffiliateCommissionList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel

import io.mverse.client.infusionsoft.infrastructure.*

class AffiliateApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Retrieve Affiliate Model
    * Get the custom fields for the Affiliate object
    * @return ObjectModel
    */
    @Suppress("UNCHECKED_CAST")
    fun retrieveAffiliateModel() : ObjectModel {
        val localVariableBody: Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/affiliates/model",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<ObjectModel>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ObjectModel
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Retrieve Commissions
    * Retrieve a list of Commissions based on Affiliate or Date Range
    * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param affiliateId Affiliate to retrieve commissions for (optional)
    * @return AffiliateCommissionList
    */
    @Suppress("UNCHECKED_CAST")
    fun searchCommissions(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, affiliateId: Long? = null) : AffiliateCommissionList {
        val localVariableBody: Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        if (since != null) localVariableQuery["since"] to listOf("$since")
if (until != null) localVariableQuery["until"] to listOf("$until")
if (limit != null) localVariableQuery["limit"] to listOf("$limit")
if (offset != null) localVariableQuery["offset"] to listOf("$offset")
if (affiliateId != null) localVariableQuery["affiliateId"] to listOf("$affiliateId")

        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/affiliates/commissions",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<AffiliateCommissionList>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as AffiliateCommissionList
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

}

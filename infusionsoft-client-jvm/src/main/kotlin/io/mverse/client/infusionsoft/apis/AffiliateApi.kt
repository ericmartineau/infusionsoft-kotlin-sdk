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
import kotlinx.serialization.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AffiliateApi(bearerToken:String, basePath: String, gson: Gson) : ApiClient(basePath, bearerToken, gson) {

  /**
   *  Retrieve Affiliate Model
   *  Get the custom fields for the Affiliate object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveAffiliateModel() : ObjectModel {
    val requestBody = null
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
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<ObjectModel>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Commissions
   *  Retrieve a list of Commissions based on Affiliate or Date Range
   *  * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param affiliateId Affiliate to retrieve commissions for (optional)
   *  * @return AffiliateCommissionList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun searchCommissions(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, affiliateId: Long? = null) : AffiliateCommissionList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (since != null) localVariableQuery["since"] = listOf("$since")
    if (until != null) localVariableQuery["until"] = listOf("$until")
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (affiliateId != null) localVariableQuery["affiliateId"] = listOf("$affiliateId")

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
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<AffiliateCommissionList>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
}

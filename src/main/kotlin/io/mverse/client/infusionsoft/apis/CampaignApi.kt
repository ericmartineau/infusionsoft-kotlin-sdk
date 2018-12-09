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

import io.mverse.client.infusionsoft.models.Campaign
import io.mverse.client.infusionsoft.models.CampaignList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.SetOfIds

import io.mverse.client.infusionsoft.infrastructure.*

class CampaignApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Add to Campaign Sequence
    * Adds a single contact to a campaign sequence
    * @param campaignId campaignId 
    * @param sequenceId sequenceId 
    * @param contactId contactId 
    * @return void
    */
    fun addContactToCampaignSequence(campaignId: Long, sequenceId: Long, contactId: Long) : Unit {
       val localVariableBody: Any? = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId}".replace("{"+"campaignId"+"}", "$campaignId").replace("{"+"sequenceId"+"}", "$sequenceId").replace("{"+"contactId"+"}", "$contactId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Unit>(
           localVariableConfig,
           localVariableBody
       )

       return when (response.responseType) {
           ResponseType.Success -> Unit
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Add Multiple to Campaign Sequence
    * Adds a list of contacts to a campaign sequence
    * @param campaignId campaignId 
    * @param sequenceId sequenceId 
    * @param ids ids 
    * @return Map<kotlin.String, String>
    */
    @Suppress("UNCHECKED_CAST")
    fun addContactsToCampaignSequence(campaignId: Long, sequenceId: Long, ids: SetOfIds) : Map<kotlin.String, String> {
       val localVariableBody: Any? = ids
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/campaigns/{campaignId}/sequences/{sequenceId}/contacts".replace("{"+"campaignId"+"}", "$campaignId").replace("{"+"sequenceId"+"}", "$sequenceId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Map<kotlin.String, String>>(
           localVariableConfig,
           localVariableBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Map<kotlin.String, String>
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Retrieve a Campaign
    * Retrieves a single campaign
    * @param campaignId campaignId 
    * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields &#x60;goals&#x60; and &#x60;sequences&#x60; aren&#39;t included, by default.) (optional)
    * @return Campaign
    */
    @Suppress("UNCHECKED_CAST")
    fun getCampaign(campaignId: Long, optionalProperties: List<String>? = null) : Campaign {
       val localVariableBody: Any? = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (optionalProperties != null) localVariableQuery["optional_properties"] = toMultiValue(optionalProperties!!.toList(), "multi")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/campaigns/{campaignId}".replace("{"+"campaignId"+"}", "$campaignId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Campaign>(
           localVariableConfig,
           localVariableBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Campaign
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Campaigns
    * Retrieves all campaigns for the authenticated user
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param searchText Optional text to search (optional)
    * @param order Attribute to order items by (optional)
    * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) (optional)
    * @return CampaignList
    */
    @Suppress("UNCHECKED_CAST")
    fun listCampaigns(limit: Int? = null, offset: Int? = null, searchText: String? = null, order: String? = null, orderDirection: String? = null) : CampaignList {
       val localVariableBody: Any? = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")
      if (searchText != null) localVariableQuery["search_text"] = listOf("$searchText")
      if (order != null) localVariableQuery["order"] = listOf("$order")
      if (orderDirection != null) localVariableQuery["order_direction"] = listOf("$orderDirection")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/campaigns",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<CampaignList>(
           localVariableConfig,
           localVariableBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as CampaignList
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Remove from Campaign Sequence
    * Removes a single contact from a campaign sequence
    * @param campaignId campaignId 
    * @param sequenceId sequenceId 
    * @param contactId contactId 
    * @return void
    */
    fun removeContactFromCampaignSequence(campaignId: Long, sequenceId: Long, contactId: Long) : Unit {
       val localVariableBody: Any? = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.DELETE,
           "/campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId}".replace("{"+"campaignId"+"}", "$campaignId").replace("{"+"sequenceId"+"}", "$sequenceId").replace("{"+"contactId"+"}", "$contactId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Unit>(
           localVariableConfig,
           localVariableBody
       )

       return when (response.responseType) {
           ResponseType.Success -> Unit
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Remove Multiple from Campaign Sequence
    * Removes a list of contacts from a campaign sequence
    * @param campaignId campaignId 
    * @param sequenceId sequenceId 
    * @param ids ids 
    * @return void
    */
    fun removeContactsFromCampaignSequence(campaignId: Long, sequenceId: Long, ids: SetOfIds) : Unit {
       val localVariableBody: Any? = ids
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.DELETE,
           "/campaigns/{campaignId}/sequences/{sequenceId}/contacts".replace("{"+"campaignId"+"}", "$campaignId").replace("{"+"sequenceId"+"}", "$sequenceId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Unit>(
           localVariableConfig,
           localVariableBody
       )

       return when (response.responseType) {
           ResponseType.Success -> Unit
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

}

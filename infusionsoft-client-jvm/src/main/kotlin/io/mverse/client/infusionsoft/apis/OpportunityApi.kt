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
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.Opportunity
import io.mverse.client.infusionsoft.models.OpportunityList
import io.mverse.client.infusionsoft.models.SalesPipeline

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*
import com.google.gson.Gson


class OpportunityApi(bearerToken:String, basePath: String, gson: Gson) : ApiClient(basePath, bearerToken, gson) {

  /**
   *  Create an Opportunity
   *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for &#x60;opportunity_title&#x60;, &#x60;contact&#x60;, and &#x60;stage&#x60;.
   *  * @param opportunity opportunity (optional)
   *  * @return Opportunity
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createOpportunity(opportunity: Opportunity? = null) : Opportunity {
    val requestBody = opportunity
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/opportunities",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Opportunity.serializer(),
      Opportunity.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Opportunity
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve an Opportunity
   *  Retrives a single opportunity
   *  * @param opportunityId opportunityId 
   *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as &#x60;custom_fields&#x60; aren&#39;t included, by default.) (optional)
   *  * @return Opportunity
   */ 
  @Suppress("UNCHECKED_CAST")
  fun getOpportunity(opportunityId: Long, optionalProperties: List<String>? = null) : Opportunity {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (optionalProperties != null) localVariableQuery["optional_properties"] = toMultiValue(optionalProperties!!.toList(), "multi")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/opportunities/{opportunityId}".replace("{"+"opportunityId"+"}", "$opportunityId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Opportunity.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Opportunity
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Opportunities
   *  Retrieves a list of all opportunities.  Please note: the sample response erroneously shows properties, such as _stage reasons_, that are unavailable through the list endpoint. Such properties are only available through the retrieve operation. Future versions of the Opportunity resource will correct the oversight.
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param userId Returns opportunities for the provided user id (optional)
   *  * @param stageId Returns opportunities for the provided stage id (optional)
   *  * @param searchTerm Returns opportunities that match any of the contact&#39;s &#x60;given_name&#x60;, &#x60;family_name&#x60;, &#x60;company_name&#x60;, and &#x60;email_addresses&#x60; (searches &#x60;EMAIL1&#x60; only) fields as well as &#x60;opportunity_title&#x60; (optional)
   *  * @param order Attribute to order items by (optional)
   *  * @return OpportunityList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listOpportunities(limit: Int? = null, offset: Int? = null, userId: Long? = null, stageId: Long? = null, searchTerm: String? = null, order: String? = null) : OpportunityList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (userId != null) localVariableQuery["user_id"] = listOf("$userId")
    if (stageId != null) localVariableQuery["stage_id"] = listOf("$stageId")
    if (searchTerm != null) localVariableQuery["search_term"] = listOf("$searchTerm")
    if (order != null) localVariableQuery["order"] = listOf("$order")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/opportunities",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      OpportunityList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as OpportunityList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Opportunity Stage Pipeline
   *  Retrieves a list of all opportunity stages with pipeline details
   *  * @return List<SalesPipeline>
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listOpportunityStagePipelines() : List<SalesPipeline> {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/opportunity/stage_pipeline",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      SalesPipeline.serializer().list,UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as List<SalesPipeline>
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Opportunity Model
   *  Get the custom fields for the Opportunity object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveOpportunityModel() : ObjectModel {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/opportunities/model",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ObjectModel.serializer(),UnitSerializer)

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
   *  Replace an Opportunity
   *  Replaces all values of a given opportunity
   *  * @param opportunity opportunity (optional)
   *  * @return Opportunity
   */ 
  @Suppress("UNCHECKED_CAST")
  fun updateOpportunity(opportunity: Opportunity? = null) : Opportunity {
    val requestBody = opportunity
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PUT,
       "/opportunities",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Opportunity.serializer(),
      Opportunity.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Opportunity
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Update an Opportunity
   *  Updates an opportunity with only the values provided in the request.
   *  * @param opportunityId opportunityId 
   *  * @param opportunity opportunity (optional)
   *  * @return Opportunity
   */ 
  @Suppress("UNCHECKED_CAST")
  fun updatePropertiesOnOpportunity(opportunityId: Long, opportunity: Opportunity? = null) : Opportunity {
    val requestBody = opportunity
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PATCH,
       "/opportunities/{opportunityId}".replace("{"+"opportunityId"+"}", "$opportunityId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Opportunity.serializer(),
      Opportunity.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Opportunity
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
}

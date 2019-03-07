@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.Opportunity
import io.mverse.client.infusionsoft.models.OpportunityList
import io.mverse.client.infusionsoft.models.SalesPipeline


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


interface OpportunityApi {

  /**
    *  Create an Opportunity
    *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for `opportunity_title`, `contact`, and `stage`.
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  suspend fun createOpportunity(opportunity: Opportunity? = null) : Opportunity
  
  /**
    *  Asynchronous implementation of Create an Opportunity
    *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for `opportunity_title`, `contact`, and `stage`.
    *  * @param opportunity opportunity 
    *  * @return A deferred reference to the final Opportunity  
    */
  fun createOpportunityAsync(opportunity: Opportunity? = null) : Deferred<Opportunity>

  /**
    *  Retrieve an Opportunity
    *  Retrives a single opportunity
    *  * @param opportunityId opportunityId (optional)
    *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.) 
    *  * @return Opportunity
    */
  suspend fun getOpportunity(opportunityId: Long, optionalProperties: List<String>? = null) : Opportunity
  
  /**
    *  Asynchronous implementation of Retrieve an Opportunity
    *  Retrives a single opportunity
    *  * @param opportunityId opportunityId (optional)
    *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.) 
    *  * @return A deferred reference to the final Opportunity  
    */
  fun getOpportunityAsync(opportunityId: Long, optionalProperties: List<String>? = null) : Deferred<Opportunity>

  /**
    *  List Opportunities
    *  Retrieves a list of all opportunities.  Please note: the sample response erroneously shows properties, such as _stage reasons_, that are unavailable through the list endpoint. Such properties are only available through the retrieve operation. Future versions of the Opportunity resource will correct the oversight.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Returns opportunities for the provided user id 
    *  * @param stageId Returns opportunities for the provided stage id 
    *  * @param searchTerm Returns opportunities that match any of the contact's `given_name`, `family_name`, `company_name`, and `email_addresses` (searches `EMAIL1` only) fields as well as `opportunity_title` 
    *  * @param order Attribute to order items by 
    *  * @return OpportunityList
    */
  suspend fun listOpportunities(limit: Int? = null, offset: Int? = null, userId: Long? = null, stageId: Long? = null, searchTerm: String? = null, order: String? = null) : OpportunityList
  
  /**
    *  Asynchronous implementation of List Opportunities
    *  Retrieves a list of all opportunities.  Please note: the sample response erroneously shows properties, such as _stage reasons_, that are unavailable through the list endpoint. Such properties are only available through the retrieve operation. Future versions of the Opportunity resource will correct the oversight.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Returns opportunities for the provided user id 
    *  * @param stageId Returns opportunities for the provided stage id 
    *  * @param searchTerm Returns opportunities that match any of the contact's `given_name`, `family_name`, `company_name`, and `email_addresses` (searches `EMAIL1` only) fields as well as `opportunity_title` 
    *  * @param order Attribute to order items by 
    *  * @return A deferred reference to the final OpportunityList  
    */
  fun listOpportunitiesAsync(limit: Int? = null, offset: Int? = null, userId: Long? = null, stageId: Long? = null, searchTerm: String? = null, order: String? = null) : Deferred<OpportunityList>

  /**
    *  List Opportunity Stage Pipeline
    *  Retrieves a list of all opportunity stages with pipeline details
    *  * @return List<SalesPipeline>
    */
  suspend fun listOpportunityStagePipelines() : List<SalesPipeline>
  
  /**
    *  Asynchronous implementation of List Opportunity Stage Pipeline
    *  Retrieves a list of all opportunity stages with pipeline details
    *  * @return A deferred reference to the final List<SalesPipeline>  
    */
  fun listOpportunityStagePipelinesAsync() : Deferred<List<SalesPipeline>>

  /**
    *  Retrieve Opportunity Model
    *  Get the custom fields for the Opportunity object
    *  * @return ObjectModel
    */
  suspend fun retrieveOpportunityModel() : ObjectModel
  
  /**
    *  Asynchronous implementation of Retrieve Opportunity Model
    *  Get the custom fields for the Opportunity object
    *  * @return A deferred reference to the final ObjectModel  
    */
  fun retrieveOpportunityModelAsync() : Deferred<ObjectModel>

  /**
    *  Replace an Opportunity
    *  Replaces all values of a given opportunity
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  suspend fun updateOpportunity(opportunity: Opportunity? = null) : Opportunity
  
  /**
    *  Asynchronous implementation of Replace an Opportunity
    *  Replaces all values of a given opportunity
    *  * @param opportunity opportunity 
    *  * @return A deferred reference to the final Opportunity  
    */
  fun updateOpportunityAsync(opportunity: Opportunity? = null) : Deferred<Opportunity>

  /**
    *  Update an Opportunity
    *  Updates an opportunity with only the values provided in the request.
    *  * @param opportunityId opportunityId (optional)
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  suspend fun updatePropertiesOnOpportunity(opportunityId: Long, opportunity: Opportunity? = null) : Opportunity
  
  /**
    *  Asynchronous implementation of Update an Opportunity
    *  Updates an opportunity with only the values provided in the request.
    *  * @param opportunityId opportunityId (optional)
    *  * @param opportunity opportunity 
    *  * @return A deferred reference to the final Opportunity  
    */
  fun updatePropertiesOnOpportunityAsync(opportunityId: Long, opportunity: Opportunity? = null) : Deferred<Opportunity>

}

class OpportunityApiImpl(bearerToken:String, basePath: String, gson: Gson) : OpportunityApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Opportunity
    *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for `opportunity_title`, `contact`, and `stage`.
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  override suspend fun createOpportunity(opportunity: Opportunity?) : Opportunity {
    val uri = uriTemplate("/opportunities")
      .build()
    val call = post(uri) {
      body = opportunity ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create an Opportunity
    *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for `opportunity_title`, `contact`, and `stage`.
    *  * @param opportunity opportunity 
    *  * @return A deferred reference to the final Opportunity  
    */
  override fun createOpportunityAsync(opportunity: Opportunity?)  = 
        client.async { createOpportunity(opportunity) }

  /**
    *  Retrieve an Opportunity
    *  Retrives a single opportunity
    *  * @param opportunityId opportunityId (optional)
    *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.) 
    *  * @return Opportunity
    */
  override suspend fun getOpportunity(opportunityId: Long, optionalProperties: List<String>?) : Opportunity {
    val uri = uriTemplate("/opportunities/{opportunityId}")
      .parameter("opportunityId", opportunityId)
      .build()
    val call = get(uri) {
      queryParam("optional_properties",  optionalProperties)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve an Opportunity
    *  Retrives a single opportunity
    *  * @param opportunityId opportunityId (optional)
    *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.) 
    *  * @return A deferred reference to the final Opportunity  
    */
  override fun getOpportunityAsync(opportunityId: Long, optionalProperties: List<String>?)  = 
        client.async { getOpportunity(opportunityId, optionalProperties) }

  /**
    *  List Opportunities
    *  Retrieves a list of all opportunities.  Please note: the sample response erroneously shows properties, such as _stage reasons_, that are unavailable through the list endpoint. Such properties are only available through the retrieve operation. Future versions of the Opportunity resource will correct the oversight.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Returns opportunities for the provided user id 
    *  * @param stageId Returns opportunities for the provided stage id 
    *  * @param searchTerm Returns opportunities that match any of the contact's `given_name`, `family_name`, `company_name`, and `email_addresses` (searches `EMAIL1` only) fields as well as `opportunity_title` 
    *  * @param order Attribute to order items by 
    *  * @return OpportunityList
    */
  override suspend fun listOpportunities(limit: Int?, offset: Int?, userId: Long?, stageId: Long?, searchTerm: String?, order: String?) : OpportunityList {
    val uri = uriTemplate("/opportunities")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("user_id",  userId)
      queryParam("stage_id",  stageId)
      queryParam("search_term",  searchTerm)
      queryParam("order",  order)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Opportunities
    *  Retrieves a list of all opportunities.  Please note: the sample response erroneously shows properties, such as _stage reasons_, that are unavailable through the list endpoint. Such properties are only available through the retrieve operation. Future versions of the Opportunity resource will correct the oversight.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Returns opportunities for the provided user id 
    *  * @param stageId Returns opportunities for the provided stage id 
    *  * @param searchTerm Returns opportunities that match any of the contact's `given_name`, `family_name`, `company_name`, and `email_addresses` (searches `EMAIL1` only) fields as well as `opportunity_title` 
    *  * @param order Attribute to order items by 
    *  * @return A deferred reference to the final OpportunityList  
    */
  override fun listOpportunitiesAsync(limit: Int?, offset: Int?, userId: Long?, stageId: Long?, searchTerm: String?, order: String?)  = 
        client.async { listOpportunities(limit, offset, userId, stageId, searchTerm, order) }

  /**
    *  List Opportunity Stage Pipeline
    *  Retrieves a list of all opportunity stages with pipeline details
    *  * @return List<SalesPipeline>
    */
  override suspend fun listOpportunityStagePipelines() : List<SalesPipeline> {
    val uri = uriTemplate("/opportunity/stage_pipeline")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Opportunity Stage Pipeline
    *  Retrieves a list of all opportunity stages with pipeline details
    *  * @return A deferred reference to the final List<SalesPipeline>  
    */
  override fun listOpportunityStagePipelinesAsync()  = 
        client.async { listOpportunityStagePipelines() }

  /**
    *  Retrieve Opportunity Model
    *  Get the custom fields for the Opportunity object
    *  * @return ObjectModel
    */
  override suspend fun retrieveOpportunityModel() : ObjectModel {
    val uri = uriTemplate("/opportunities/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Opportunity Model
    *  Get the custom fields for the Opportunity object
    *  * @return A deferred reference to the final ObjectModel  
    */
  override fun retrieveOpportunityModelAsync()  = 
        client.async { retrieveOpportunityModel() }

  /**
    *  Replace an Opportunity
    *  Replaces all values of a given opportunity
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  override suspend fun updateOpportunity(opportunity: Opportunity?) : Opportunity {
    val uri = uriTemplate("/opportunities")
      .build()
    val call = put(uri) {
      body = opportunity ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Replace an Opportunity
    *  Replaces all values of a given opportunity
    *  * @param opportunity opportunity 
    *  * @return A deferred reference to the final Opportunity  
    */
  override fun updateOpportunityAsync(opportunity: Opportunity?)  = 
        client.async { updateOpportunity(opportunity) }

  /**
    *  Update an Opportunity
    *  Updates an opportunity with only the values provided in the request.
    *  * @param opportunityId opportunityId (optional)
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  override suspend fun updatePropertiesOnOpportunity(opportunityId: Long, opportunity: Opportunity?) : Opportunity {
    val uri = uriTemplate("/opportunities/{opportunityId}")
      .parameter("opportunityId", opportunityId)
      .build()
    val call = patch(uri) {
      body = opportunity ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Update an Opportunity
    *  Updates an opportunity with only the values provided in the request.
    *  * @param opportunityId opportunityId (optional)
    *  * @param opportunity opportunity 
    *  * @return A deferred reference to the final Opportunity  
    */
  override fun updatePropertiesOnOpportunityAsync(opportunityId: Long, opportunity: Opportunity?)  = 
        client.async { updatePropertiesOnOpportunity(opportunityId, opportunity) }

}
   

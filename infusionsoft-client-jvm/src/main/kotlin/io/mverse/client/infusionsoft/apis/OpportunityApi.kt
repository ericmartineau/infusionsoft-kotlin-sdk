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
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface OpportunityApi {

  /**
    *  Create an Opportunity
    *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for `opportunity_title`, `contact`, and `stage`.
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  suspend fun createOpportunity(opportunity: Opportunity) : Opportunity
    
  /**
    *  Retrieve an Opportunity
    *  Retrives a single opportunity
    *  * @param opportunityId opportunityId (optional)
    *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.) 
    *  * @return Opportunity
    */
  suspend fun getOpportunity(opportunityId: Long? = null, optionalProperties: List<String>) : Opportunity
    
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
  suspend fun listOpportunities(limit: Int, offset: Int, userId: Long, stageId: Long, searchTerm: String, order: String) : OpportunityList
    
  /**
    *  List Opportunity Stage Pipeline
    *  Retrieves a list of all opportunity stages with pipeline details
    *  * @return List<SalesPipeline>
    */
  suspend fun listOpportunityStagePipelines() : List<SalesPipeline>
    
  /**
    *  Retrieve Opportunity Model
    *  Get the custom fields for the Opportunity object
    *  * @return ObjectModel
    */
  suspend fun retrieveOpportunityModel() : ObjectModel
    
  /**
    *  Replace an Opportunity
    *  Replaces all values of a given opportunity
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  suspend fun updateOpportunity(opportunity: Opportunity) : Opportunity
    
  /**
    *  Update an Opportunity
    *  Updates an opportunity with only the values provided in the request.
    *  * @param opportunityId opportunityId (optional)
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  suspend fun updatePropertiesOnOpportunity(opportunityId: Long? = null, opportunity: Opportunity) : Opportunity
    
}

class OpportunityApiImpl(bearerToken:String, basePath: String, gson: Gson) : OpportunityApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Opportunity
    *  Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for `opportunity_title`, `contact`, and `stage`.
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  override suspend fun createOpportunity(opportunity: Opportunity) : Opportunity {
    val call = request( "/opportunities", mapOf()) {
      method = HttpMethod.parse("POST")
      body = opportunity ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Retrieve an Opportunity
    *  Retrives a single opportunity
    *  * @param opportunityId opportunityId (optional)
    *  * @param optionalProperties Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.) 
    *  * @return Opportunity
    */
  override suspend fun getOpportunity(opportunityId: Long?, optionalProperties: List<String>) : Opportunity {
    val call = request( "/opportunities/{opportunityId}", mapOf("opportunityId" to "$opportunityId")) {
      method = HttpMethod.parse("GET")
      if (optionalProperties != null) url.parameters.appendAll("optional_properties",  optionalProperties.map {"$it"})
      
    
    }
    return call.receive()
  }

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
  override suspend fun listOpportunities(limit: Int, offset: Int, userId: Long, stageId: Long, searchTerm: String, order: String) : OpportunityList {
    val call = request( "/opportunities", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (userId != null) url.parameters.append("user_id", "$userId")
      
    
      if (stageId != null) url.parameters.append("stage_id", "$stageId")
      
    
      if (searchTerm != null) url.parameters.append("search_term", "$searchTerm")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
    }
    return call.receive()
  }

  /**
    *  List Opportunity Stage Pipeline
    *  Retrieves a list of all opportunity stages with pipeline details
    *  * @return List<SalesPipeline>
    */
  override suspend fun listOpportunityStagePipelines() : List<SalesPipeline> {
    val call = request( "/opportunity/stage_pipeline", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Retrieve Opportunity Model
    *  Get the custom fields for the Opportunity object
    *  * @return ObjectModel
    */
  override suspend fun retrieveOpportunityModel() : ObjectModel {
    val call = request( "/opportunities/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Replace an Opportunity
    *  Replaces all values of a given opportunity
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  override suspend fun updateOpportunity(opportunity: Opportunity) : Opportunity {
    val call = request( "/opportunities", mapOf()) {
      method = HttpMethod.parse("PUT")
      body = opportunity ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Update an Opportunity
    *  Updates an opportunity with only the values provided in the request.
    *  * @param opportunityId opportunityId (optional)
    *  * @param opportunity opportunity 
    *  * @return Opportunity
    */
  override suspend fun updatePropertiesOnOpportunity(opportunityId: Long?, opportunity: Opportunity) : Opportunity {
    val call = request( "/opportunities/{opportunityId}", mapOf("opportunityId" to "$opportunityId")) {
      method = HttpMethod.parse("PATCH")
      body = opportunity ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.AchieveApiGoalEvent
import io.mverse.client.infusionsoft.models.Campaign
import io.mverse.client.infusionsoft.models.CampaignList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.GoalEventResultDTO
import io.mverse.client.infusionsoft.models.SetOfIds


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface CampaignApi {

  /**
    *  Add to Campaign Sequence
    *  Adds a single contact to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun addContactToCampaignSequence(campaignId: Long? = null, sequenceId: Long? = null, contactId: Long? = null) : Unit
    
  /**
    *  Add Multiple to Campaign Sequence
    *  Adds a list of contacts to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return Map<kotlin.String, String>
    */
  suspend fun addContactsToCampaignSequence(campaignId: Long? = null, sequenceId: Long? = null, ids: SetOfIds? = null) : Map<kotlin.String, String>
    
  /**
    *  Achieve API Goal
    *  Achieves API goal for campaigns with matching integration, callName for a given contactId
    *  * @param integration integration (optional)
    *  * @param callName callName (optional)
    *  * @param goalEvent goalEvent (optional)
    *  * @return List<GoalEventResultDTO>
    */
  suspend fun createAchieveApiGoalEvent(integration: String? = null, callName: String? = null, goalEvent: AchieveApiGoalEvent? = null) : List<GoalEventResultDTO>
    
  /**
    *  Retrieve a Campaign
    *  Retrieves a single campaign
    *  * @param campaignId campaignId (optional)
    *  * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.) 
    *  * @return Campaign
    */
  suspend fun getCampaign(campaignId: Long? = null, optionalProperties: List<String>) : Campaign
    
  /**
    *  List Campaigns
    *  Retrieves all campaigns for the authenticated user
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param searchText Optional text to search 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @return CampaignList
    */
  suspend fun listCampaigns(limit: Int, offset: Int, searchText: String, order: String, orderDirection: String) : CampaignList
    
  /**
    *  Remove from Campaign Sequence
    *  Removes a single contact from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun removeContactFromCampaignSequence(campaignId: Long? = null, sequenceId: Long? = null, contactId: Long? = null) : Unit
    
  /**
    *  Remove Multiple from Campaign Sequence
    *  Removes a list of contacts from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  suspend fun removeContactsFromCampaignSequence(campaignId: Long? = null, sequenceId: Long? = null, ids: SetOfIds? = null) : Unit
    
}

class CampaignApiImpl(bearerToken:String, basePath: String, gson: Gson) : CampaignApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Add to Campaign Sequence
    *  Adds a single contact to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun addContactToCampaignSequence(campaignId: Long?, sequenceId: Long?, contactId: Long?) : Unit {
    val call = request( "/campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId}", mapOf("campaignId" to "$campaignId", "sequenceId" to "$sequenceId", "contactId" to "$contactId")) {
      method = HttpMethod.parse("POST")
    }
    return call.receive()
  }

  /**
    *  Add Multiple to Campaign Sequence
    *  Adds a list of contacts to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return Map<kotlin.String, String>
    */
  override suspend fun addContactsToCampaignSequence(campaignId: Long?, sequenceId: Long?, ids: SetOfIds?) : Map<kotlin.String, String> {
    val call = request( "/campaigns/{campaignId}/sequences/{sequenceId}/contacts", mapOf("campaignId" to "$campaignId", "sequenceId" to "$sequenceId")) {
      method = HttpMethod.parse("POST")
      body = ids ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Achieve API Goal
    *  Achieves API goal for campaigns with matching integration, callName for a given contactId
    *  * @param integration integration (optional)
    *  * @param callName callName (optional)
    *  * @param goalEvent goalEvent (optional)
    *  * @return List<GoalEventResultDTO>
    */
  override suspend fun createAchieveApiGoalEvent(integration: String?, callName: String?, goalEvent: AchieveApiGoalEvent?) : List<GoalEventResultDTO> {
    val call = request( "/campaigns/goals/{integration}/{callName}", mapOf("integration" to "$integration", "callName" to "$callName")) {
      method = HttpMethod.parse("POST")
      body = goalEvent ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Retrieve a Campaign
    *  Retrieves a single campaign
    *  * @param campaignId campaignId (optional)
    *  * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.) 
    *  * @return Campaign
    */
  override suspend fun getCampaign(campaignId: Long?, optionalProperties: List<String>) : Campaign {
    val call = request( "/campaigns/{campaignId}", mapOf("campaignId" to "$campaignId")) {
      method = HttpMethod.parse("GET")
      if (optionalProperties != null) url.parameters.appendAll("optional_properties",  optionalProperties.map {"$it"})
      
    
    }
    return call.receive()
  }

  /**
    *  List Campaigns
    *  Retrieves all campaigns for the authenticated user
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param searchText Optional text to search 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @return CampaignList
    */
  override suspend fun listCampaigns(limit: Int, offset: Int, searchText: String, order: String, orderDirection: String) : CampaignList {
    val call = request( "/campaigns", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (searchText != null) url.parameters.append("search_text", "$searchText")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
      if (orderDirection != null) url.parameters.append("order_direction", "$orderDirection")
      
    
    }
    return call.receive()
  }

  /**
    *  Remove from Campaign Sequence
    *  Removes a single contact from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun removeContactFromCampaignSequence(campaignId: Long?, sequenceId: Long?, contactId: Long?) : Unit {
    val call = request( "/campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId}", mapOf("campaignId" to "$campaignId", "sequenceId" to "$sequenceId", "contactId" to "$contactId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Remove Multiple from Campaign Sequence
    *  Removes a list of contacts from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  override suspend fun removeContactsFromCampaignSequence(campaignId: Long?, sequenceId: Long?, ids: SetOfIds?) : Unit {
    val call = request( "/campaigns/{campaignId}/sequences/{sequenceId}/contacts", mapOf("campaignId" to "$campaignId", "sequenceId" to "$sequenceId")) {
      method = HttpMethod.parse("DELETE")
      body = ids ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

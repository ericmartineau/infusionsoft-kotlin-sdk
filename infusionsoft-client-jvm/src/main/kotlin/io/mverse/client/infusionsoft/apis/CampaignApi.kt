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
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface CampaignApi {

  /**
    *  Add to Campaign Sequence
    *  Adds a single contact to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun addContactToCampaignSequence(campaignId: Long, sequenceId: Long, contactId: Long)
  
  /**
    *  Asynchronous implementation of Add to Campaign Sequence
    *  Adds a single contact to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun addContactToCampaignSequenceAsync(campaignId: Long, sequenceId: Long, contactId: Long) : Deferred<Unit>

  /**
    *  Add Multiple to Campaign Sequence
    *  Adds a list of contacts to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return Map<kotlin.String, String>
    */
  suspend fun addContactsToCampaignSequence(campaignId: Long, sequenceId: Long, ids: SetOfIds) : Map<kotlin.String, String>
  
  /**
    *  Asynchronous implementation of Add Multiple to Campaign Sequence
    *  Adds a list of contacts to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final Map<kotlin.String, String>  
    */
  fun addContactsToCampaignSequenceAsync(campaignId: Long, sequenceId: Long, ids: SetOfIds) : Deferred<Map<kotlin.String, String>>

  /**
    *  Achieve API Goal
    *  Achieves API goal for campaigns with matching integration, callName for a given contactId
    *  * @param integration integration (optional)
    *  * @param callName callName (optional)
    *  * @param goalEvent goalEvent (optional)
    *  * @return List<GoalEventResultDTO>
    */
  suspend fun createAchieveApiGoalEvent(integration: String, callName: String, goalEvent: AchieveApiGoalEvent) : List<GoalEventResultDTO>
  
  /**
    *  Asynchronous implementation of Achieve API Goal
    *  Achieves API goal for campaigns with matching integration, callName for a given contactId
    *  * @param integration integration (optional)
    *  * @param callName callName (optional)
    *  * @param goalEvent goalEvent (optional)
    *  * @return A deferred reference to the final List<GoalEventResultDTO>  
    */
  fun createAchieveApiGoalEventAsync(integration: String, callName: String, goalEvent: AchieveApiGoalEvent) : Deferred<List<GoalEventResultDTO>>

  /**
    *  Retrieve a Campaign
    *  Retrieves a single campaign
    *  * @param campaignId campaignId (optional)
    *  * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.) 
    *  * @return Campaign
    */
  suspend fun getCampaign(campaignId: Long, optionalProperties: List<String>? = null) : Campaign
  
  /**
    *  Asynchronous implementation of Retrieve a Campaign
    *  Retrieves a single campaign
    *  * @param campaignId campaignId (optional)
    *  * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.) 
    *  * @return A deferred reference to the final Campaign  
    */
  fun getCampaignAsync(campaignId: Long, optionalProperties: List<String>? = null) : Deferred<Campaign>

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
  suspend fun listCampaigns(limit: Int? = null, offset: Int? = null, searchText: String? = null, order: String? = null, orderDirection: String? = null) : CampaignList
  
  /**
    *  Asynchronous implementation of List Campaigns
    *  Retrieves all campaigns for the authenticated user
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param searchText Optional text to search 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @return A deferred reference to the final CampaignList  
    */
  fun listCampaignsAsync(limit: Int? = null, offset: Int? = null, searchText: String? = null, order: String? = null, orderDirection: String? = null) : Deferred<CampaignList>

  /**
    *  Remove from Campaign Sequence
    *  Removes a single contact from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun removeContactFromCampaignSequence(campaignId: Long, sequenceId: Long, contactId: Long)
  
  /**
    *  Asynchronous implementation of Remove from Campaign Sequence
    *  Removes a single contact from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun removeContactFromCampaignSequenceAsync(campaignId: Long, sequenceId: Long, contactId: Long) : Deferred<Unit>

  /**
    *  Remove Multiple from Campaign Sequence
    *  Removes a list of contacts from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  suspend fun removeContactsFromCampaignSequence(campaignId: Long, sequenceId: Long, ids: SetOfIds)
  
  /**
    *  Asynchronous implementation of Remove Multiple from Campaign Sequence
    *  Removes a list of contacts from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final void  
    */
  fun removeContactsFromCampaignSequenceAsync(campaignId: Long, sequenceId: Long, ids: SetOfIds) : Deferred<Unit>

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
  override suspend fun addContactToCampaignSequence(campaignId: Long, sequenceId: Long, contactId: Long) {
    val uri = uriTemplate("/campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId}")
      .parameter("campaignId", campaignId)
      .parameter("sequenceId", sequenceId)
      .parameter("contactId", contactId)
      .build()
    val call = post(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Add to Campaign Sequence
    *  Adds a single contact to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun addContactToCampaignSequenceAsync(campaignId: Long, sequenceId: Long, contactId: Long)  = 
        client.async { addContactToCampaignSequence(campaignId, sequenceId, contactId) }

  /**
    *  Add Multiple to Campaign Sequence
    *  Adds a list of contacts to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return Map<kotlin.String, String>
    */
  override suspend fun addContactsToCampaignSequence(campaignId: Long, sequenceId: Long, ids: SetOfIds) : Map<kotlin.String, String> {
    val uri = uriTemplate("/campaigns/{campaignId}/sequences/{sequenceId}/contacts")
      .parameter("campaignId", campaignId)
      .parameter("sequenceId", sequenceId)
      .build()
    val call = post(uri) {
      body = ids ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Add Multiple to Campaign Sequence
    *  Adds a list of contacts to a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final Map<kotlin.String, String>  
    */
  override fun addContactsToCampaignSequenceAsync(campaignId: Long, sequenceId: Long, ids: SetOfIds)  = 
        client.async { addContactsToCampaignSequence(campaignId, sequenceId, ids) }

  /**
    *  Achieve API Goal
    *  Achieves API goal for campaigns with matching integration, callName for a given contactId
    *  * @param integration integration (optional)
    *  * @param callName callName (optional)
    *  * @param goalEvent goalEvent (optional)
    *  * @return List<GoalEventResultDTO>
    */
  override suspend fun createAchieveApiGoalEvent(integration: String, callName: String, goalEvent: AchieveApiGoalEvent) : List<GoalEventResultDTO> {
    val uri = uriTemplate("/campaigns/goals/{integration}/{callName}")
      .parameter("integration", integration)
      .parameter("callName", callName)
      .build()
    val call = post(uri) {
      body = goalEvent ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Achieve API Goal
    *  Achieves API goal for campaigns with matching integration, callName for a given contactId
    *  * @param integration integration (optional)
    *  * @param callName callName (optional)
    *  * @param goalEvent goalEvent (optional)
    *  * @return A deferred reference to the final List<GoalEventResultDTO>  
    */
  override fun createAchieveApiGoalEventAsync(integration: String, callName: String, goalEvent: AchieveApiGoalEvent)  = 
        client.async { createAchieveApiGoalEvent(integration, callName, goalEvent) }

  /**
    *  Retrieve a Campaign
    *  Retrieves a single campaign
    *  * @param campaignId campaignId (optional)
    *  * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.) 
    *  * @return Campaign
    */
  override suspend fun getCampaign(campaignId: Long, optionalProperties: List<String>?) : Campaign {
    val uri = uriTemplate("/campaigns/{campaignId}")
      .parameter("campaignId", campaignId)
      .build()
    val call = get(uri) {
      queryParam("optional_properties",  optionalProperties)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Campaign
    *  Retrieves a single campaign
    *  * @param campaignId campaignId (optional)
    *  * @param optionalProperties Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.) 
    *  * @return A deferred reference to the final Campaign  
    */
  override fun getCampaignAsync(campaignId: Long, optionalProperties: List<String>?)  = 
        client.async { getCampaign(campaignId, optionalProperties) }

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
  override suspend fun listCampaigns(limit: Int?, offset: Int?, searchText: String?, order: String?, orderDirection: String?) : CampaignList {
    val uri = uriTemplate("/campaigns")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("search_text",  searchText)
      queryParam("order",  order)
      queryParam("order_direction",  orderDirection)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Campaigns
    *  Retrieves all campaigns for the authenticated user
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param searchText Optional text to search 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @return A deferred reference to the final CampaignList  
    */
  override fun listCampaignsAsync(limit: Int?, offset: Int?, searchText: String?, order: String?, orderDirection: String?)  = 
        client.async { listCampaigns(limit, offset, searchText, order, orderDirection) }

  /**
    *  Remove from Campaign Sequence
    *  Removes a single contact from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun removeContactFromCampaignSequence(campaignId: Long, sequenceId: Long, contactId: Long) {
    val uri = uriTemplate("/campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId}")
      .parameter("campaignId", campaignId)
      .parameter("sequenceId", sequenceId)
      .parameter("contactId", contactId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Remove from Campaign Sequence
    *  Removes a single contact from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun removeContactFromCampaignSequenceAsync(campaignId: Long, sequenceId: Long, contactId: Long)  = 
        client.async { removeContactFromCampaignSequence(campaignId, sequenceId, contactId) }

  /**
    *  Remove Multiple from Campaign Sequence
    *  Removes a list of contacts from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  override suspend fun removeContactsFromCampaignSequence(campaignId: Long, sequenceId: Long, ids: SetOfIds) {
    val uri = uriTemplate("/campaigns/{campaignId}/sequences/{sequenceId}/contacts")
      .parameter("campaignId", campaignId)
      .parameter("sequenceId", sequenceId)
      .build()
    val call = delete(uri) {
      body = ids ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Remove Multiple from Campaign Sequence
    *  Removes a list of contacts from a campaign sequence
    *  * @param campaignId campaignId (optional)
    *  * @param sequenceId sequenceId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun removeContactsFromCampaignSequenceAsync(campaignId: Long, sequenceId: Long, ids: SetOfIds)  = 
        client.async { removeContactsFromCampaignSequence(campaignId, sequenceId, ids) }

}
   

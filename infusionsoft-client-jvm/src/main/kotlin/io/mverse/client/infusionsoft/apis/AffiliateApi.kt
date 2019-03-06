@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.AffiliateCommissionList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface AffiliateApi {

  /**
    *  Retrieve Affiliate Model
    *  Get the custom fields for the Affiliate object
    *  * @return ObjectModel
    */
  suspend fun retrieveAffiliateModel() : ObjectModel
    
  /**
    *  Retrieve Commissions
    *  Retrieve a list of Commissions based on Affiliate or Date Range
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param affiliateId Affiliate to retrieve commissions for 
    *  * @return AffiliateCommissionList
    */
  suspend fun searchCommissions(since: String, until: String, limit: Int, offset: Int, affiliateId: Long) : AffiliateCommissionList
    
}

class AffiliateApiImpl(bearerToken:String, basePath: String, gson: Gson) : AffiliateApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve Affiliate Model
    *  Get the custom fields for the Affiliate object
    *  * @return ObjectModel
    */
  override suspend fun retrieveAffiliateModel() : ObjectModel {
    val call = request( "/affiliates/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Retrieve Commissions
    *  Retrieve a list of Commissions based on Affiliate or Date Range
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param affiliateId Affiliate to retrieve commissions for 
    *  * @return AffiliateCommissionList
    */
  override suspend fun searchCommissions(since: String, until: String, limit: Int, offset: Int, affiliateId: Long) : AffiliateCommissionList {
    val call = request( "/affiliates/commissions", mapOf()) {
      method = HttpMethod.parse("GET")
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (affiliateId != null) url.parameters.append("affiliateId", "$affiliateId")
      
    
    }
    return call.receive()
  }

}
   

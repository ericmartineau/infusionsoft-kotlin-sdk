@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.AffiliateCommissionList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel


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


interface AffiliateApi {

  /**
    *  Retrieve Affiliate Model
    *  Get the custom fields for the Affiliate object
    *  * @return ObjectModel
    */
  suspend fun retrieveAffiliateModel() : ObjectModel
  
  /**
    *  Asynchronous implementation of Retrieve Affiliate Model
    *  Get the custom fields for the Affiliate object
    *  * @return A deferred reference to the final ObjectModel  
    */
  fun retrieveAffiliateModelAsync() : Deferred<ObjectModel>

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
  suspend fun searchCommissions(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, affiliateId: Long? = null) : AffiliateCommissionList
  
  /**
    *  Asynchronous implementation of Retrieve Commissions
    *  Retrieve a list of Commissions based on Affiliate or Date Range
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param affiliateId Affiliate to retrieve commissions for 
    *  * @return A deferred reference to the final AffiliateCommissionList  
    */
  fun searchCommissionsAsync(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, affiliateId: Long? = null) : Deferred<AffiliateCommissionList>

}

class AffiliateApiImpl(bearerToken:String, basePath: String, gson: Gson) : AffiliateApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve Affiliate Model
    *  Get the custom fields for the Affiliate object
    *  * @return ObjectModel
    */
  override suspend fun retrieveAffiliateModel() : ObjectModel {
    val uri = uriTemplate("/affiliates/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Affiliate Model
    *  Get the custom fields for the Affiliate object
    *  * @return A deferred reference to the final ObjectModel  
    */
  override fun retrieveAffiliateModelAsync()  = 
        client.async { retrieveAffiliateModel() }

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
  override suspend fun searchCommissions(since: String?, until: String?, limit: Int?, offset: Int?, affiliateId: Long?) : AffiliateCommissionList {
    val uri = uriTemplate("/affiliates/commissions")
      .build()
    val call = get(uri) {
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("affiliateId",  affiliateId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Commissions
    *  Retrieve a list of Commissions based on Affiliate or Date Range
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param affiliateId Affiliate to retrieve commissions for 
    *  * @return A deferred reference to the final AffiliateCommissionList  
    */
  override fun searchCommissionsAsync(since: String?, until: String?, limit: Int?, offset: Int?, affiliateId: Long?)  = 
        client.async { searchCommissions(since, until, limit, offset, affiliateId) }

}
   

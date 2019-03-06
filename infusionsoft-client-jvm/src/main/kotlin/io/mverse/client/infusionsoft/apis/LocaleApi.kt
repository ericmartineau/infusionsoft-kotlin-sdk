@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.CountriesByCode
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ProvincesByCode


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface LocaleApi {

  /**
    *  List Countries
    *  
    *  * @return CountriesByCode
    */
  suspend fun listCountries() : CountriesByCode
    
  /**
    *  List a Country's Provinces
    *  
    *  * @param countryCode countryCode (optional)
    *  * @return ProvincesByCode
    */
  suspend fun listCountries1(countryCode: String? = null) : ProvincesByCode
    
}

class LocaleApiImpl(bearerToken:String, basePath: String, gson: Gson) : LocaleApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  List Countries
    *  
    *  * @return CountriesByCode
    */
  override suspend fun listCountries() : CountriesByCode {
    val call = request( "/locales/countries", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List a Country's Provinces
    *  
    *  * @param countryCode countryCode (optional)
    *  * @return ProvincesByCode
    */
  override suspend fun listCountries1(countryCode: String?) : ProvincesByCode {
    val call = request( "/locales/countries/{countryCode}/provinces", mapOf("countryCode" to "$countryCode")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

}
   

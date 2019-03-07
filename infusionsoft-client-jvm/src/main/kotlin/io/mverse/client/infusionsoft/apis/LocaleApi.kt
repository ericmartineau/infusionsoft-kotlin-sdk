@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.CountriesByCode
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ProvincesByCode


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


interface LocaleApi {

  /**
    *  List Countries
    *  
    *  * @return CountriesByCode
    */
  suspend fun listCountries() : CountriesByCode
  
  /**
    *  Asynchronous implementation of List Countries
    *  
    *  * @return A deferred reference to the final CountriesByCode  
    */
  fun listCountriesAsync() : Deferred<CountriesByCode>

  /**
    *  List a Country's Provinces
    *  
    *  * @param countryCode countryCode (optional)
    *  * @return ProvincesByCode
    */
  suspend fun listCountries1(countryCode: String) : ProvincesByCode
  
  /**
    *  Asynchronous implementation of List a Country's Provinces
    *  
    *  * @param countryCode countryCode (optional)
    *  * @return A deferred reference to the final ProvincesByCode  
    */
  fun listCountries1Async(countryCode: String) : Deferred<ProvincesByCode>

}

class LocaleApiImpl(bearerToken:String, basePath: String, gson: Gson) : LocaleApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  List Countries
    *  
    *  * @return CountriesByCode
    */
  override suspend fun listCountries() : CountriesByCode {
    val uri = uriTemplate("/locales/countries")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Countries
    *  
    *  * @return A deferred reference to the final CountriesByCode  
    */
  override fun listCountriesAsync()  = 
        client.async { listCountries() }

  /**
    *  List a Country's Provinces
    *  
    *  * @param countryCode countryCode (optional)
    *  * @return ProvincesByCode
    */
  override suspend fun listCountries1(countryCode: String) : ProvincesByCode {
    val uri = uriTemplate("/locales/countries/{countryCode}/provinces")
      .parameter("countryCode", countryCode)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List a Country's Provinces
    *  
    *  * @param countryCode countryCode (optional)
    *  * @return A deferred reference to the final ProvincesByCode  
    */
  override fun listCountries1Async(countryCode: String)  = 
        client.async { listCountries1(countryCode) }

}
   

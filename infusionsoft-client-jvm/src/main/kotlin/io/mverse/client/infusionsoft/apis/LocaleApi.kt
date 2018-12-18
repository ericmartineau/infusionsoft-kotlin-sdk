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

import io.mverse.client.infusionsoft.models.CountriesByCode
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ProvincesByCode

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*
import com.google.gson.Gson


class LocaleApi(bearerToken:String, basePath: String, gson: Gson) : ApiClient(basePath, bearerToken, gson) {

  /**
   *  List Countries
   *  
   *  * @return CountriesByCode
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listCountries() : CountriesByCode {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/locales/countries",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      CountriesByCode.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as CountriesByCode
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List a Country&#39;s Provinces
   *  
   *  * @param countryCode countryCode 
   *  * @return ProvincesByCode
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listCountries1(countryCode: String) : ProvincesByCode {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/locales/countries/{countryCode}/provinces".replace("{"+"countryCode"+"}", "$countryCode"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ProvincesByCode.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ProvincesByCode
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
}

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

import io.mverse.client.infusionsoft.models.Company
import io.mverse.client.infusionsoft.models.CompanyList
import io.mverse.client.infusionsoft.models.CreateOrPatchCompany
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*
import com.google.gson.Gson


class CompanyApi(bearerToken:String, basePath: String, gson: Gson) : ApiClient(basePath, bearerToken, gson) {

  /**
   *  Create a Company
   *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The &#x60;country_code&#x60; is required if &#x60;region&#x60; is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Company gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;
   *  * @param company company (optional)
   *  * @return Company
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createCompany(company: CreateOrPatchCompany? = null) : Company {
    val requestBody = company
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/companies",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request<Company>(localVariableConfig, requestBody)

    return when (response) {
      is Success<*> -> response.data as Company
      is Informational<*> -> TODO()
      is Redirection<*> -> TODO()
      is ClientError<*> -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError<*> -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Companies
   *  Retrieves a list of all companies
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param companyName Optional company name to query on (optional)
   *  * @param order Attribute to order items by (optional)
   *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) (optional)
   *  * @param optionalProperties Comma-delimited list of Company properties to include in the response. (Fields such as &#x60;notes&#x60;, &#x60;fax_number&#x60; and &#x60;custom_fields&#x60; aren&#39;t included, by default.) (optional)
   *  * @return CompanyList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listCompanies(limit: Int? = null, offset: Int? = null, companyName: String? = null, order: String? = null, orderDirection: String? = null, optionalProperties: List<String>? = null) : CompanyList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (companyName != null) localVariableQuery["company_name"] = listOf("$companyName")
    if (order != null) localVariableQuery["order"] = listOf("$order")
    if (orderDirection != null) localVariableQuery["order_direction"] = listOf("$orderDirection")
    if (optionalProperties != null) localVariableQuery["optional_properties"] = toMultiValue(optionalProperties!!.toList(), "multi")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/companies",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request<CompanyList>(localVariableConfig, requestBody)

    return when (response) {
      is Success<*> -> response.data as CompanyList
      is Informational<*> -> TODO()
      is Redirection<*> -> TODO()
      is ClientError<*> -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError<*> -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Company Model
   *  Get the custom fields and optional properties for the Company object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveCompanyModel() : ObjectModel {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/companies/model",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request<ObjectModel>(localVariableConfig, requestBody)

    return when (response) {
      is Success<*> -> response.data as ObjectModel
      is Informational<*> -> TODO()
      is Redirection<*> -> TODO()
      is ClientError<*> -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError<*> -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Update a Company
   *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Company gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;
   *  * @param companyId companyId 
   *  * @param company company (optional)
   *  * @return Company
   */ 
  @Suppress("UNCHECKED_CAST")
  fun updatePropertiesOnContact(companyId: Long, company: CreateOrPatchCompany? = null) : Company {
    val requestBody = company
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PATCH,
       "/company/{companyId}".replace("{"+"companyId"+"}", "$companyId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request<Company>(localVariableConfig, requestBody)

    return when (response) {
      is Success<*> -> response.data as Company
      is Informational<*> -> TODO()
      is Redirection<*> -> TODO()
      is ClientError<*> -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError<*> -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
}

@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Company
import io.mverse.client.infusionsoft.models.CompanyList
import io.mverse.client.infusionsoft.models.CreateOrPatchCompany
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


interface CompanyApi {

  /**
    *  Create a Company
    *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The `country_code` is required if `region` is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param company company 
    *  * @return Company
    */
  suspend fun createCompany(company: CreateOrPatchCompany? = null) : Company
  
  /**
    *  Asynchronous implementation of Create a Company
    *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The `country_code` is required if `region` is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param company company 
    *  * @return A deferred reference to the final Company  
    */
  fun createCompanyAsync(company: CreateOrPatchCompany? = null) : Deferred<Company>

  /**
    *  List Companies
    *  Retrieves a list of all companies
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param companyName Optional company name to query on 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @param optionalProperties Comma-delimited list of Company properties to include in the response. (Fields such as `notes`, `fax_number` and `custom_fields` aren't included, by default.) 
    *  * @return CompanyList
    */
  suspend fun listCompanies(limit: Int? = null, offset: Int? = null, companyName: String? = null, order: String? = null, orderDirection: String? = null, optionalProperties: List<String>? = null) : CompanyList
  
  /**
    *  Asynchronous implementation of List Companies
    *  Retrieves a list of all companies
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param companyName Optional company name to query on 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @param optionalProperties Comma-delimited list of Company properties to include in the response. (Fields such as `notes`, `fax_number` and `custom_fields` aren't included, by default.) 
    *  * @return A deferred reference to the final CompanyList  
    */
  fun listCompaniesAsync(limit: Int? = null, offset: Int? = null, companyName: String? = null, order: String? = null, orderDirection: String? = null, optionalProperties: List<String>? = null) : Deferred<CompanyList>

  /**
    *  Retrieve Company Model
    *  Get the custom fields and optional properties for the Company object
    *  * @return ObjectModel
    */
  suspend fun retrieveCompanyModel() : ObjectModel
  
  /**
    *  Asynchronous implementation of Retrieve Company Model
    *  Get the custom fields and optional properties for the Company object
    *  * @return A deferred reference to the final ObjectModel  
    */
  fun retrieveCompanyModelAsync() : Deferred<ObjectModel>

  /**
    *  Update a Company
    *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param companyId companyId (optional)
    *  * @param company company 
    *  * @return Company
    */
  suspend fun updatePropertiesOnContact(companyId: Long, company: CreateOrPatchCompany? = null) : Company
  
  /**
    *  Asynchronous implementation of Update a Company
    *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param companyId companyId (optional)
    *  * @param company company 
    *  * @return A deferred reference to the final Company  
    */
  fun updatePropertiesOnContactAsync(companyId: Long, company: CreateOrPatchCompany? = null) : Deferred<Company>

}

class CompanyApiImpl(bearerToken:String, basePath: String, gson: Gson) : CompanyApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Company
    *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The `country_code` is required if `region` is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param company company 
    *  * @return Company
    */
  override suspend fun createCompany(company: CreateOrPatchCompany?) : Company {
    val uri = uriTemplate("/companies")
      .build()
    val call = post(uri) {
      body = company ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Company
    *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The `country_code` is required if `region` is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param company company 
    *  * @return A deferred reference to the final Company  
    */
  override fun createCompanyAsync(company: CreateOrPatchCompany?)  = 
        client.async { createCompany(company) }

  /**
    *  List Companies
    *  Retrieves a list of all companies
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param companyName Optional company name to query on 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @param optionalProperties Comma-delimited list of Company properties to include in the response. (Fields such as `notes`, `fax_number` and `custom_fields` aren't included, by default.) 
    *  * @return CompanyList
    */
  override suspend fun listCompanies(limit: Int?, offset: Int?, companyName: String?, order: String?, orderDirection: String?, optionalProperties: List<String>?) : CompanyList {
    val uri = uriTemplate("/companies")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("company_name",  companyName)
      queryParam("order",  order)
      queryParam("order_direction",  orderDirection)
      queryParam("optional_properties",  optionalProperties)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Companies
    *  Retrieves a list of all companies
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param companyName Optional company name to query on 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @param optionalProperties Comma-delimited list of Company properties to include in the response. (Fields such as `notes`, `fax_number` and `custom_fields` aren't included, by default.) 
    *  * @return A deferred reference to the final CompanyList  
    */
  override fun listCompaniesAsync(limit: Int?, offset: Int?, companyName: String?, order: String?, orderDirection: String?, optionalProperties: List<String>?)  = 
        client.async { listCompanies(limit, offset, companyName, order, orderDirection, optionalProperties) }

  /**
    *  Retrieve Company Model
    *  Get the custom fields and optional properties for the Company object
    *  * @return ObjectModel
    */
  override suspend fun retrieveCompanyModel() : ObjectModel {
    val uri = uriTemplate("/companies/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Company Model
    *  Get the custom fields and optional properties for the Company object
    *  * @return A deferred reference to the final ObjectModel  
    */
  override fun retrieveCompanyModelAsync()  = 
        client.async { retrieveCompanyModel() }

  /**
    *  Update a Company
    *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param companyId companyId (optional)
    *  * @param company company 
    *  * @return Company
    */
  override suspend fun updatePropertiesOnContact(companyId: Long, company: CreateOrPatchCompany?) : Company {
    val uri = uriTemplate("/company/{companyId}")
      .parameter("companyId", companyId)
      .build()
    val call = patch(uri) {
      body = company ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Update a Company
    *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param companyId companyId (optional)
    *  * @param company company 
    *  * @return A deferred reference to the final Company  
    */
  override fun updatePropertiesOnContactAsync(companyId: Long, company: CreateOrPatchCompany?)  = 
        client.async { updatePropertiesOnContact(companyId, company) }

}
   

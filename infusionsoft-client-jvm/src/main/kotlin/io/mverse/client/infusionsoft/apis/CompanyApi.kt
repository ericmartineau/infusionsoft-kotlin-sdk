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
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface CompanyApi {

  /**
    *  Create a Company
    *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The `country_code` is required if `region` is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param company company 
    *  * @return Company
    */
  suspend fun createCompany(company: CreateOrPatchCompany) : Company
    
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
  suspend fun listCompanies(limit: Int, offset: Int, companyName: String, order: String, orderDirection: String, optionalProperties: List<String>) : CompanyList
    
  /**
    *  Retrieve Company Model
    *  Get the custom fields and optional properties for the Company object
    *  * @return ObjectModel
    */
  suspend fun retrieveCompanyModel() : ObjectModel
    
  /**
    *  Update a Company
    *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param companyId companyId (optional)
    *  * @param company company 
    *  * @return Company
    */
  suspend fun updatePropertiesOnContact(companyId: Long? = null, company: CreateOrPatchCompany) : Company
    
}

class CompanyApiImpl(bearerToken:String, basePath: String, gson: Gson) : CompanyApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Company
    *  Creates a new company as the authenticated user. NB: Company must contain at least the company name. The `country_code` is required if `region` is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param company company 
    *  * @return Company
    */
  override suspend fun createCompany(company: CreateOrPatchCompany) : Company {
    val call = request( "/companies", mapOf()) {
      method = HttpMethod.parse("POST")
      body = company ?: EmptyContent
    
    }
    return call.receive()
  }

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
  override suspend fun listCompanies(limit: Int, offset: Int, companyName: String, order: String, orderDirection: String, optionalProperties: List<String>) : CompanyList {
    val call = request( "/companies", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (companyName != null) url.parameters.append("company_name", "$companyName")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
      if (orderDirection != null) url.parameters.append("order_direction", "$orderDirection")
      
    
      if (optionalProperties != null) url.parameters.appendAll("optional_properties",  optionalProperties.map {"$it"})
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Company Model
    *  Get the custom fields and optional properties for the Company object
    *  * @return ObjectModel
    */
  override suspend fun retrieveCompanyModel() : ObjectModel {
    val call = request( "/companies/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Update a Company
    *  Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Company gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param companyId companyId (optional)
    *  * @param company company 
    *  * @return Company
    */
  override suspend fun updatePropertiesOnContact(companyId: Long?, company: CreateOrPatchCompany) : Company {
    val call = request( "/company/{companyId}", mapOf("companyId" to "$companyId")) {
      method = HttpMethod.parse("PATCH")
      body = company ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

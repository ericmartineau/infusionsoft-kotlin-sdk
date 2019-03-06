@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.ContactCreditCard
import io.mverse.client.infusionsoft.models.ContactList
import io.mverse.client.infusionsoft.models.ContactTagList
import io.mverse.client.infusionsoft.models.CreateOrPatchContact
import io.mverse.client.infusionsoft.models.CreateRestCustomField
import io.mverse.client.infusionsoft.models.CreditCard
import io.mverse.client.infusionsoft.models.CreditCardAdded
import io.mverse.client.infusionsoft.models.CustomFieldMetaData
import io.mverse.client.infusionsoft.models.EmailSentCreate
import io.mverse.client.infusionsoft.models.EmailSentQueryResultList
import io.mverse.client.infusionsoft.models.EntryLongCommastring_
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.FullContact
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.TagId
import io.mverse.client.infusionsoft.models.UpsertContact


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface ContactApi {

  /**
    *  Apply Tags
    *  Apply a list of tags to a given contact record
    *  * @param contactId contactId (optional)
    *  * @param tagIds tagIds (optional)
    *  * @return List<EntryLongCommastring_>
    */
  suspend fun applyTagsToContactId(contactId: Long? = null, tagIds: TagId? = null) : List<EntryLongCommastring_>
    
  /**
    *  Create a Contact
    *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact 
    *  * @return FullContact
    */
  suspend fun createContact(contact: CreateOrPatchContact) : FullContact
    
  /**
    *  Create a Credit Card
    *  Creates a new credit card associated to a contact
    *  * @param contactId contactId (optional)
    *  * @param creditCard creditCard 
    *  * @return CreditCardAdded
    */
  suspend fun createCreditCard(contactId: Long? = null, creditCard: CreditCard) : CreditCardAdded
    
  /**
    *  Create a Custom Field
    *  Adds a custom field of the specified type and options to the Contact object.
    *  * @param customField customField (optional)
    *  * @return CustomFieldMetaData
    */
  suspend fun createCustomField(customField: CreateRestCustomField? = null) : CustomFieldMetaData
    
  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param contactId contactId (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  suspend fun createEmailForContact(contactId: Long? = null, emailWithContent: EmailSentCreate) : EmailSentCreate
    
  /**
    *  Create or Update a Contact
    *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified. Existing Contacts are updated with only the values provided in the request. Accepts a `duplicate_option` which performs duplicate checking by one of the following options: `Email`, `EmailAndName`, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the `duplicate_option` provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact 
    *  * @return FullContact
    */
  suspend fun createOrUpdateContact(contact: UpsertContact) : FullContact
    
  /**
    *  Delete a Contact
    *  Deletes the specified contact.   If a request header named `GDPR-Redact` is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun deleteContact(contactId: Long? = null) : Unit
    
  /**
    *  Retrieve a Contact
    *  Retrieves a single contact
    *  * @param id id (optional)
    *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.) 
    *  * @return FullContact
    */
  suspend fun getContact(id: Long? = null, optionalProperties: List<String>) : FullContact
    
  /**
    *  List Applied Tags
    *  Retrieves a list of tags applied to a given contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return ContactTagList
    */
  suspend fun listAppliedTags(contactId: Long? = null, limit: Int, offset: Int) : ContactTagList
    
  /**
    *  List Contacts
    *  Retrieves a list of all contacts
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param email Optional email address to query on 
    *  * @param givenName Optional first name or forename to query on 
    *  * @param familyName Optional last name or surname to query on 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @param since Date to start searching from on LastUpdated ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to on LastUpdated ex. `2017-01-01T22:17:59.039Z` 
    *  * @return ContactList
    */
  suspend fun listContacts(limit: Int, offset: Int, email: String, givenName: String, familyName: String, order: String, orderDirection: String, since: String, until: String) : ContactList
    
  /**
    *  Retrieve Credit Cards
    *  List all Credit Cards on a contact
    *  * @param contactId contactId (optional)
    *  * @return List<ContactCreditCard>
    */
  suspend fun listCreditCards(contactId: Long? = null) : List<ContactCreditCard>
    
  /**
    *  List Emails
    *  List Emails that have been sent to a Contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param email Optional email address to query on 
    *  * @return EmailSentQueryResultList
    */
  suspend fun listEmailsForContact(contactId: Long? = null, limit: Int, offset: Int, email: String) : EmailSentQueryResultList
    
  /**
    *  Remove Applied Tags
    *  Removes a list of tags from the given contact
    *  * @param contactId contactId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  suspend fun removeTagsFromContact(contactId: Long? = null, ids: String? = null) : Unit
    
  /**
    *  Remove Applied Tag
    *  Removes a tag from the given contact
    *  * @param contactId contactId (optional)
    *  * @param tagId tagId (optional)
    *  * @return void
    */
  suspend fun removeTagsFromContact1(contactId: Long? = null, tagId: Long? = null) : Unit
    
  /**
    *  Retrieve Contact Model
    *  Get the custom fields and optional properties for the Contact object
    *  * @return ObjectModel
    */
  suspend fun retrieveContactModel() : ObjectModel
    
  /**
    *  Update a Contact
    *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contactId contactId (optional)
    *  * @param contact contact 
    *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped. 
    *  * @return FullContact
    */
  suspend fun updatePropertiesOnContact1(contactId: Long? = null, contact: CreateOrPatchContact, updateMask: List<String>) : FullContact
    
}

class ContactApiImpl(bearerToken:String, basePath: String, gson: Gson) : ContactApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Apply Tags
    *  Apply a list of tags to a given contact record
    *  * @param contactId contactId (optional)
    *  * @param tagIds tagIds (optional)
    *  * @return List<EntryLongCommastring_>
    */
  override suspend fun applyTagsToContactId(contactId: Long?, tagIds: TagId?) : List<EntryLongCommastring_> {
    val call = request( "/contacts/{contactId}/tags", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("POST")
      body = tagIds ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create a Contact
    *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact 
    *  * @return FullContact
    */
  override suspend fun createContact(contact: CreateOrPatchContact) : FullContact {
    val call = request( "/contacts", mapOf()) {
      method = HttpMethod.parse("POST")
      body = contact ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create a Credit Card
    *  Creates a new credit card associated to a contact
    *  * @param contactId contactId (optional)
    *  * @param creditCard creditCard 
    *  * @return CreditCardAdded
    */
  override suspend fun createCreditCard(contactId: Long?, creditCard: CreditCard) : CreditCardAdded {
    val call = request( "/contacts/{contactId}/creditCards", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("POST")
      body = creditCard ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create a Custom Field
    *  Adds a custom field of the specified type and options to the Contact object.
    *  * @param customField customField (optional)
    *  * @return CustomFieldMetaData
    */
  override suspend fun createCustomField(customField: CreateRestCustomField?) : CustomFieldMetaData {
    val call = request( "/contacts/model/customFields", mapOf()) {
      method = HttpMethod.parse("POST")
      body = customField ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param contactId contactId (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  override suspend fun createEmailForContact(contactId: Long?, emailWithContent: EmailSentCreate) : EmailSentCreate {
    val call = request( "/contacts/{contactId}/emails", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("POST")
      body = emailWithContent ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create or Update a Contact
    *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified. Existing Contacts are updated with only the values provided in the request. Accepts a `duplicate_option` which performs duplicate checking by one of the following options: `Email`, `EmailAndName`, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the `duplicate_option` provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact 
    *  * @return FullContact
    */
  override suspend fun createOrUpdateContact(contact: UpsertContact) : FullContact {
    val call = request( "/contacts", mapOf()) {
      method = HttpMethod.parse("PUT")
      body = contact ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete a Contact
    *  Deletes the specified contact.   If a request header named `GDPR-Redact` is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun deleteContact(contactId: Long?) : Unit {
    val call = request( "/contacts/{contactId}", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve a Contact
    *  Retrieves a single contact
    *  * @param id id (optional)
    *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.) 
    *  * @return FullContact
    */
  override suspend fun getContact(id: Long?, optionalProperties: List<String>) : FullContact {
    val call = request( "/contacts/{id}", mapOf("id" to "$id")) {
      method = HttpMethod.parse("GET")
      if (optionalProperties != null) url.parameters.appendAll("optional_properties",  optionalProperties.map {"$it"})
      
    
    }
    return call.receive()
  }

  /**
    *  List Applied Tags
    *  Retrieves a list of tags applied to a given contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return ContactTagList
    */
  override suspend fun listAppliedTags(contactId: Long?, limit: Int, offset: Int) : ContactTagList {
    val call = request( "/contacts/{contactId}/tags", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
    }
    return call.receive()
  }

  /**
    *  List Contacts
    *  Retrieves a list of all contacts
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param email Optional email address to query on 
    *  * @param givenName Optional first name or forename to query on 
    *  * @param familyName Optional last name or surname to query on 
    *  * @param order Attribute to order items by 
    *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) 
    *  * @param since Date to start searching from on LastUpdated ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to on LastUpdated ex. `2017-01-01T22:17:59.039Z` 
    *  * @return ContactList
    */
  override suspend fun listContacts(limit: Int, offset: Int, email: String, givenName: String, familyName: String, order: String, orderDirection: String, since: String, until: String) : ContactList {
    val call = request( "/contacts", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (email != null) url.parameters.append("email", "$email")
      
    
      if (givenName != null) url.parameters.append("given_name", "$givenName")
      
    
      if (familyName != null) url.parameters.append("family_name", "$familyName")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
      if (orderDirection != null) url.parameters.append("order_direction", "$orderDirection")
      
    
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Credit Cards
    *  List all Credit Cards on a contact
    *  * @param contactId contactId (optional)
    *  * @return List<ContactCreditCard>
    */
  override suspend fun listCreditCards(contactId: Long?) : List<ContactCreditCard> {
    val call = request( "/contacts/{contactId}/creditCards", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Emails
    *  List Emails that have been sent to a Contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param email Optional email address to query on 
    *  * @return EmailSentQueryResultList
    */
  override suspend fun listEmailsForContact(contactId: Long?, limit: Int, offset: Int, email: String) : EmailSentQueryResultList {
    val call = request( "/contacts/{contactId}/emails", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (email != null) url.parameters.append("email", "$email")
      
    
    }
    return call.receive()
  }

  /**
    *  Remove Applied Tags
    *  Removes a list of tags from the given contact
    *  * @param contactId contactId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  override suspend fun removeTagsFromContact(contactId: Long?, ids: String?) : Unit {
    val call = request( "/contacts/{contactId}/tags", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("DELETE")
      if (ids != null) url.parameters.append("ids", "$ids")
      
    
    }
    return call.receive()
  }

  /**
    *  Remove Applied Tag
    *  Removes a tag from the given contact
    *  * @param contactId contactId (optional)
    *  * @param tagId tagId (optional)
    *  * @return void
    */
  override suspend fun removeTagsFromContact1(contactId: Long?, tagId: Long?) : Unit {
    val call = request( "/contacts/{contactId}/tags/{tagId}", mapOf("contactId" to "$contactId", "tagId" to "$tagId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve Contact Model
    *  Get the custom fields and optional properties for the Contact object
    *  * @return ObjectModel
    */
  override suspend fun retrieveContactModel() : ObjectModel {
    val call = request( "/contacts/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Update a Contact
    *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contactId contactId (optional)
    *  * @param contact contact 
    *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped. 
    *  * @return FullContact
    */
  override suspend fun updatePropertiesOnContact1(contactId: Long?, contact: CreateOrPatchContact, updateMask: List<String>) : FullContact {
    val call = request( "/contacts/{contactId}", mapOf("contactId" to "$contactId")) {
      method = HttpMethod.parse("PATCH")
      body = contact ?: EmptyContent
    
      if (updateMask != null) url.parameters.appendAll("update_mask",  updateMask.map {"$it"})
      
    
    }
    return call.receive()
  }

}
   

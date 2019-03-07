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
import io.mverse.client.infusionsoft.models.FullContact
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.TagId
import io.mverse.client.infusionsoft.models.UpsertContact


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface ContactApi {

  /**
    *  Apply Tags
    *  Apply a list of tags to a given contact record
    *  * @param contactId contactId (optional)
    *  * @param tagIds tagIds (optional)
    *  * @return List<EntryLongCommastring_>
    */
  suspend fun applyTagsToContactId(contactId: Long, tagIds: TagId) : Map<String, String>

  /**
    *  Asynchronous implementation of Apply Tags
    *  Apply a list of tags to a given contact record
    *  * @param contactId contactId (optional)
    *  * @param tagIds tagIds (optional)
    *  * @return A deferred reference to the final List<EntryLongCommastring_>
    */
  fun applyTagsToContactIdAsync(contactId: Long, tagIds: TagId) : Deferred<Map<String, String>>

  /**
    *  Create a Contact
    *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return FullContact
    */
  suspend fun createContact(contact: CreateOrPatchContact? = null) : FullContact

  /**
    *  Asynchronous implementation of Create a Contact
    *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return A deferred reference to the final FullContact
    */
  fun createContactAsync(contact: CreateOrPatchContact? = null) : Deferred<FullContact>

  /**
    *  Create a Credit Card
    *  Creates a new credit card associated to a contact
    *  * @param contactId contactId (optional)
    *  * @param creditCard creditCard
    *  * @return CreditCardAdded
    */
  suspend fun createCreditCard(contactId: Long, creditCard: CreditCard? = null) : CreditCardAdded

  /**
    *  Asynchronous implementation of Create a Credit Card
    *  Creates a new credit card associated to a contact
    *  * @param contactId contactId (optional)
    *  * @param creditCard creditCard
    *  * @return A deferred reference to the final CreditCardAdded
    */
  fun createCreditCardAsync(contactId: Long, creditCard: CreditCard? = null) : Deferred<CreditCardAdded>

  /**
    *  Create a Custom Field
    *  Adds a custom field of the specified type and options to the Contact object.
    *  * @param customField customField (optional)
    *  * @return CustomFieldMetaData
    */
  suspend fun createCustomField(customField: CreateRestCustomField) : CustomFieldMetaData

  /**
    *  Asynchronous implementation of Create a Custom Field
    *  Adds a custom field of the specified type and options to the Contact object.
    *  * @param customField customField (optional)
    *  * @return A deferred reference to the final CustomFieldMetaData
    */
  fun createCustomFieldAsync(customField: CreateRestCustomField) : Deferred<CustomFieldMetaData>

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param contactId contactId (optional)
    *  * @param emailWithContent Email records to persist, with content.
    *  * @return EmailSentCreate
    */
  suspend fun createEmailForContact(contactId: Long, emailWithContent: EmailSentCreate? = null) : EmailSentCreate

  /**
    *  Asynchronous implementation of Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param contactId contactId (optional)
    *  * @param emailWithContent Email records to persist, with content.
    *  * @return A deferred reference to the final EmailSentCreate
    */
  fun createEmailForContactAsync(contactId: Long, emailWithContent: EmailSentCreate? = null) : Deferred<EmailSentCreate>

  /**
    *  Create or Update a Contact
    *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified. Existing Contacts are updated with only the values provided in the request. Accepts a `duplicate_option` which performs duplicate checking by one of the following options: `Email`, `EmailAndName`, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the `duplicate_option` provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return FullContact
    */
  suspend fun createOrUpdateContact(contact: UpsertContact? = null) : FullContact

  /**
    *  Asynchronous implementation of Create or Update a Contact
    *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified. Existing Contacts are updated with only the values provided in the request. Accepts a `duplicate_option` which performs duplicate checking by one of the following options: `Email`, `EmailAndName`, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the `duplicate_option` provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return A deferred reference to the final FullContact
    */
  fun createOrUpdateContactAsync(contact: UpsertContact? = null) : Deferred<FullContact>

  /**
    *  Delete a Contact
    *  Deletes the specified contact.   If a request header named `GDPR-Redact` is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun deleteContact(contactId: Long)

  /**
    *  Asynchronous implementation of Delete a Contact
    *  Deletes the specified contact.   If a request header named `GDPR-Redact` is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void
    */
  fun deleteContactAsync(contactId: Long) : Deferred<Unit>

  /**
    *  Retrieve a Contact
    *  Retrieves a single contact
    *  * @param id id (optional)
    *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.)
    *  * @return FullContact
    */
  suspend fun getContact(id: Long, optionalProperties: List<String>? = null) : FullContact

  /**
    *  Asynchronous implementation of Retrieve a Contact
    *  Retrieves a single contact
    *  * @param id id (optional)
    *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.)
    *  * @return A deferred reference to the final FullContact
    */
  fun getContactAsync(id: Long, optionalProperties: List<String>? = null) : Deferred<FullContact>

  /**
    *  List Applied Tags
    *  Retrieves a list of tags applied to a given contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return ContactTagList
    */
  suspend fun listAppliedTags(contactId: Long, limit: Int? = null, offset: Int? = null) : ContactTagList

  /**
    *  Asynchronous implementation of List Applied Tags
    *  Retrieves a list of tags applied to a given contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return A deferred reference to the final ContactTagList
    */
  fun listAppliedTagsAsync(contactId: Long, limit: Int? = null, offset: Int? = null) : Deferred<ContactTagList>

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
  suspend fun listContacts(limit: Int? = null, offset: Int? = null, email: String? = null, givenName: String? = null, familyName: String? = null, order: String? = null, orderDirection: String? = null, since: String? = null, until: String? = null) : ContactList

  /**
    *  Asynchronous implementation of List Contacts
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
    *  * @return A deferred reference to the final ContactList
    */
  fun listContactsAsync(limit: Int? = null, offset: Int? = null, email: String? = null, givenName: String? = null, familyName: String? = null, order: String? = null, orderDirection: String? = null, since: String? = null, until: String? = null) : Deferred<ContactList>

  /**
    *  Retrieve Credit Cards
    *  List all Credit Cards on a contact
    *  * @param contactId contactId (optional)
    *  * @return List<ContactCreditCard>
    */
  suspend fun listCreditCards(contactId: Long) : List<ContactCreditCard>

  /**
    *  Asynchronous implementation of Retrieve Credit Cards
    *  List all Credit Cards on a contact
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final List<ContactCreditCard>
    */
  fun listCreditCardsAsync(contactId: Long) : Deferred<List<ContactCreditCard>>

  /**
    *  List Emails
    *  List Emails that have been sent to a Contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param email Optional email address to query on
    *  * @return EmailSentQueryResultList
    */
  suspend fun listEmailsForContact(contactId: Long, limit: Int? = null, offset: Int? = null, email: String? = null) : EmailSentQueryResultList

  /**
    *  Asynchronous implementation of List Emails
    *  List Emails that have been sent to a Contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param email Optional email address to query on
    *  * @return A deferred reference to the final EmailSentQueryResultList
    */
  fun listEmailsForContactAsync(contactId: Long, limit: Int? = null, offset: Int? = null, email: String? = null) : Deferred<EmailSentQueryResultList>

  /**
    *  Remove Applied Tags
    *  Removes a list of tags from the given contact
    *  * @param contactId contactId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  suspend fun removeTagsFromContact(contactId: Long, ids: String)

  /**
    *  Asynchronous implementation of Remove Applied Tags
    *  Removes a list of tags from the given contact
    *  * @param contactId contactId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final void
    */
  fun removeTagsFromContactAsync(contactId: Long, ids: String) : Deferred<Unit>

  /**
    *  Remove Applied Tag
    *  Removes a tag from the given contact
    *  * @param contactId contactId (optional)
    *  * @param tagId tagId (optional)
    *  * @return void
    */
  suspend fun removeTagsFromContact1(contactId: Long, tagId: Long)

  /**
    *  Asynchronous implementation of Remove Applied Tag
    *  Removes a tag from the given contact
    *  * @param contactId contactId (optional)
    *  * @param tagId tagId (optional)
    *  * @return A deferred reference to the final void
    */
  fun removeTagsFromContact1Async(contactId: Long, tagId: Long) : Deferred<Unit>

  /**
    *  Retrieve Contact Model
    *  Get the custom fields and optional properties for the Contact object
    *  * @return ObjectModel
    */
  suspend fun retrieveContactModel() : ObjectModel

  /**
    *  Asynchronous implementation of Retrieve Contact Model
    *  Get the custom fields and optional properties for the Contact object
    *  * @return A deferred reference to the final ObjectModel
    */
  fun retrieveContactModelAsync() : Deferred<ObjectModel>

  /**
    *  Update a Contact
    *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contactId contactId (optional)
    *  * @param contact contact
    *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped.
    *  * @return FullContact
    */
  suspend fun updatePropertiesOnContact1(contactId: Long, contact: CreateOrPatchContact? = null, updateMask: List<String>? = null) : FullContact

  /**
    *  Asynchronous implementation of Update a Contact
    *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contactId contactId (optional)
    *  * @param contact contact
    *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped.
    *  * @return A deferred reference to the final FullContact
    */
  fun updatePropertiesOnContact1Async(contactId: Long, contact: CreateOrPatchContact? = null, updateMask: List<String>? = null) : Deferred<FullContact>

}

class ContactApiImpl(bearerToken:String, basePath: String, gson: Gson) : ContactApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Apply Tags
    *  Apply a list of tags to a given contact record
    *  * @param contactId contactId (optional)
    *  * @param tagIds tagIds (optional)
    *  * @return List<EntryLongCommastring_>
    */
  override suspend fun applyTagsToContactId(contactId: Long, tagIds: TagId) : Map<String, String> {
    val uri = uriTemplate("/contacts/{contactId}/tags")
      .parameter("contactId", contactId)
      .build()
    val call = post(uri) {
      body = tagIds ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Apply Tags
    *  Apply a list of tags to a given contact record
    *  * @param contactId contactId (optional)
    *  * @param tagIds tagIds (optional)
    *  * @return A deferred reference to the final List<EntryLongCommastring_>
    */
  override fun applyTagsToContactIdAsync(contactId: Long, tagIds: TagId)  =
        client.async { applyTagsToContactId(contactId, tagIds) }

  /**
    *  Create a Contact
    *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return FullContact
    */
  override suspend fun createContact(contact: CreateOrPatchContact?) : FullContact {
    val uri = uriTemplate("/contacts")
      .build()
    val call = post(uri) {
      body = contact ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create a Contact
    *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return A deferred reference to the final FullContact
    */
  override fun createContactAsync(contact: CreateOrPatchContact?)  =
        client.async { createContact(contact) }

  /**
    *  Create a Credit Card
    *  Creates a new credit card associated to a contact
    *  * @param contactId contactId (optional)
    *  * @param creditCard creditCard
    *  * @return CreditCardAdded
    */
  override suspend fun createCreditCard(contactId: Long, creditCard: CreditCard?) : CreditCardAdded {
    val uri = uriTemplate("/contacts/{contactId}/creditCards")
      .parameter("contactId", contactId)
      .build()
    val call = post(uri) {
      body = creditCard ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create a Credit Card
    *  Creates a new credit card associated to a contact
    *  * @param contactId contactId (optional)
    *  * @param creditCard creditCard
    *  * @return A deferred reference to the final CreditCardAdded
    */
  override fun createCreditCardAsync(contactId: Long, creditCard: CreditCard?)  =
        client.async { createCreditCard(contactId, creditCard) }

  /**
    *  Create a Custom Field
    *  Adds a custom field of the specified type and options to the Contact object.
    *  * @param customField customField (optional)
    *  * @return CustomFieldMetaData
    */
  override suspend fun createCustomField(customField: CreateRestCustomField) : CustomFieldMetaData {
    val uri = uriTemplate("/contacts/model/customFields")
      .build()
    val call = post(uri) {
      body = customField ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create a Custom Field
    *  Adds a custom field of the specified type and options to the Contact object.
    *  * @param customField customField (optional)
    *  * @return A deferred reference to the final CustomFieldMetaData
    */
  override fun createCustomFieldAsync(customField: CreateRestCustomField)  =
        client.async { createCustomField(customField) }

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param contactId contactId (optional)
    *  * @param emailWithContent Email records to persist, with content.
    *  * @return EmailSentCreate
    */
  override suspend fun createEmailForContact(contactId: Long, emailWithContent: EmailSentCreate?) : EmailSentCreate {
    val uri = uriTemplate("/contacts/{contactId}/emails")
      .parameter("contactId", contactId)
      .build()
    val call = post(uri) {
      body = emailWithContent ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param contactId contactId (optional)
    *  * @param emailWithContent Email records to persist, with content.
    *  * @return A deferred reference to the final EmailSentCreate
    */
  override fun createEmailForContactAsync(contactId: Long, emailWithContent: EmailSentCreate?)  =
        client.async { createEmailForContact(contactId, emailWithContent) }

  /**
    *  Create or Update a Contact
    *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified. Existing Contacts are updated with only the values provided in the request. Accepts a `duplicate_option` which performs duplicate checking by one of the following options: `Email`, `EmailAndName`, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the `duplicate_option` provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return FullContact
    */
  override suspend fun createOrUpdateContact(contact: UpsertContact?) : FullContact {
    val uri = uriTemplate("/contacts")
      .build()
    val call = put(uri) {
      body = contact ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create or Update a Contact
    *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in `email_addresses` or `phone_numbers` and `country_code` is required if `region` is specified. Existing Contacts are updated with only the values provided in the request. Accepts a `duplicate_option` which performs duplicate checking by one of the following options: `Email`, `EmailAndName`, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the `duplicate_option` provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contact contact
    *  * @return A deferred reference to the final FullContact
    */
  override fun createOrUpdateContactAsync(contact: UpsertContact?)  =
        client.async { createOrUpdateContact(contact) }

  /**
    *  Delete a Contact
    *  Deletes the specified contact.   If a request header named `GDPR-Redact` is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun deleteContact(contactId: Long) {
    val uri = uriTemplate("/contacts/{contactId}")
      .parameter("contactId", contactId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Delete a Contact
    *  Deletes the specified contact.   If a request header named `GDPR-Redact` is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void
    */
  override fun deleteContactAsync(contactId: Long)  =
        client.async { deleteContact(contactId) }

  /**
    *  Retrieve a Contact
    *  Retrieves a single contact
    *  * @param id id (optional)
    *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.)
    *  * @return FullContact
    */
  override suspend fun getContact(id: Long, optionalProperties: List<String>?) : FullContact {
    val uri = uriTemplate("/contacts/{id}")
      .parameter("id", id)
      .build()
    val call = get(uri) {
      queryParam("optional_properties",  optionalProperties)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Retrieve a Contact
    *  Retrieves a single contact
    *  * @param id id (optional)
    *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.)
    *  * @return A deferred reference to the final FullContact
    */
  override fun getContactAsync(id: Long, optionalProperties: List<String>?)  =
        client.async { getContact(id, optionalProperties) }

  /**
    *  List Applied Tags
    *  Retrieves a list of tags applied to a given contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return ContactTagList
    */
  override suspend fun listAppliedTags(contactId: Long, limit: Int?, offset: Int?) : ContactTagList {
    val uri = uriTemplate("/contacts/{contactId}/tags")
      .parameter("contactId", contactId)
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Applied Tags
    *  Retrieves a list of tags applied to a given contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return A deferred reference to the final ContactTagList
    */
  override fun listAppliedTagsAsync(contactId: Long, limit: Int?, offset: Int?)  =
        client.async { listAppliedTags(contactId, limit, offset) }

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
  override suspend fun listContacts(limit: Int?, offset: Int?, email: String?, givenName: String?, familyName: String?, order: String?, orderDirection: String?, since: String?, until: String?) : ContactList {
    val uri = uriTemplate("/contacts")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("email",  email)
      queryParam("given_name",  givenName)
      queryParam("family_name",  familyName)
      queryParam("order",  order)
      queryParam("order_direction",  orderDirection)
      queryParam("since",  since)
      queryParam("until",  until)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Contacts
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
    *  * @return A deferred reference to the final ContactList
    */
  override fun listContactsAsync(limit: Int?, offset: Int?, email: String?, givenName: String?, familyName: String?, order: String?, orderDirection: String?, since: String?, until: String?)  =
        client.async { listContacts(limit, offset, email, givenName, familyName, order, orderDirection, since, until) }

  /**
    *  Retrieve Credit Cards
    *  List all Credit Cards on a contact
    *  * @param contactId contactId (optional)
    *  * @return List<ContactCreditCard>
    */
  override suspend fun listCreditCards(contactId: Long) : List<ContactCreditCard> {
    val uri = uriTemplate("/contacts/{contactId}/creditCards")
      .parameter("contactId", contactId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Retrieve Credit Cards
    *  List all Credit Cards on a contact
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final List<ContactCreditCard>
    */
  override fun listCreditCardsAsync(contactId: Long)  =
        client.async { listCreditCards(contactId) }

  /**
    *  List Emails
    *  List Emails that have been sent to a Contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param email Optional email address to query on
    *  * @return EmailSentQueryResultList
    */
  override suspend fun listEmailsForContact(contactId: Long, limit: Int?, offset: Int?, email: String?) : EmailSentQueryResultList {
    val uri = uriTemplate("/contacts/{contactId}/emails")
      .parameter("contactId", contactId)
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("email",  email)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Emails
    *  List Emails that have been sent to a Contact
    *  * @param contactId contactId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param email Optional email address to query on
    *  * @return A deferred reference to the final EmailSentQueryResultList
    */
  override fun listEmailsForContactAsync(contactId: Long, limit: Int?, offset: Int?, email: String?)  =
        client.async { listEmailsForContact(contactId, limit, offset, email) }

  /**
    *  Remove Applied Tags
    *  Removes a list of tags from the given contact
    *  * @param contactId contactId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  override suspend fun removeTagsFromContact(contactId: Long, ids: String) {
    val uri = uriTemplate("/contacts/{contactId}/tags")
      .parameter("contactId", contactId)
      .build()
    val call = delete(uri) {
      queryParam("ids",  ids)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Remove Applied Tags
    *  Removes a list of tags from the given contact
    *  * @param contactId contactId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final void
    */
  override fun removeTagsFromContactAsync(contactId: Long, ids: String)  =
        client.async { removeTagsFromContact(contactId, ids) }

  /**
    *  Remove Applied Tag
    *  Removes a tag from the given contact
    *  * @param contactId contactId (optional)
    *  * @param tagId tagId (optional)
    *  * @return void
    */
  override suspend fun removeTagsFromContact1(contactId: Long, tagId: Long) {
    val uri = uriTemplate("/contacts/{contactId}/tags/{tagId}")
      .parameter("contactId", contactId)
      .parameter("tagId", tagId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Remove Applied Tag
    *  Removes a tag from the given contact
    *  * @param contactId contactId (optional)
    *  * @param tagId tagId (optional)
    *  * @return A deferred reference to the final void
    */
  override fun removeTagsFromContact1Async(contactId: Long, tagId: Long)  =
        client.async { removeTagsFromContact1(contactId, tagId) }

  /**
    *  Retrieve Contact Model
    *  Get the custom fields and optional properties for the Contact object
    *  * @return ObjectModel
    */
  override suspend fun retrieveContactModel() : ObjectModel {
    val uri = uriTemplate("/contacts/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Retrieve Contact Model
    *  Get the custom fields and optional properties for the Contact object
    *  * @return A deferred reference to the final ObjectModel
    */
  override fun retrieveContactModelAsync()  =
        client.async { retrieveContactModel() }

  /**
    *  Update a Contact
    *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contactId contactId (optional)
    *  * @param contact contact
    *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped.
    *  * @return FullContact
    */
  override suspend fun updatePropertiesOnContact1(contactId: Long, contact: CreateOrPatchContact?, updateMask: List<String>?) : FullContact {
    val uri = uriTemplate("/contacts/{contactId}")
      .parameter("contactId", contactId)
      .build()
    val call = patch(uri) {
      body = contact ?: EmptyContent
      contentType(Application.Json)
      queryParam("update_mask",  updateMask)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Update a Contact
    *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \"Customer opted-in through webform\", \"Contact gave explicit permission.\"  ```json \"opt_in_reason\": \"your reason for opt-in\" ```
    *  * @param contactId contactId (optional)
    *  * @param contact contact
    *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped.
    *  * @return A deferred reference to the final FullContact
    */
  override fun updatePropertiesOnContact1Async(contactId: Long, contact: CreateOrPatchContact?, updateMask: List<String>?)  =
        client.async { updatePropertiesOnContact1(contactId, contact, updateMask) }

}


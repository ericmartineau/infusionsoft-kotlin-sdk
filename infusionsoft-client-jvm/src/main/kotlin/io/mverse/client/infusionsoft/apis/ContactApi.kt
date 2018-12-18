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
import kotlinx.serialization.*
import com.google.gson.Gson


class ContactApi(bearerToken:String, basePath: String, gson: Gson) : ApiClient(basePath, bearerToken, gson) {

  /**
   *  Apply Tags
   *  Apply a list of tags to a given contact record
   *  * @param contactId contactId 
   *  * @param tagIds tagIds 
   *  * @return List<EntryLongCommastring_>
   */ 
  @Suppress("UNCHECKED_CAST")
  fun applyTagsToContactId(contactId: Long, tagIds: TagId) : List<EntryLongCommastring_> {
    val requestBody = tagIds
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/contacts/{contactId}/tags".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      EntryLongCommastring_.serializer().list,
      TagId.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as List<EntryLongCommastring_>
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create a Contact
   *  Creates a new contact as the authenticated user. NB: Contact must contain at least one item in &#x60;email_addresses&#x60; or &#x60;phone_numbers&#x60; and &#x60;country_code&#x60; is required if &#x60;region&#x60; is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Contact gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;
   *  * @param contact contact (optional)
   *  * @return FullContact
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createContact(contact: CreateOrPatchContact? = null) : FullContact {
    val requestBody = contact
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/contacts",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      FullContact.serializer(),
      CreateOrPatchContact.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as FullContact
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create a Credit Card
   *  Creates a new credit card associated to a contact
   *  * @param contactId contactId 
   *  * @param creditCard creditCard (optional)
   *  * @return CreditCardAdded
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createCreditCard(contactId: Long, creditCard: CreditCard? = null) : CreditCardAdded {
    val requestBody = creditCard
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/contacts/{contactId}/creditCards".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      CreditCardAdded.serializer(),
      CreditCard.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as CreditCardAdded
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create a Custom Field
   *  Adds a custom field of the specified type and options to the Contact object.
   *  * @param customField customField 
   *  * @return CustomFieldMetaData
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createCustomField(customField: CreateRestCustomField) : CustomFieldMetaData {
    val requestBody = customField
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/contacts/model/customFields",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      CustomFieldMetaData.serializer(),
      CreateRestCustomField.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as CustomFieldMetaData
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create an Email Record
   *  Create a record of an email sent to a contact
   *  * @param contactId contactId 
   *  * @param emailWithContent Email records to persist, with content. (optional)
   *  * @return EmailSentCreate
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createEmailForContact(contactId: Long, emailWithContent: EmailSentCreate? = null) : EmailSentCreate {
    val requestBody = emailWithContent
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/contacts/{contactId}/emails".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      EmailSentCreate.serializer(),
      EmailSentCreate.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as EmailSentCreate
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create or Update a Contact
   *  Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in &#x60;email_addresses&#x60; or &#x60;phone_numbers&#x60; and &#x60;country_code&#x60; is required if &#x60;region&#x60; is specified. Existing Contacts are updated with only the values provided in the request. Accepts a &#x60;duplicate_option&#x60; which performs duplicate checking by one of the following options: &#x60;Email&#x60;, &#x60;EmailAndName&#x60;, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the &#x60;duplicate_option&#x60; provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Contact gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;
   *  * @param contact contact (optional)
   *  * @return FullContact
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createOrUpdateContact(contact: UpsertContact? = null) : FullContact {
    val requestBody = contact
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PUT,
       "/contacts",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      FullContact.serializer(),
      UpsertContact.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as FullContact
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Delete a Contact
   *  Deletes the specified contact.   If a request header named &#x60;GDPR-Redact&#x60; is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.
   *  * @param contactId contactId 
   *  * @return void
   */ 
  fun deleteContact(contactId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/contacts/{contactId}".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> Unit
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve a Contact
   *  Retrieves a single contact
   *  * @param id id 
   *  * @param optionalProperties Comma-delimited list of Contact properties to include in the response. (Some fields such as &#x60;lead_source_id&#x60;, &#x60;custom_fields&#x60;, and &#x60;job_title&#x60; aren&#39;t included, by default.) (optional)
   *  * @return FullContact
   */ 
  @Suppress("UNCHECKED_CAST")
  fun getContact(id: Long, optionalProperties: List<String>? = null) : FullContact {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (optionalProperties != null) localVariableQuery["optional_properties"] = toMultiValue(optionalProperties!!.toList(), "multi")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/contacts/{id}".replace("{"+"id"+"}", "$id"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      FullContact.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as FullContact
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Applied Tags
   *  Retrieves a list of tags applied to a given contact
   *  * @param contactId contactId 
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @return ContactTagList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listAppliedTags(contactId: Long, limit: Int? = null, offset: Int? = null) : ContactTagList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/contacts/{contactId}/tags".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ContactTagList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ContactTagList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Contacts
   *  Retrieves a list of all contacts
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param email Optional email address to query on (optional)
   *  * @param givenName Optional first name or forename to query on (optional)
   *  * @param familyName Optional last name or surname to query on (optional)
   *  * @param order Attribute to order items by (optional)
   *  * @param orderDirection How to order the data i.e. ascending (A-Z) or descending (Z-A) (optional)
   *  * @param since Date to start searching from on LastUpdated ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param until Date to search to on LastUpdated ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @return ContactList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listContacts(limit: Int? = null, offset: Int? = null, email: String? = null, givenName: String? = null, familyName: String? = null, order: String? = null, orderDirection: String? = null, since: String? = null, until: String? = null) : ContactList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (email != null) localVariableQuery["email"] = listOf("$email")
    if (givenName != null) localVariableQuery["given_name"] = listOf("$givenName")
    if (familyName != null) localVariableQuery["family_name"] = listOf("$familyName")
    if (order != null) localVariableQuery["order"] = listOf("$order")
    if (orderDirection != null) localVariableQuery["order_direction"] = listOf("$orderDirection")
    if (since != null) localVariableQuery["since"] = listOf("$since")
    if (until != null) localVariableQuery["until"] = listOf("$until")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/contacts",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ContactList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ContactList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Credit Cards
   *  List all Credit Cards on a contact
   *  * @param contactId contactId 
   *  * @return List<ContactCreditCard>
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listCreditCards(contactId: Long) : List<ContactCreditCard> {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/contacts/{contactId}/creditCards".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ContactCreditCard.serializer().list,UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as List<ContactCreditCard>
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Emails
   *  List Emails that have been sent to a Contact
   *  * @param contactId contactId 
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param email Optional email address to query on (optional)
   *  * @return EmailSentQueryResultList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listEmailsForContact(contactId: Long, limit: Int? = null, offset: Int? = null, email: String? = null) : EmailSentQueryResultList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (email != null) localVariableQuery["email"] = listOf("$email")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/contacts/{contactId}/emails".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      EmailSentQueryResultList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as EmailSentQueryResultList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Remove Applied Tags
   *  Removes a list of tags from the given contact
   *  * @param contactId contactId 
   *  * @param ids ids 
   *  * @return void
   */ 
  fun removeTagsFromContact(contactId: Long, ids: String) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (ids != null) localVariableQuery["ids"] = listOf("$ids")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/contacts/{contactId}/tags".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> Unit
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Remove Applied Tag
   *  Removes a tag from the given contact
   *  * @param contactId contactId 
   *  * @param tagId tagId 
   *  * @return void
   */ 
  fun removeTagsFromContact1(contactId: Long, tagId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/contacts/{contactId}/tags/{tagId}".replace("{"+"contactId"+"}", "$contactId").replace("{"+"tagId"+"}", "$tagId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> Unit
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Contact Model
   *  Get the custom fields and optional properties for the Contact object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveContactModel() : ObjectModel {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/contacts/model",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ObjectModel.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ObjectModel
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Update a Contact
   *  Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Contact gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;
   *  * @param contactId contactId 
   *  * @param contact contact (optional)
   *  * @param updateMask An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped. (optional)
   *  * @return FullContact
   */ 
  @Suppress("UNCHECKED_CAST")
  fun updatePropertiesOnContact1(contactId: Long, contact: CreateOrPatchContact? = null, updateMask: List<String>? = null) : FullContact {
    val requestBody = contact
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (updateMask != null) localVariableQuery["update_mask"] = toMultiValue(updateMask!!.toList(), "multi")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PATCH,
       "/contacts/{contactId}".replace("{"+"contactId"+"}", "$contactId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      FullContact.serializer(),
      CreateOrPatchContact.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as FullContact
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
}

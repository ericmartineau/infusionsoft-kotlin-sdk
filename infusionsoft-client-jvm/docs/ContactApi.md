# ContactApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applyTagsToContactId**](ContactApi.md#applyTagsToContactId) | **POST** /contacts/{contactId}/tags | Apply Tags
[**createContact**](ContactApi.md#createContact) | **POST** /contacts | Create a Contact
[**createCreditCard**](ContactApi.md#createCreditCard) | **POST** /contacts/{contactId}/creditCards | Create a Credit Card
[**createCustomField**](ContactApi.md#createCustomField) | **POST** /contacts/model/customFields | Create a Custom Field
[**createEmailForContact**](ContactApi.md#createEmailForContact) | **POST** /contacts/{contactId}/emails | Create an Email Record
[**createOrUpdateContact**](ContactApi.md#createOrUpdateContact) | **PUT** /contacts | Create or Update a Contact
[**deleteContact**](ContactApi.md#deleteContact) | **DELETE** /contacts/{contactId} | Delete a Contact
[**getContact**](ContactApi.md#getContact) | **GET** /contacts/{id} | Retrieve a Contact
[**listAppliedTags**](ContactApi.md#listAppliedTags) | **GET** /contacts/{contactId}/tags | List Applied Tags
[**listContacts**](ContactApi.md#listContacts) | **GET** /contacts | List Contacts
[**listCreditCards**](ContactApi.md#listCreditCards) | **GET** /contacts/{contactId}/creditCards | Retrieve Credit Cards
[**listEmailsForContact**](ContactApi.md#listEmailsForContact) | **GET** /contacts/{contactId}/emails | List Emails
[**removeTagsFromContact**](ContactApi.md#removeTagsFromContact) | **DELETE** /contacts/{contactId}/tags | Remove Applied Tags
[**removeTagsFromContact1**](ContactApi.md#removeTagsFromContact1) | **DELETE** /contacts/{contactId}/tags/{tagId} | Remove Applied Tag
[**retrieveContactModel**](ContactApi.md#retrieveContactModel) | **GET** /contacts/model | Retrieve Contact Model
[**updatePropertiesOnContact1**](ContactApi.md#updatePropertiesOnContact1) | **PATCH** /contacts/{contactId} | Update a Contact


<a name="applyTagsToContactId"></a>
# **applyTagsToContactId**
> List&lt;EntryLongCommastring_&gt; applyTagsToContactId(contactId, tagIds)

Apply Tags

Apply a list of tags to a given contact record

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val tagIds : TagId =  // TagId | tagIds
try {
    val result : List<EntryLongCommastring_> = apiInstance.applyTagsToContactId(contactId, tagIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#applyTagsToContactId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#applyTagsToContactId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **tagIds** | [**TagId**](TagId.md)| tagIds |

### Return type

[**List&lt;EntryLongCommastring_&gt;**](EntryLongCommastring_.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContact"></a>
# **createContact**
> FullContact createContact(contact)

Create a Contact

Creates a new contact as the authenticated user. NB: Contact must contain at least one item in &#x60;email_addresses&#x60; or &#x60;phone_numbers&#x60; and &#x60;country_code&#x60; is required if &#x60;region&#x60; is specified.  Please see the body schema for updates to the postal code field.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Contact gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contact : CreateOrPatchContact =  // CreateOrPatchContact | contact
try {
    val result : FullContact = apiInstance.createContact(contact)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#createContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#createContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contact** | [**CreateOrPatchContact**](CreateOrPatchContact.md)| contact | [optional]

### Return type

[**FullContact**](FullContact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCreditCard"></a>
# **createCreditCard**
> CreditCardAdded createCreditCard(contactId, creditCard)

Create a Credit Card

Creates a new credit card associated to a contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val creditCard : CreditCard =  // CreditCard | creditCard
try {
    val result : CreditCardAdded = apiInstance.createCreditCard(contactId, creditCard)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#createCreditCard")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#createCreditCard")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **creditCard** | [**CreditCard**](CreditCard.md)| creditCard | [optional]

### Return type

[**CreditCardAdded**](CreditCardAdded.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCustomField"></a>
# **createCustomField**
> CustomFieldMetaData createCustomField(customField)

Create a Custom Field

Adds a custom field of the specified type and options to the Contact object.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val customField : CreateRestCustomField =  // CreateRestCustomField | customField
try {
    val result : CustomFieldMetaData = apiInstance.createCustomField(customField)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#createCustomField")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#createCustomField")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customField** | [**CreateRestCustomField**](CreateRestCustomField.md)| customField |

### Return type

[**CustomFieldMetaData**](CustomFieldMetaData.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createEmailForContact"></a>
# **createEmailForContact**
> EmailSentCreate createEmailForContact(contactId, emailWithContent)

Create an Email Record

Create a record of an email sent to a contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val emailWithContent : EmailSentCreate =  // EmailSentCreate | Email records to persist, with content.
try {
    val result : EmailSentCreate = apiInstance.createEmailForContact(contactId, emailWithContent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#createEmailForContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#createEmailForContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **emailWithContent** | [**EmailSentCreate**](EmailSentCreate.md)| Email records to persist, with content. | [optional]

### Return type

[**EmailSentCreate**](EmailSentCreate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createOrUpdateContact"></a>
# **createOrUpdateContact**
> FullContact createOrUpdateContact(contact)

Create or Update a Contact

Creates a new contact or updates a contact as the authenticated user. NB: New Contacts must contain at least one item in &#x60;email_addresses&#x60; or &#x60;phone_numbers&#x60; and &#x60;country_code&#x60; is required if &#x60;region&#x60; is specified. Existing Contacts are updated with only the values provided in the request. Accepts a &#x60;duplicate_option&#x60; which performs duplicate checking by one of the following options: &#x60;Email&#x60;, &#x60;EmailAndName&#x60;, if a match is found using the option provided, the existing contact will be updated. If an existing contact was not found using the &#x60;duplicate_option&#x60; provided, a new contact record will be created.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Contact gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contact : UpsertContact =  // UpsertContact | contact
try {
    val result : FullContact = apiInstance.createOrUpdateContact(contact)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#createOrUpdateContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#createOrUpdateContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contact** | [**UpsertContact**](UpsertContact.md)| contact | [optional]

### Return type

[**FullContact**](FullContact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContact"></a>
# **deleteContact**
> deleteContact(contactId)

Delete a Contact

Deletes the specified contact.   If a request header named &#x60;GDPR-Redact&#x60; is included, the contact will instead be redacted according to [GDPR guidlines](https://gdpr-info.eu/). Redacting a contact will remove all personally identifiable information and cannot be undone.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
try {
    apiInstance.deleteContact(contactId)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#deleteContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#deleteContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getContact"></a>
# **getContact**
> FullContact getContact(id, optionalProperties)

Retrieve a Contact

Retrieves a single contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val id : Long = 789 // Long | id
val optionalProperties : List<String> =  // List<String> | Comma-delimited list of Contact properties to include in the response. (Some fields such as `lead_source_id`, `custom_fields`, and `job_title` aren't included, by default.)
try {
    val result : FullContact = apiInstance.getContact(id, optionalProperties)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#getContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#getContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **optionalProperties** | [**List&lt;String&gt;**](String.md)| Comma-delimited list of Contact properties to include in the response. (Some fields such as &#x60;lead_source_id&#x60;, &#x60;custom_fields&#x60;, and &#x60;job_title&#x60; aren&#39;t included, by default.) | [optional]

### Return type

[**FullContact**](FullContact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listAppliedTags"></a>
# **listAppliedTags**
> ContactTagList listAppliedTags(contactId, limit, offset)

List Applied Tags

Retrieves a list of tags applied to a given contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
try {
    val result : ContactTagList = apiInstance.listAppliedTags(contactId, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#listAppliedTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#listAppliedTags")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]

### Return type

[**ContactTagList**](ContactTagList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listContacts"></a>
# **listContacts**
> ContactList listContacts(limit, offset, email, givenName, familyName, order, orderDirection, since, until)

List Contacts

Retrieves a list of all contacts

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val email : String = email_example // String | Optional email address to query on
val givenName : String = givenName_example // String | Optional first name or forename to query on
val familyName : String = familyName_example // String | Optional last name or surname to query on
val order : String = order_example // String | Attribute to order items by
val orderDirection : String = orderDirection_example // String | How to order the data i.e. ascending (A-Z) or descending (Z-A)
val since : String = since_example // String | Date to start searching from on LastUpdated ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to on LastUpdated ex. `2017-01-01T22:17:59.039Z`
try {
    val result : ContactList = apiInstance.listContacts(limit, offset, email, givenName, familyName, order, orderDirection, since, until)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#listContacts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#listContacts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **email** | **String**| Optional email address to query on | [optional]
 **givenName** | **String**| Optional first name or forename to query on | [optional]
 **familyName** | **String**| Optional last name or surname to query on | [optional]
 **order** | **String**| Attribute to order items by | [optional] [enum: id, date_created, name, email]
 **orderDirection** | **String**| How to order the data i.e. ascending (A-Z) or descending (Z-A) | [optional] [enum: ascending, descending]
 **since** | **String**| Date to start searching from on LastUpdated ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to on LastUpdated ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]

### Return type

[**ContactList**](ContactList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listCreditCards"></a>
# **listCreditCards**
> List&lt;ContactCreditCard&gt; listCreditCards(contactId)

Retrieve Credit Cards

List all Credit Cards on a contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
try {
    val result : List<ContactCreditCard> = apiInstance.listCreditCards(contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#listCreditCards")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#listCreditCards")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |

### Return type

[**List&lt;ContactCreditCard&gt;**](ContactCreditCard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listEmailsForContact"></a>
# **listEmailsForContact**
> EmailSentQueryResultList listEmailsForContact(contactId, limit, offset, email)

List Emails

List Emails that have been sent to a Contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val email : String = email_example // String | Optional email address to query on
try {
    val result : EmailSentQueryResultList = apiInstance.listEmailsForContact(contactId, limit, offset, email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#listEmailsForContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#listEmailsForContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **email** | **String**| Optional email address to query on | [optional]

### Return type

[**EmailSentQueryResultList**](EmailSentQueryResultList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeTagsFromContact"></a>
# **removeTagsFromContact**
> removeTagsFromContact(contactId, ids)

Remove Applied Tags

Removes a list of tags from the given contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val ids : String = ids_example // String | ids
try {
    apiInstance.removeTagsFromContact(contactId, ids)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#removeTagsFromContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#removeTagsFromContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **ids** | **String**| ids |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeTagsFromContact1"></a>
# **removeTagsFromContact1**
> removeTagsFromContact1(contactId, tagId)

Remove Applied Tag

Removes a tag from the given contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val tagId : Long = 789 // Long | tagId
try {
    apiInstance.removeTagsFromContact1(contactId, tagId)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#removeTagsFromContact1")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#removeTagsFromContact1")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **tagId** | **Long**| tagId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContactModel"></a>
# **retrieveContactModel**
> ObjectModel retrieveContactModel()

Retrieve Contact Model

Get the custom fields and optional properties for the Contact object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
try {
    val result : ObjectModel = apiInstance.retrieveContactModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#retrieveContactModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#retrieveContactModel")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ObjectModel**](ObjectModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePropertiesOnContact1"></a>
# **updatePropertiesOnContact1**
> FullContact updatePropertiesOnContact1(contactId, contact, updateMask)

Update a Contact

Updates a contact with only the values provided in the request.  You may opt-in or mark a Contact as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Contact gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ContactApi()
val contactId : Long = 789 // Long | contactId
val contact : CreateOrPatchContact =  // CreateOrPatchContact | contact
val updateMask : List<String> =  // List<String> | An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped.
try {
    val result : FullContact = apiInstance.updatePropertiesOnContact1(contactId, contact, updateMask)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactApi#updatePropertiesOnContact1")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactApi#updatePropertiesOnContact1")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contactId |
 **contact** | [**CreateOrPatchContact**](CreateOrPatchContact.md)| contact | [optional]
 **updateMask** | [**List&lt;String&gt;**](String.md)| An optional list of properties to be updated. If set, only the provided properties will be updated and others will be skipped. | [optional]

### Return type

[**FullContact**](FullContact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


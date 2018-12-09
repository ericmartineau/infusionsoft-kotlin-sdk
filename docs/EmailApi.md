# EmailApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEmail**](EmailApi.md#createEmail) | **POST** /emails | Create an Email Record
[**createEmails**](EmailApi.md#createEmails) | **POST** /emails/sync | Create a set of Email Records
[**deleteEmail**](EmailApi.md#deleteEmail) | **DELETE** /emails/{id} | Delete an Email Record
[**deleteEmails**](EmailApi.md#deleteEmails) | **POST** /emails/unsync | Un-sync a batch of Email Records
[**getEmail**](EmailApi.md#getEmail) | **GET** /emails/{id} | Retrieve an Email
[**listEmails**](EmailApi.md#listEmails) | **GET** /emails | List Emails
[**sendEmail**](EmailApi.md#sendEmail) | **POST** /emails/queue | Send an Email
[**updateEmail**](EmailApi.md#updateEmail) | **PUT** /emails/{id} | Update an Email Record


<a name="createEmail"></a>
# **createEmail**
> EmailSentCreate createEmail(emailWithContent)

Create an Email Record

Create a record of an email sent to a contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val emailWithContent : EmailSentCreate =  // EmailSentCreate | Email records to persist, with content.
try {
    val result : EmailSentCreate = apiInstance.createEmail(emailWithContent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#createEmail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#createEmail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailWithContent** | [**EmailSentCreate**](EmailSentCreate.md)| Email records to persist, with content. | [optional]

### Return type

[**EmailSentCreate**](EmailSentCreate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createEmails"></a>
# **createEmails**
> EmailSentCreateList createEmails(emailWithContent)

Create a set of Email Records

Create a set of records of emails sent to contacts, maximum 1000 per transaction.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val emailWithContent : EmailSentCreateList =  // EmailSentCreateList | Email records to persist, with content.
try {
    val result : EmailSentCreateList = apiInstance.createEmails(emailWithContent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#createEmails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#createEmails")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailWithContent** | [**EmailSentCreateList**](EmailSentCreateList.md)| Email records to persist, with content. | [optional]

### Return type

[**EmailSentCreateList**](EmailSentCreateList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteEmail"></a>
# **deleteEmail**
> deleteEmail(id)

Delete an Email Record

Delete a specific email record

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val id : Long = 789 // Long | id
try {
    apiInstance.deleteEmail(id)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#deleteEmail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#deleteEmail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteEmails"></a>
# **deleteEmails**
> Map&lt;kotlin.String, String&gt; deleteEmails(emailIds)

Un-sync a batch of Email Records

Un-syncs a batch of email records

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val emailIds : SetOfIds =  // SetOfIds | emailIds
try {
    val result : Map<kotlin.String, String> = apiInstance.deleteEmails(emailIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#deleteEmails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#deleteEmails")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailIds** | [**SetOfIds**](SetOfIds.md)| emailIds |

### Return type

**Map&lt;kotlin.String, String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEmail"></a>
# **getEmail**
> EmailSentQueryResultWithContent getEmail(id)

Retrieve an Email

Retrieves a single email that has been sent

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val id : Long = 789 // Long | id
try {
    val result : EmailSentQueryResultWithContent = apiInstance.getEmail(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#getEmail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#getEmail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

[**EmailSentQueryResultWithContent**](EmailSentQueryResultWithContent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listEmails"></a>
# **listEmails**
> EmailSentQueryResultList listEmails(limit, offset, contactId, email, sinceSentDate, untilSentDate)

List Emails

Retrieve a list of emails that have been sent

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val contactId : Long = 789 // Long | Optional Contact Id to find Emails for
val email : String = email_example // String | Optional email address to query on
val sinceSentDate : String = sinceSentDate_example // String | Optional date to query on, emails sent since the provided date, must be present if untilDate is provided
val untilSentDate : String = untilSentDate_example // String | Optional date to query on, email sent until the provided date
try {
    val result : EmailSentQueryResultList = apiInstance.listEmails(limit, offset, contactId, email, sinceSentDate, untilSentDate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#listEmails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#listEmails")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **contactId** | **Long**| Optional Contact Id to find Emails for | [optional]
 **email** | **String**| Optional email address to query on | [optional]
 **sinceSentDate** | **String**| Optional date to query on, emails sent since the provided date, must be present if untilDate is provided | [optional]
 **untilSentDate** | **String**| Optional date to query on, email sent until the provided date | [optional]

### Return type

[**EmailSentQueryResultList**](EmailSentQueryResultList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendEmail"></a>
# **sendEmail**
> sendEmail(emailSendRequest)

Send an Email

Send an Email to a list of Contacts

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val emailSendRequest : EmailSendRequest =  // EmailSendRequest | emailSendRequest
try {
    apiInstance.sendEmail(emailSendRequest)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#sendEmail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#sendEmail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailSendRequest** | [**EmailSendRequest**](EmailSendRequest.md)| emailSendRequest | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateEmail"></a>
# **updateEmail**
> EmailSentCreate updateEmail(id, emailWithContent)

Update an Email Record

Update a record of an email sent to a contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailApi()
val id : Long = 789 // Long | id
val emailWithContent : EmailSentCreate =  // EmailSentCreate | Email records to persist, with content.
try {
    val result : EmailSentCreate = apiInstance.updateEmail(id, emailWithContent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailApi#updateEmail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailApi#updateEmail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **emailWithContent** | [**EmailSentCreate**](EmailSentCreate.md)| Email records to persist, with content. | [optional]

### Return type

[**EmailSentCreate**](EmailSentCreate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


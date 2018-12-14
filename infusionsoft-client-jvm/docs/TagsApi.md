# TagsApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applyTagToContactIds**](TagsApi.md#applyTagToContactIds) | **POST** /tags/{tagId}/contacts | Apply Tag to Contacts
[**createTag**](TagsApi.md#createTag) | **POST** /tags | Create Tag
[**createTagCategory**](TagsApi.md#createTagCategory) | **POST** /tags/categories | Create Tag Category
[**getTag**](TagsApi.md#getTag) | **GET** /tags/{id} | Retrieve a Tag
[**listCompaniesForTagId**](TagsApi.md#listCompaniesForTagId) | **GET** /tags/{tagId}/companies | List Tagged Companies
[**listContactsForTagId**](TagsApi.md#listContactsForTagId) | **GET** /tags/{tagId}/contacts | List Tagged Contacts
[**listTags**](TagsApi.md#listTags) | **GET** /tags | List Tags
[**removeTagFromContactId**](TagsApi.md#removeTagFromContactId) | **DELETE** /tags/{tagId}/contacts/{contactId} | Remove Tag from Contact
[**removeTagFromContactIds**](TagsApi.md#removeTagFromContactIds) | **DELETE** /tags/{tagId}/contacts | Remove Tag from Contacts


<a name="applyTagToContactIds"></a>
# **applyTagToContactIds**
> List&lt;EntryLongCommastring_&gt; applyTagToContactIds(tagId, ids)

Apply Tag to Contacts

Apply a tag to a list of contacts

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tagId : Long = 789 // Long | tagId
val ids : SetOfIds =  // SetOfIds | ids
try {
    val result : List<EntryLongCommastring_> = apiInstance.applyTagToContactIds(tagId, ids)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#applyTagToContactIds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#applyTagToContactIds")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagId** | **Long**| tagId |
 **ids** | [**SetOfIds**](SetOfIds.md)| ids |

### Return type

[**List&lt;EntryLongCommastring_&gt;**](EntryLongCommastring_.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createTag"></a>
# **createTag**
> Tag createTag(tag)

Create Tag

Create a new tag

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tag : CreateTag =  // CreateTag | tag
try {
    val result : Tag = apiInstance.createTag(tag)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#createTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#createTag")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tag** | [**CreateTag**](CreateTag.md)| tag |

### Return type

[**Tag**](Tag.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createTagCategory"></a>
# **createTagCategory**
> TagCategory createTagCategory(tagCategory)

Create Tag Category

Create a new tag category

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tagCategory : CreateTagCategory =  // CreateTagCategory | tagCategory
try {
    val result : TagCategory = apiInstance.createTagCategory(tagCategory)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#createTagCategory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#createTagCategory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagCategory** | [**CreateTagCategory**](CreateTagCategory.md)| tagCategory |

### Return type

[**TagCategory**](TagCategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTag"></a>
# **getTag**
> Tag getTag(id)

Retrieve a Tag

Retrieves a single tag

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val id : Long = 789 // Long | id
try {
    val result : Tag = apiInstance.getTag(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#getTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#getTag")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

[**Tag**](Tag.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listCompaniesForTagId"></a>
# **listCompaniesForTagId**
> TaggedCompanyList listCompaniesForTagId(tagId, limit, offset)

List Tagged Companies

Retrieves a list of companies that have the given tag applied

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tagId : Long = 789 // Long | tagId
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
try {
    val result : TaggedCompanyList = apiInstance.listCompaniesForTagId(tagId, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#listCompaniesForTagId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#listCompaniesForTagId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagId** | **Long**| tagId |
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]

### Return type

[**TaggedCompanyList**](TaggedCompanyList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listContactsForTagId"></a>
# **listContactsForTagId**
> TaggedContactList listContactsForTagId(tagId, limit, offset)

List Tagged Contacts

Retrieves a list of contacts that have the given tag applied

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tagId : Long = 789 // Long | tagId
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
try {
    val result : TaggedContactList = apiInstance.listContactsForTagId(tagId, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#listContactsForTagId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#listContactsForTagId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagId** | **Long**| tagId |
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]

### Return type

[**TaggedContactList**](TaggedContactList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listTags"></a>
# **listTags**
> Tags listTags(limit, offset, category, name)

List Tags

Retrieve a list of tags defined in the application

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val category : Long = 789 // Long | Category Id of tags to filter by
val name : String = name_example // String | Filter for tags with a specific name
try {
    val result : Tags = apiInstance.listTags(limit, offset, category, name)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#listTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#listTags")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **category** | **Long**| Category Id of tags to filter by | [optional]
 **name** | **String**| Filter for tags with a specific name | [optional]

### Return type

[**Tags**](Tags.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeTagFromContactId"></a>
# **removeTagFromContactId**
> removeTagFromContactId(tagId, contactId)

Remove Tag from Contact

Remove a tag from a Contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tagId : Long = 789 // Long | tagId
val contactId : Long = 789 // Long | contactId
try {
    apiInstance.removeTagFromContactId(tagId, contactId)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#removeTagFromContactId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#removeTagFromContactId")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagId** | **Long**| tagId |
 **contactId** | **Long**| contactId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeTagFromContactIds"></a>
# **removeTagFromContactIds**
> removeTagFromContactIds(tagId, ids)

Remove Tag from Contacts

Remove a tag from a list of contacts

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TagsApi()
val tagId : Long = 789 // Long | tagId
val ids : List<Long> =  // List<Long> | ids
try {
    apiInstance.removeTagFromContactIds(tagId, ids)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#removeTagFromContactIds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#removeTagFromContactIds")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagId** | **Long**| tagId |
 **ids** | [**List&lt;Long&gt;**](Long.md)| ids |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


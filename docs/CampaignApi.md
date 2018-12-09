# CampaignApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addContactToCampaignSequence**](CampaignApi.md#addContactToCampaignSequence) | **POST** /campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId} | Add to Campaign Sequence
[**addContactsToCampaignSequence**](CampaignApi.md#addContactsToCampaignSequence) | **POST** /campaigns/{campaignId}/sequences/{sequenceId}/contacts | Add Multiple to Campaign Sequence
[**getCampaign**](CampaignApi.md#getCampaign) | **GET** /campaigns/{campaignId} | Retrieve a Campaign
[**listCampaigns**](CampaignApi.md#listCampaigns) | **GET** /campaigns | List Campaigns
[**removeContactFromCampaignSequence**](CampaignApi.md#removeContactFromCampaignSequence) | **DELETE** /campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId} | Remove from Campaign Sequence
[**removeContactsFromCampaignSequence**](CampaignApi.md#removeContactsFromCampaignSequence) | **DELETE** /campaigns/{campaignId}/sequences/{sequenceId}/contacts | Remove Multiple from Campaign Sequence


<a name="addContactToCampaignSequence"></a>
# **addContactToCampaignSequence**
> addContactToCampaignSequence(campaignId, sequenceId, contactId)

Add to Campaign Sequence

Adds a single contact to a campaign sequence

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CampaignApi()
val campaignId : Long = 789 // Long | campaignId
val sequenceId : Long = 789 // Long | sequenceId
val contactId : Long = 789 // Long | contactId
try {
    apiInstance.addContactToCampaignSequence(campaignId, sequenceId, contactId)
} catch (e: ClientException) {
    println("4xx response calling CampaignApi#addContactToCampaignSequence")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CampaignApi#addContactToCampaignSequence")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **Long**| campaignId |
 **sequenceId** | **Long**| sequenceId |
 **contactId** | **Long**| contactId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addContactsToCampaignSequence"></a>
# **addContactsToCampaignSequence**
> Map&lt;kotlin.String, String&gt; addContactsToCampaignSequence(campaignId, sequenceId, ids)

Add Multiple to Campaign Sequence

Adds a list of contacts to a campaign sequence

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CampaignApi()
val campaignId : Long = 789 // Long | campaignId
val sequenceId : Long = 789 // Long | sequenceId
val ids : SetOfIds =  // SetOfIds | ids
try {
    val result : Map<kotlin.String, String> = apiInstance.addContactsToCampaignSequence(campaignId, sequenceId, ids)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CampaignApi#addContactsToCampaignSequence")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CampaignApi#addContactsToCampaignSequence")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **Long**| campaignId |
 **sequenceId** | **Long**| sequenceId |
 **ids** | [**SetOfIds**](SetOfIds.md)| ids |

### Return type

**Map&lt;kotlin.String, String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCampaign"></a>
# **getCampaign**
> Campaign getCampaign(campaignId, optionalProperties)

Retrieve a Campaign

Retrieves a single campaign

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CampaignApi()
val campaignId : Long = 789 // Long | campaignId
val optionalProperties : List<String> =  // List<String> | Comma-delimited list of Campaign properties to include in the response. (The fields `goals` and `sequences` aren't included, by default.)
try {
    val result : Campaign = apiInstance.getCampaign(campaignId, optionalProperties)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CampaignApi#getCampaign")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CampaignApi#getCampaign")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **Long**| campaignId |
 **optionalProperties** | [**List&lt;String&gt;**](String.md)| Comma-delimited list of Campaign properties to include in the response. (The fields &#x60;goals&#x60; and &#x60;sequences&#x60; aren&#39;t included, by default.) | [optional]

### Return type

[**Campaign**](Campaign.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listCampaigns"></a>
# **listCampaigns**
> CampaignList listCampaigns(limit, offset, searchText, order, orderDirection)

List Campaigns

Retrieves all campaigns for the authenticated user

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CampaignApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val searchText : String = searchText_example // String | Optional text to search
val order : String = order_example // String | Attribute to order items by
val orderDirection : String = orderDirection_example // String | How to order the data i.e. ascending (A-Z) or descending (Z-A)
try {
    val result : CampaignList = apiInstance.listCampaigns(limit, offset, searchText, order, orderDirection)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CampaignApi#listCampaigns")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CampaignApi#listCampaigns")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **searchText** | **String**| Optional text to search | [optional]
 **order** | **String**| Attribute to order items by | [optional] [enum: name, published_date, id, completed_contact_count, active_contact_count, date_created]
 **orderDirection** | **String**| How to order the data i.e. ascending (A-Z) or descending (Z-A) | [optional] [enum: ascending, descending]

### Return type

[**CampaignList**](CampaignList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeContactFromCampaignSequence"></a>
# **removeContactFromCampaignSequence**
> removeContactFromCampaignSequence(campaignId, sequenceId, contactId)

Remove from Campaign Sequence

Removes a single contact from a campaign sequence

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CampaignApi()
val campaignId : Long = 789 // Long | campaignId
val sequenceId : Long = 789 // Long | sequenceId
val contactId : Long = 789 // Long | contactId
try {
    apiInstance.removeContactFromCampaignSequence(campaignId, sequenceId, contactId)
} catch (e: ClientException) {
    println("4xx response calling CampaignApi#removeContactFromCampaignSequence")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CampaignApi#removeContactFromCampaignSequence")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **Long**| campaignId |
 **sequenceId** | **Long**| sequenceId |
 **contactId** | **Long**| contactId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeContactsFromCampaignSequence"></a>
# **removeContactsFromCampaignSequence**
> removeContactsFromCampaignSequence(campaignId, sequenceId, ids)

Remove Multiple from Campaign Sequence

Removes a list of contacts from a campaign sequence

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CampaignApi()
val campaignId : Long = 789 // Long | campaignId
val sequenceId : Long = 789 // Long | sequenceId
val ids : SetOfIds =  // SetOfIds | ids
try {
    apiInstance.removeContactsFromCampaignSequence(campaignId, sequenceId, ids)
} catch (e: ClientException) {
    println("4xx response calling CampaignApi#removeContactsFromCampaignSequence")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CampaignApi#removeContactsFromCampaignSequence")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **Long**| campaignId |
 **sequenceId** | **Long**| sequenceId |
 **ids** | [**SetOfIds**](SetOfIds.md)| ids |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# AffiliateApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**retrieveAffiliateModel**](AffiliateApi.md#retrieveAffiliateModel) | **GET** /affiliates/model | Retrieve Affiliate Model
[**searchCommissions**](AffiliateApi.md#searchCommissions) | **GET** /affiliates/commissions | Retrieve Commissions


<a name="retrieveAffiliateModel"></a>
# **retrieveAffiliateModel**
> ObjectModel retrieveAffiliateModel()

Retrieve Affiliate Model

Get the custom fields for the Affiliate object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AffiliateApi()
try {
    val result : ObjectModel = apiInstance.retrieveAffiliateModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AffiliateApi#retrieveAffiliateModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AffiliateApi#retrieveAffiliateModel")
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

<a name="searchCommissions"></a>
# **searchCommissions**
> AffiliateCommissionList searchCommissions(since, until, limit, offset, affiliateId)

Retrieve Commissions

Retrieve a list of Commissions based on Affiliate or Date Range

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AffiliateApi()
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val affiliateId : Long = 789 // Long | Affiliate to retrieve commissions for
try {
    val result : AffiliateCommissionList = apiInstance.searchCommissions(since, until, limit, offset, affiliateId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AffiliateApi#searchCommissions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AffiliateApi#searchCommissions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **since** | **String**| Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **affiliateId** | **Long**| Affiliate to retrieve commissions for | [optional]

### Return type

[**AffiliateCommissionList**](AffiliateCommissionList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


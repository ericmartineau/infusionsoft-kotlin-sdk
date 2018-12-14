# MerchantApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMerchantAccounts**](MerchantApi.md#getMerchantAccounts) | **GET** /merchants | List Merchants


<a name="getMerchantAccounts"></a>
# **getMerchantAccounts**
> RestMerchantAccountResponse getMerchantAccounts()

List Merchants

Retrieves a list of all merchant accounts

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = MerchantApi()
try {
    val result : RestMerchantAccountResponse = apiInstance.getMerchantAccounts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantApi#getMerchantAccounts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantApi#getMerchantAccounts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestMerchantAccountResponse**](RestMerchantAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


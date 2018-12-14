# AccountInfoApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountProfile**](AccountInfoApi.md#getAccountProfile) | **GET** /account/profile | Retrieve account profile
[**updateAccountInfo**](AccountInfoApi.md#updateAccountInfo) | **PUT** /account/profile | Updates an account profile


<a name="getAccountProfile"></a>
# **getAccountProfile**
> AccountProfile getAccountProfile()

Retrieve account profile

Retrieves profile/company info for an account.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AccountInfoApi()
try {
    val result : AccountProfile = apiInstance.getAccountProfile()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountInfoApi#getAccountProfile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountInfoApi#getAccountProfile")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AccountProfile**](AccountProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountInfo"></a>
# **updateAccountInfo**
> AccountProfile updateAccountInfo(accountInfo)

Updates an account profile

Updates profile/company info for an account.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AccountInfoApi()
val accountInfo : AccountProfile =  // AccountProfile | accountInfo
try {
    val result : AccountProfile = apiInstance.updateAccountInfo(accountInfo)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountInfoApi#updateAccountInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountInfoApi#updateAccountInfo")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountInfo** | [**AccountProfile**](AccountProfile.md)| accountInfo |

### Return type

[**AccountProfile**](AccountProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


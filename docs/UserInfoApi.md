# UserInfoApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserInfo**](UserInfoApi.md#getUserInfo) | **GET** /oauth/connect/userinfo | Retrieve User Info


<a name="getUserInfo"></a>
# **getUserInfo**
> UserInfoDTO getUserInfo()

Retrieve User Info

Retrieves information for the current authenticated end-user, as outlined by the [OpenID Connect specification](http://openid.net/specs/openid-connect-core-1_0.html#UserInfo).

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = UserInfoApi()
try {
    val result : UserInfoDTO = apiInstance.getUserInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserInfoApi#getUserInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserInfoApi#getUserInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserInfoDTO**](UserInfoDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


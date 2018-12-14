# SettingApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getApplicationEnabled**](SettingApi.md#getApplicationEnabled) | **GET** /setting/application/enabled | Retrieve application status
[**getContactOptionTypes**](SettingApi.md#getContactOptionTypes) | **GET** /setting/contact/optionTypes | List Contact types


<a name="getApplicationEnabled"></a>
# **getApplicationEnabled**
> Setting getApplicationEnabled()

Retrieve application status

Retrieves whether the application is enabled

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = SettingApi()
try {
    val result : Setting = apiInstance.getApplicationEnabled()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingApi#getApplicationEnabled")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingApi#getApplicationEnabled")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Setting**](Setting.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getContactOptionTypes"></a>
# **getContactOptionTypes**
> Setting getContactOptionTypes()

List Contact types

Lists the Contact types in a comma-separated list

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = SettingApi()
try {
    val result : Setting = apiInstance.getContactOptionTypes()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SettingApi#getContactOptionTypes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SettingApi#getContactOptionTypes")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Setting**](Setting.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


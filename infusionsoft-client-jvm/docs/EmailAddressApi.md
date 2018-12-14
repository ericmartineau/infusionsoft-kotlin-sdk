# EmailAddressApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**replaceEmailAddress**](EmailAddressApi.md#replaceEmailAddress) | **PUT** /emailAddresses/{email} | Replace an Email Address


<a name="replaceEmailAddress"></a>
# **replaceEmailAddress**
> RestEmailAddress replaceEmailAddress(email, update)

Replace an Email Address

Replaces all of the values of a given email address

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = EmailAddressApi()
val email : String = email_example // String | email
val update : UpdateEmailAddress =  // UpdateEmailAddress | update
try {
    val result : RestEmailAddress = apiInstance.replaceEmailAddress(email, update)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmailAddressApi#replaceEmailAddress")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmailAddressApi#replaceEmailAddress")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| email |
 **update** | [**UpdateEmailAddress**](UpdateEmailAddress.md)| update |

### Return type

[**RestEmailAddress**](RestEmailAddress.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


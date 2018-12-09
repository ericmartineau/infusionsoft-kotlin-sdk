# UsersApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UsersApi.md#createUser) | **POST** /users | Create a User
[**listUsers**](UsersApi.md#listUsers) | **GET** /users | List Users


<a name="createUser"></a>
# **createUser**
> RestUser createUser(user)

Create a User

Creates a new user record. NB: Users will be invited to the application and remain in the \&quot;Invited\&quot; status until the user accepts the invite. \&quot;Inactive\&quot; users will not take up a user license.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = UsersApi()
val user : CreateUser =  // CreateUser | user
try {
    val result : RestUser = apiInstance.createUser(user)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsersApi#createUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsersApi#createUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**CreateUser**](CreateUser.md)| user | [optional]

### Return type

[**RestUser**](RestUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listUsers"></a>
# **listUsers**
> Users listUsers(limit, offset, includeInactive, includePartners)

List Users

Retrieves a list of all users

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = UsersApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val includeInactive : Boolean = true // Boolean | Include users that are Inactive in results, defaults to TRUE
val includePartners : Boolean = true // Boolean | Include partner users in results, defaults to TRUE
try {
    val result : Users = apiInstance.listUsers(limit, offset, includeInactive, includePartners)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsersApi#listUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsersApi#listUsers")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **includeInactive** | **Boolean**| Include users that are Inactive in results, defaults to TRUE | [optional]
 **includePartners** | **Boolean**| Include partner users in results, defaults to TRUE | [optional]

### Return type

[**Users**](Users.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


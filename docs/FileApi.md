# FileApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFile**](FileApi.md#createFile) | **POST** /files | Upload File
[**deleteFile**](FileApi.md#deleteFile) | **DELETE** /files/{fileId} | Delete File
[**getFile**](FileApi.md#getFile) | **GET** /files/{fileId} | Retrieve File
[**listFiles**](FileApi.md#listFiles) | **GET** /files | List Files
[**updateFile**](FileApi.md#updateFile) | **PUT** /files/{fileId} | Replace File


<a name="createFile"></a>
# **createFile**
> FileInformation createFile(fileUpload)

Upload File

Upload a base64 encoded file. &#x60;contact_id&#x60; is required only when &#x60;file_association&#x60; is &#x60;CONTACT&#x60;.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = FileApi()
val fileUpload : FileUpload =  // FileUpload | fileUpload
try {
    val result : FileInformation = apiInstance.createFile(fileUpload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FileApi#createFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FileApi#createFile")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileUpload** | [**FileUpload**](FileUpload.md)| fileUpload | [optional]

### Return type

[**FileInformation**](FileInformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFile"></a>
# **deleteFile**
> deleteFile(fileId)

Delete File

Deletes the specified file

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = FileApi()
val fileId : Long = 789 // Long | fileId
try {
    apiInstance.deleteFile(fileId)
} catch (e: ClientException) {
    println("4xx response calling FileApi#deleteFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FileApi#deleteFile")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | **Long**| fileId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFile"></a>
# **getFile**
> FileInformation getFile(fileId, optionalProperties)

Retrieve File

Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = FileApi()
val fileId : Long = 789 // Long | fileId
val optionalProperties : List<String> =  // List<String> | Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.)
try {
    val result : FileInformation = apiInstance.getFile(fileId, optionalProperties)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FileApi#getFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FileApi#getFile")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | **Long**| fileId |
 **optionalProperties** | [**List&lt;String&gt;**](String.md)| Comma-delimited list of File properties to include in the response. (Some fields such as &#x60;file_data&#x60; aren&#39;t included, by default.) | [optional]

### Return type

[**FileInformation**](FileInformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listFiles"></a>
# **listFiles**
> FileList listFiles(limit, offset, viewable, permission, type, name, contactId)

List Files

Retrieves a list of all files

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = FileApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val viewable : String = viewable_example // String | Include public or private files in response (PUBLIC or PRIVATE), defaults to BOTH.
val permission : String = permission_example // String | Filter based on the permission of files (USER or COMPANY), defaults to BOTH.
val type : String = type_example // String | Filter based on the type of file.
val name : String = name_example // String | Filter files based on name, with '*' preceding or following to indicate LIKE queries.
val contactId : Long = 789 // Long | Filter based on Contact Id, if user has permission to see Contact files.
try {
    val result : FileList = apiInstance.listFiles(limit, offset, viewable, permission, type, name, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FileApi#listFiles")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FileApi#listFiles")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **viewable** | **String**| Include public or private files in response (PUBLIC or PRIVATE), defaults to BOTH. | [optional] [enum: PUBLIC, PRIVATE, BOTH]
 **permission** | **String**| Filter based on the permission of files (USER or COMPANY), defaults to BOTH. | [optional] [enum: USER, COMPANY, BOTH]
 **type** | **String**| Filter based on the type of file. | [optional] [enum: Application, Image, Fax, Attachment, Ticket, Contact, DigitalProduct, Import, Hidden, WebForm, StyledCart, ReSampledImage, TemplateThumbnail, Funnel, LogoThumbnail]
 **name** | **String**| Filter files based on name, with &#39;*&#39; preceding or following to indicate LIKE queries. | [optional]
 **contactId** | **Long**| Filter based on Contact Id, if user has permission to see Contact files. | [optional]

### Return type

[**FileList**](FileList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateFile"></a>
# **updateFile**
> FileInformation updateFile(fileId, fileUpload)

Replace File

Upload a base64 encoded file to replace an existing one. &#x60;contact_id&#x60; is required only when &#x60;file_association&#x60; is &#x60;CONTACT&#x60;.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = FileApi()
val fileId : Long = 789 // Long | fileId
val fileUpload : FileUpload =  // FileUpload | fileUpload
try {
    val result : FileInformation = apiInstance.updateFile(fileId, fileUpload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FileApi#updateFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FileApi#updateFile")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileId** | **Long**| fileId |
 **fileUpload** | [**FileUpload**](FileUpload.md)| fileUpload | [optional]

### Return type

[**FileInformation**](FileInformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


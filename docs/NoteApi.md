# NoteApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createNote**](NoteApi.md#createNote) | **POST** /notes | Create a Note
[**deleteNote**](NoteApi.md#deleteNote) | **DELETE** /notes/{noteId} | Delete a Note
[**getNote**](NoteApi.md#getNote) | **GET** /notes/{noteId} | Retrieve a Note
[**listNotes**](NoteApi.md#listNotes) | **GET** /notes | List Notes
[**updateNote**](NoteApi.md#updateNote) | **PUT** /notes/{noteId} | Replace a Note
[**updatePropertiesOnNote**](NoteApi.md#updatePropertiesOnNote) | **PATCH** /notes/{noteId} | Update a Note


<a name="createNote"></a>
# **createNote**
> Note createNote(createNote)

Create a Note

Creates a new note as the authenticated user. Either a \&quot;title\&quot; or \&quot;body\&quot; is required

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = NoteApi()
val createNote : RequestNote =  // RequestNote | createNote
try {
    val result : Note = apiInstance.createNote(createNote)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NoteApi#createNote")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NoteApi#createNote")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createNote** | [**RequestNote**](RequestNote.md)| createNote |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteNote"></a>
# **deleteNote**
> deleteNote(noteId)

Delete a Note

Deletes a note

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = NoteApi()
val noteId : Long = 789 // Long | noteId
try {
    apiInstance.deleteNote(noteId)
} catch (e: ClientException) {
    println("4xx response calling NoteApi#deleteNote")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NoteApi#deleteNote")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **noteId** | **Long**| noteId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNote"></a>
# **getNote**
> Note getNote(noteId)

Retrieve a Note

Retrieves a single note

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = NoteApi()
val noteId : Long = 789 // Long | noteId
try {
    val result : Note = apiInstance.getNote(noteId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NoteApi#getNote")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NoteApi#getNote")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **noteId** | **Long**| noteId |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listNotes"></a>
# **listNotes**
> NoteList listNotes(limit, offset, userId, contactId)

List Notes

Retrieves a list of all notes

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = NoteApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val userId : Long = 789 // Long | Filter based on the user id assigned to the note.
val contactId : Long = 789 // Long | Filter based on the contact id assigned to the note.
try {
    val result : NoteList = apiInstance.listNotes(limit, offset, userId, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NoteApi#listNotes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NoteApi#listNotes")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **userId** | **Long**| Filter based on the user id assigned to the note. | [optional]
 **contactId** | **Long**| Filter based on the contact id assigned to the note. | [optional]

### Return type

[**NoteList**](NoteList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateNote"></a>
# **updateNote**
> Note updateNote(note, requestNote)

Replace a Note

Replaces all values of a given note

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = NoteApi()
val note : Long = 789 // Long | note
val requestNote : RequestNote =  // RequestNote | requestNote
try {
    val result : Note = apiInstance.updateNote(note, requestNote)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NoteApi#updateNote")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NoteApi#updateNote")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **note** | **Long**| note |
 **requestNote** | [**RequestNote**](RequestNote.md)| requestNote |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePropertiesOnNote"></a>
# **updatePropertiesOnNote**
> Note updatePropertiesOnNote(noteId, note)

Update a Note

Updates a note with only the values provided in the request

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = NoteApi()
val noteId : Long = 789 // Long | noteId
val note : UpdateNote =  // UpdateNote | note
try {
    val result : Note = apiInstance.updatePropertiesOnNote(noteId, note)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NoteApi#updatePropertiesOnNote")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NoteApi#updatePropertiesOnNote")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **noteId** | **Long**| noteId |
 **note** | [**UpdateNote**](UpdateNote.md)| note | [optional]

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# AppointmentApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAppointment**](AppointmentApi.md#createAppointment) | **POST** /appointments | Create an Appointment
[**deleteAppointment**](AppointmentApi.md#deleteAppointment) | **DELETE** /appointments/{appointmentId} | Delete an Appointment
[**getAppointment**](AppointmentApi.md#getAppointment) | **GET** /appointments/{appointmentId} | Retrieve an Appointment
[**listAppointments**](AppointmentApi.md#listAppointments) | **GET** /appointments | List Appointments
[**retrieveAppointmentModel**](AppointmentApi.md#retrieveAppointmentModel) | **GET** /appointments/model | Retrieve Appointment Model
[**updateAppointment**](AppointmentApi.md#updateAppointment) | **PUT** /appointments/{appointmentId} | Replace an Appointment
[**updatePropertiesOnAppointment**](AppointmentApi.md#updatePropertiesOnAppointment) | **PATCH** /appointments/{appointmentId} | Update an Appointment


<a name="createAppointment"></a>
# **createAppointment**
> Appointment createAppointment(appointment)

Create an Appointment

Creates a new appointment as the authenticated user

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
val appointment : Appointment =  // Appointment | appointment
try {
    val result : Appointment = apiInstance.createAppointment(appointment)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#createAppointment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#createAppointment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appointment** | [**Appointment**](Appointment.md)| appointment |

### Return type

[**Appointment**](Appointment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAppointment"></a>
# **deleteAppointment**
> deleteAppointment(appointmentId)

Delete an Appointment

Deletes the specified appointment

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
val appointmentId : Long = 789 // Long | appointmentId
try {
    apiInstance.deleteAppointment(appointmentId)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#deleteAppointment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#deleteAppointment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appointmentId** | **Long**| appointmentId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAppointment"></a>
# **getAppointment**
> Appointment getAppointment(appointmentId)

Retrieve an Appointment

Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \&quot;can view all records\&quot; permission for Task/Appt/Notes

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
val appointmentId : Long = 789 // Long | appointmentId
try {
    val result : Appointment = apiInstance.getAppointment(appointmentId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#getAppointment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#getAppointment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appointmentId** | **Long**| appointmentId |

### Return type

[**Appointment**](Appointment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listAppointments"></a>
# **listAppointments**
> AppointmentList listAppointments(since, until, limit, offset, contactId)

List Appointments

Retrieves all appointments for the authenticated user

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val contactId : Long = 789 // Long | Optionally find appointments with a contact
try {
    val result : AppointmentList = apiInstance.listAppointments(since, until, limit, offset, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#listAppointments")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#listAppointments")
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
 **contactId** | **Long**| Optionally find appointments with a contact | [optional]

### Return type

[**AppointmentList**](AppointmentList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveAppointmentModel"></a>
# **retrieveAppointmentModel**
> ObjectModel retrieveAppointmentModel()

Retrieve Appointment Model

Get the custom fields for the Appointment object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
try {
    val result : ObjectModel = apiInstance.retrieveAppointmentModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#retrieveAppointmentModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#retrieveAppointmentModel")
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

<a name="updateAppointment"></a>
# **updateAppointment**
> Appointment updateAppointment(appointmentId, appointmentDTO)

Replace an Appointment

Replaces all values of a given appointment

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
val appointmentId : Long = 789 // Long | appointmentId
val appointmentDTO : Appointment =  // Appointment | appointmentDTO
try {
    val result : Appointment = apiInstance.updateAppointment(appointmentId, appointmentDTO)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#updateAppointment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#updateAppointment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appointmentId** | **Long**| appointmentId |
 **appointmentDTO** | [**Appointment**](Appointment.md)| appointmentDTO |

### Return type

[**Appointment**](Appointment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePropertiesOnAppointment"></a>
# **updatePropertiesOnAppointment**
> Appointment updatePropertiesOnAppointment(appointmentId, appointmentDTO)

Update an Appointment

Updates the provided values of a given appointment

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = AppointmentApi()
val appointmentId : Long = 789 // Long | appointmentId
val appointmentDTO : Appointment =  // Appointment | appointmentDTO
try {
    val result : Appointment = apiInstance.updatePropertiesOnAppointment(appointmentId, appointmentDTO)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppointmentApi#updatePropertiesOnAppointment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppointmentApi#updatePropertiesOnAppointment")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appointmentId** | **Long**| appointmentId |
 **appointmentDTO** | [**Appointment**](Appointment.md)| appointmentDTO |

### Return type

[**Appointment**](Appointment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


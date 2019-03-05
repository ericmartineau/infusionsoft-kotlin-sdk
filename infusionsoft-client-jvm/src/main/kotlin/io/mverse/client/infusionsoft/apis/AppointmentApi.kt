/**
* Infusionsoft REST API
* No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
*
* OpenAPI spec version: 1.70.0.78606
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Appointment
import io.mverse.client.infusionsoft.models.AppointmentList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel

import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

    interface AppointmentApi {

        /**
        *  Create an Appointment
        *  Creates a new appointment as the authenticated user
        *  * @param appointment appointment 
        *  * @return Appointment
        */
        fun createAppointment(appointment: Appointment) : Appointment
        /**
        *  Delete an Appointment
        *  Deletes the specified appointment
        *  * @param appointmentId appointmentId 
        *  * @return void
        */
        fun deleteAppointment(appointmentId: Long) : Unit
        /**
        *  Retrieve an Appointment
        *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \&quot;can view all records\&quot; permission for Task/Appt/Notes
        *  * @param appointmentId appointmentId 
        *  * @return Appointment
        */
        fun getAppointment(appointmentId: Long) : Appointment
        /**
        *  List Appointments
        *  Retrieves all appointments for the authenticated user
        *  * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
        *  * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
        *  * @param limit Sets a total of items to return (optional)
        *  * @param offset Sets a beginning range of items to return (optional)
        *  * @param contactId Optionally find appointments with a contact (optional)
        *  * @return AppointmentList
        */
        fun listAppointments(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : AppointmentList
        /**
        *  Retrieve Appointment Model
        *  Get the custom fields for the Appointment object
        *  * @return ObjectModel
        */
        fun retrieveAppointmentModel() : ObjectModel
        /**
        *  Replace an Appointment
        *  Replaces all values of a given appointment
        *  * @param appointmentId appointmentId 
        *  * @param appointmentDTO appointmentDTO 
        *  * @return Appointment
        */
        fun updateAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment
        /**
        *  Update an Appointment
        *  Updates the provided values of a given appointment
        *  * @param appointmentId appointmentId 
        *  * @param appointmentDTO appointmentDTO 
        *  * @return Appointment
        */
        fun updatePropertiesOnAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment
    }

class AppointmentApiImpl(bearerToken:String, basePath: String, gson: Gson) : AppointmentApi, ApiClient(basePath, bearerToken, gson) {

  /**
   *  Create an Appointment
   *  Creates a new appointment as the authenticated user
   *  * @param appointment appointment 
   *  * @return Appointment
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun createAppointment(appointment: Appointment) : Appointment {
    val requestBody = appointment
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/appointments",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<Appointment>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Delete an Appointment
   *  Deletes the specified appointment
   *  * @param appointmentId appointmentId 
   *  * @return void
   */ 
  override fun deleteAppointment(appointmentId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/appointments/{appointmentId}".replace("{"+"appointmentId"+"}", "$appointmentId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<Unit>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve an Appointment
   *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \&quot;can view all records\&quot; permission for Task/Appt/Notes
   *  * @param appointmentId appointmentId 
   *  * @return Appointment
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun getAppointment(appointmentId: Long) : Appointment {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/appointments/{appointmentId}".replace("{"+"appointmentId"+"}", "$appointmentId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<Appointment>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Appointments
   *  Retrieves all appointments for the authenticated user
   *  * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param contactId Optionally find appointments with a contact (optional)
   *  * @return AppointmentList
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun listAppointments(since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?) : AppointmentList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (since != null) localVariableQuery["since"] = listOf("$since")
    if (until != null) localVariableQuery["until"] = listOf("$until")
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/appointments",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<AppointmentList>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Appointment Model
   *  Get the custom fields for the Appointment object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun retrieveAppointmentModel() : ObjectModel {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/appointments/model",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<ObjectModel>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Replace an Appointment
   *  Replaces all values of a given appointment
   *  * @param appointmentId appointmentId 
   *  * @param appointmentDTO appointmentDTO 
   *  * @return Appointment
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun updateAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment {
    val requestBody = appointmentDTO
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PUT,
       "/appointments/{appointmentId}".replace("{"+"appointmentId"+"}", "$appointmentId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<Appointment>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Update an Appointment
   *  Updates the provided values of a given appointment
   *  * @param appointmentId appointmentId 
   *  * @param appointmentDTO appointmentDTO 
   *  * @return Appointment
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun updatePropertiesOnAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment {
    val requestBody = appointmentDTO
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PATCH,
       "/appointments/{appointmentId}".replace("{"+"appointmentId"+"}", "$appointmentId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<Appointment>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
}


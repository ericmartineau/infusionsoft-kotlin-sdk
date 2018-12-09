/**
* Infusionsoft REST API
* No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
*
* OpenAPI spec version: 1.70.0.72014
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

class AppointmentApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Create an Appointment
    * Creates a new appointment as the authenticated user
    * @param appointment appointment 
    * @return Appointment
    */
    @Suppress("UNCHECKED_CAST")
    fun createAppointment(appointment: Appointment) : Appointment {
        val localVariableBody: Any? = appointment
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
        val response = request<Appointment>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Appointment
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Delete an Appointment
    * Deletes the specified appointment
    * @param appointmentId appointmentId 
    * @return void
    */
    fun deleteAppointment(appointmentId: Long) : Unit {
        val localVariableBody: Any? = null
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
        val response = request<Unit>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Retrieve an Appointment
    * Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \&quot;can view all records\&quot; permission for Task/Appt/Notes
    * @param appointmentId appointmentId 
    * @return Appointment
    */
    @Suppress("UNCHECKED_CAST")
    fun getAppointment(appointmentId: Long) : Appointment {
        val localVariableBody: Any? = null
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
        val response = request<Appointment>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Appointment
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * List Appointments
    * Retrieves all appointments for the authenticated user
    * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param contactId Optionally find appointments with a contact (optional)
    * @return AppointmentList
    */
    @Suppress("UNCHECKED_CAST")
    fun listAppointments(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : AppointmentList {
        val localVariableBody: Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        if (since != null) localVariableQuery["since"] to listOf("$since")
if (until != null) localVariableQuery["until"] to listOf("$until")
if (limit != null) localVariableQuery["limit"] to listOf("$limit")
if (offset != null) localVariableQuery["offset"] to listOf("$offset")
if (contactId != null) localVariableQuery["contact_id"] to listOf("$contactId")

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
        val response = request<AppointmentList>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as AppointmentList
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Retrieve Appointment Model
    * Get the custom fields for the Appointment object
    * @return ObjectModel
    */
    @Suppress("UNCHECKED_CAST")
    fun retrieveAppointmentModel() : ObjectModel {
        val localVariableBody: Any? = null
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
        val response = request<ObjectModel>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ObjectModel
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Replace an Appointment
    * Replaces all values of a given appointment
    * @param appointmentId appointmentId 
    * @param appointmentDTO appointmentDTO 
    * @return Appointment
    */
    @Suppress("UNCHECKED_CAST")
    fun updateAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment {
        val localVariableBody: Any? = appointmentDTO
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
        val response = request<Appointment>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Appointment
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Update an Appointment
    * Updates the provided values of a given appointment
    * @param appointmentId appointmentId 
    * @param appointmentDTO appointmentDTO 
    * @return Appointment
    */
    @Suppress("UNCHECKED_CAST")
    fun updatePropertiesOnAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment {
        val localVariableBody: Any? = appointmentDTO
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
        val response = request<Appointment>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Appointment
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

}

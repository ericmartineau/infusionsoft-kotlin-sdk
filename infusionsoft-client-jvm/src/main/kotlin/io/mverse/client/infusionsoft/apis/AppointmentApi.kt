@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Appointment
import io.mverse.client.infusionsoft.models.AppointmentList
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface AppointmentApi {

  /**
    *  Create an Appointment
    *  Creates a new appointment as the authenticated user
    *  * @param appointment appointment (optional)
    *  * @return Appointment
    */
  suspend fun createAppointment(appointment: Appointment? = null) : Appointment
    
  /**
    *  Delete an Appointment
    *  Deletes the specified appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @return void
    */
  suspend fun deleteAppointment(appointmentId: Long? = null) : Unit
    
  /**
    *  Retrieve an Appointment
    *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \"can view all records\" permission for Task/Appt/Notes
    *  * @param appointmentId appointmentId (optional)
    *  * @return Appointment
    */
  suspend fun getAppointment(appointmentId: Long? = null) : Appointment
    
  /**
    *  List Appointments
    *  Retrieves all appointments for the authenticated user
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Optionally find appointments with a contact 
    *  * @return AppointmentList
    */
  suspend fun listAppointments(since: String, until: String, limit: Int, offset: Int, contactId: Long) : AppointmentList
    
  /**
    *  Retrieve Appointment Model
    *  Get the custom fields for the Appointment object
    *  * @return ObjectModel
    */
  suspend fun retrieveAppointmentModel() : ObjectModel
    
  /**
    *  Replace an Appointment
    *  Replaces all values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  suspend fun updateAppointment(appointmentId: Long? = null, appointmentDTO: Appointment? = null) : Appointment
    
  /**
    *  Update an Appointment
    *  Updates the provided values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  suspend fun updatePropertiesOnAppointment(appointmentId: Long? = null, appointmentDTO: Appointment? = null) : Appointment
    
}

class AppointmentApiImpl(bearerToken:String, basePath: String, gson: Gson) : AppointmentApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Appointment
    *  Creates a new appointment as the authenticated user
    *  * @param appointment appointment (optional)
    *  * @return Appointment
    */
  override suspend fun createAppointment(appointment: Appointment?) : Appointment {
    val call = request( "/appointments", mapOf()) {
      method = HttpMethod.parse("POST")
      body = appointment ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete an Appointment
    *  Deletes the specified appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @return void
    */
  override suspend fun deleteAppointment(appointmentId: Long?) : Unit {
    val call = request( "/appointments/{appointmentId}", mapOf("appointmentId" to "$appointmentId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve an Appointment
    *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \"can view all records\" permission for Task/Appt/Notes
    *  * @param appointmentId appointmentId (optional)
    *  * @return Appointment
    */
  override suspend fun getAppointment(appointmentId: Long?) : Appointment {
    val call = request( "/appointments/{appointmentId}", mapOf("appointmentId" to "$appointmentId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Appointments
    *  Retrieves all appointments for the authenticated user
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Optionally find appointments with a contact 
    *  * @return AppointmentList
    */
  override suspend fun listAppointments(since: String, until: String, limit: Int, offset: Int, contactId: Long) : AppointmentList {
    val call = request( "/appointments", mapOf()) {
      method = HttpMethod.parse("GET")
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Appointment Model
    *  Get the custom fields for the Appointment object
    *  * @return ObjectModel
    */
  override suspend fun retrieveAppointmentModel() : ObjectModel {
    val call = request( "/appointments/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Replace an Appointment
    *  Replaces all values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  override suspend fun updateAppointment(appointmentId: Long?, appointmentDTO: Appointment?) : Appointment {
    val call = request( "/appointments/{appointmentId}", mapOf("appointmentId" to "$appointmentId")) {
      method = HttpMethod.parse("PUT")
      body = appointmentDTO ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Update an Appointment
    *  Updates the provided values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  override suspend fun updatePropertiesOnAppointment(appointmentId: Long?, appointmentDTO: Appointment?) : Appointment {
    val call = request( "/appointments/{appointmentId}", mapOf("appointmentId" to "$appointmentId")) {
      method = HttpMethod.parse("PATCH")
      body = appointmentDTO ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

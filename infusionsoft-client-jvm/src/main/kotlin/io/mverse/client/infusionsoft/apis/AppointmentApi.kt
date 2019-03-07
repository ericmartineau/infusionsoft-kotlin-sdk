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
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface AppointmentApi {

  /**
    *  Create an Appointment
    *  Creates a new appointment as the authenticated user
    *  * @param appointment appointment (optional)
    *  * @return Appointment
    */
  suspend fun createAppointment(appointment: Appointment) : Appointment

  /**
    *  Asynchronous implementation of Create an Appointment
    *  Creates a new appointment as the authenticated user
    *  * @param appointment appointment (optional)
    *  * @return A deferred reference to the final Appointment
    */
  fun createAppointmentAsync(appointment: Appointment) : Deferred<Appointment>

  /**
    *  Delete an Appointment
    *  Deletes the specified appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @return void
    */
  suspend fun deleteAppointment(appointmentId: Long)

  /**
    *  Asynchronous implementation of Delete an Appointment
    *  Deletes the specified appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @return A deferred reference to the final void
    */
  fun deleteAppointmentAsync(appointmentId: Long) : Deferred<Unit>

  /**
    *  Retrieve an Appointment
    *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \"can view all records\" permission for Task/Appt/Notes
    *  * @param appointmentId appointmentId (optional)
    *  * @return Appointment
    */
  suspend fun getAppointment(appointmentId: Long) : Appointment

  /**
    *  Asynchronous implementation of Retrieve an Appointment
    *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \"can view all records\" permission for Task/Appt/Notes
    *  * @param appointmentId appointmentId (optional)
    *  * @return A deferred reference to the final Appointment
    */
  fun getAppointmentAsync(appointmentId: Long) : Deferred<Appointment>

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
  suspend fun listAppointments(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : AppointmentList

  /**
    *  Asynchronous implementation of List Appointments
    *  Retrieves all appointments for the authenticated user
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z`
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z`
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param contactId Optionally find appointments with a contact
    *  * @return A deferred reference to the final AppointmentList
    */
  fun listAppointmentsAsync(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : Deferred<AppointmentList>

  /**
    *  Retrieve Appointment Model
    *  Get the custom fields for the Appointment object
    *  * @return ObjectModel
    */
  suspend fun retrieveAppointmentModel() : ObjectModel

  /**
    *  Asynchronous implementation of Retrieve Appointment Model
    *  Get the custom fields for the Appointment object
    *  * @return A deferred reference to the final ObjectModel
    */
  fun retrieveAppointmentModelAsync() : Deferred<ObjectModel>

  /**
    *  Replace an Appointment
    *  Replaces all values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  suspend fun updateAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment

  /**
    *  Asynchronous implementation of Replace an Appointment
    *  Replaces all values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return A deferred reference to the final Appointment
    */
  fun updateAppointmentAsync(appointmentId: Long, appointmentDTO: Appointment) : Deferred<Appointment>

  /**
    *  Update an Appointment
    *  Updates the provided values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  suspend fun updatePropertiesOnAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment

  /**
    *  Asynchronous implementation of Update an Appointment
    *  Updates the provided values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return A deferred reference to the final Appointment
    */
  fun updatePropertiesOnAppointmentAsync(appointmentId: Long, appointmentDTO: Appointment) : Deferred<Appointment>

}

class AppointmentApiImpl(bearerToken:String, basePath: String, gson: Gson) : AppointmentApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Appointment
    *  Creates a new appointment as the authenticated user
    *  * @param appointment appointment (optional)
    *  * @return Appointment
    */
  override suspend fun createAppointment(appointment: Appointment) : Appointment {
    val uri = uriTemplate("/appointments")
      .build()
    val call = post(uri) {
      body = appointment ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create an Appointment
    *  Creates a new appointment as the authenticated user
    *  * @param appointment appointment (optional)
    *  * @return A deferred reference to the final Appointment
    */
  override fun createAppointmentAsync(appointment: Appointment)  =
        client.async { createAppointment(appointment) }

  /**
    *  Delete an Appointment
    *  Deletes the specified appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @return void
    */
  override suspend fun deleteAppointment(appointmentId: Long) {
    val uri = uriTemplate("/appointments/{appointmentId}")
      .parameter("appointmentId", appointmentId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Delete an Appointment
    *  Deletes the specified appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @return A deferred reference to the final void
    */
  override fun deleteAppointmentAsync(appointmentId: Long)  =
        client.async { deleteAppointment(appointmentId) }

  /**
    *  Retrieve an Appointment
    *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \"can view all records\" permission for Task/Appt/Notes
    *  * @param appointmentId appointmentId (optional)
    *  * @return Appointment
    */
  override suspend fun getAppointment(appointmentId: Long) : Appointment {
    val uri = uriTemplate("/appointments/{appointmentId}")
      .parameter("appointmentId", appointmentId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Retrieve an Appointment
    *  Retrieves a specific appointment with respect to user permissions. The authenticated user will need the \"can view all records\" permission for Task/Appt/Notes
    *  * @param appointmentId appointmentId (optional)
    *  * @return A deferred reference to the final Appointment
    */
  override fun getAppointmentAsync(appointmentId: Long)  =
        client.async { getAppointment(appointmentId) }

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
  override suspend fun listAppointments(since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?) : AppointmentList {
    val uri = uriTemplate("/appointments")
      .build()
    val call = get(uri) {
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("contact_id",  contactId)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Appointments
    *  Retrieves all appointments for the authenticated user
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z`
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z`
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param contactId Optionally find appointments with a contact
    *  * @return A deferred reference to the final AppointmentList
    */
  override fun listAppointmentsAsync(since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?)  =
        client.async { listAppointments(since, until, limit, offset, contactId) }

  /**
    *  Retrieve Appointment Model
    *  Get the custom fields for the Appointment object
    *  * @return ObjectModel
    */
  override suspend fun retrieveAppointmentModel() : ObjectModel {
    val uri = uriTemplate("/appointments/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Retrieve Appointment Model
    *  Get the custom fields for the Appointment object
    *  * @return A deferred reference to the final ObjectModel
    */
  override fun retrieveAppointmentModelAsync()  =
        client.async { retrieveAppointmentModel() }

  /**
    *  Replace an Appointment
    *  Replaces all values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  override suspend fun updateAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment {
    val uri = uriTemplate("/appointments/{appointmentId}")
      .parameter("appointmentId", appointmentId)
      .build()
    val call = put(uri) {
      body = appointmentDTO ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Replace an Appointment
    *  Replaces all values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return A deferred reference to the final Appointment
    */
  override fun updateAppointmentAsync(appointmentId: Long, appointmentDTO: Appointment)  =
        client.async { updateAppointment(appointmentId, appointmentDTO) }

  /**
    *  Update an Appointment
    *  Updates the provided values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return Appointment
    */
  override suspend fun updatePropertiesOnAppointment(appointmentId: Long, appointmentDTO: Appointment) : Appointment {
    val uri = uriTemplate("/appointments/{appointmentId}")
      .parameter("appointmentId", appointmentId)
      .build()
    val call = patch(uri) {
      body = appointmentDTO ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Update an Appointment
    *  Updates the provided values of a given appointment
    *  * @param appointmentId appointmentId (optional)
    *  * @param appointmentDTO appointmentDTO (optional)
    *  * @return A deferred reference to the final Appointment
    */
  override fun updatePropertiesOnAppointmentAsync(appointmentId: Long, appointmentDTO: Appointment)  =
        client.async { updatePropertiesOnAppointment(appointmentId, appointmentDTO) }

}


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

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.Note
import io.mverse.client.infusionsoft.models.NoteList
import io.mverse.client.infusionsoft.models.RequestNote
import io.mverse.client.infusionsoft.models.UpdateNote

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*


class NoteApi(bearerToken:String, basePath: String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

  /**
   *  Create a Note
   *  Creates a new note as the authenticated user. Either a \&quot;title\&quot; or \&quot;body\&quot; is required
   *  * @param createNote createNote 
   *  * @return Note
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createNote(createNote: RequestNote) : Note {
    val requestBody = createNote
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/notes",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Note.serializer(),
      RequestNote.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Note
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Delete a Note
   *  Deletes a note
   *  * @param noteId noteId 
   *  * @return void
   */ 
  fun deleteNote(noteId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/notes/{noteId}".replace("{"+"noteId"+"}", "$noteId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, UnitSerializer)

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
   *  Retrieve a Note
   *  Retrieves a single note
   *  * @param noteId noteId 
   *  * @return Note
   */ 
  @Suppress("UNCHECKED_CAST")
  fun getNote(noteId: Long) : Note {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/notes/{noteId}".replace("{"+"noteId"+"}", "$noteId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Note.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Note
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Notes
   *  Retrieves a list of all notes
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param userId Filter based on the user id assigned to the note. (optional)
   *  * @param contactId Filter based on the contact id assigned to the note. (optional)
   *  * @return NoteList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listNotes(limit: Int? = null, offset: Int? = null, userId: Long? = null, contactId: Long? = null) : NoteList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (userId != null) localVariableQuery["user_id"] = listOf("$userId")
    if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/notes",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      NoteList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as NoteList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Replace a Note
   *  Replaces all values of a given note
   *  * @param note note 
   *  * @param requestNote requestNote 
   *  * @return Note
   */ 
  @Suppress("UNCHECKED_CAST")
  fun updateNote(note: Long, requestNote: RequestNote) : Note {
    val requestBody = requestNote
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PUT,
       "/notes/{noteId}".replace("{"+"note"+"}", "$note"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Note.serializer(),
      RequestNote.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Note
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Update a Note
   *  Updates a note with only the values provided in the request
   *  * @param noteId noteId 
   *  * @param note note (optional)
   *  * @return Note
   */ 
  @Suppress("UNCHECKED_CAST")
  fun updatePropertiesOnNote(noteId: Long, note: UpdateNote? = null) : Note {
    val requestBody = note
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PATCH,
       "/notes/{noteId}".replace("{"+"noteId"+"}", "$noteId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Note.serializer(),
      UpdateNote.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Note
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
}

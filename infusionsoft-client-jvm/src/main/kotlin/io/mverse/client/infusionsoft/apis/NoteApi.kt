@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.Note
import io.mverse.client.infusionsoft.models.NoteList
import io.mverse.client.infusionsoft.models.RequestNote
import io.mverse.client.infusionsoft.models.UpdateNote


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface NoteApi {

  /**
    *  Create a Note
    *  Creates a new note as the authenticated user. Either a \"title\" or \"body\" is required
    *  * @param createNote createNote (optional)
    *  * @return Note
    */
  suspend fun createNote(createNote: RequestNote? = null) : Note
    
  /**
    *  Delete a Note
    *  Deletes a note
    *  * @param noteId noteId (optional)
    *  * @return void
    */
  suspend fun deleteNote(noteId: Long? = null) : Unit
    
  /**
    *  Retrieve a Note
    *  Retrieves a single note
    *  * @param noteId noteId (optional)
    *  * @return Note
    */
  suspend fun getNote(noteId: Long? = null) : Note
    
  /**
    *  List Notes
    *  Retrieves a list of all notes
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Filter based on the user id assigned to the note. 
    *  * @param contactId Filter based on the contact id assigned to the note. 
    *  * @return NoteList
    */
  suspend fun listNotes(limit: Int, offset: Int, userId: Long, contactId: Long) : NoteList
    
  /**
    *  Replace a Note
    *  Replaces all values of a given note
    *  * @param note note (optional)
    *  * @param requestNote requestNote (optional)
    *  * @return Note
    */
  suspend fun updateNote(note: Long? = null, requestNote: RequestNote? = null) : Note
    
  /**
    *  Update a Note
    *  Updates a note with only the values provided in the request
    *  * @param noteId noteId (optional)
    *  * @param note note 
    *  * @return Note
    */
  suspend fun updatePropertiesOnNote(noteId: Long? = null, note: UpdateNote) : Note
    
}

class NoteApiImpl(bearerToken:String, basePath: String, gson: Gson) : NoteApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Note
    *  Creates a new note as the authenticated user. Either a \"title\" or \"body\" is required
    *  * @param createNote createNote (optional)
    *  * @return Note
    */
  override suspend fun createNote(createNote: RequestNote?) : Note {
    val call = request( "/notes", mapOf()) {
      method = HttpMethod.parse("POST")
      body = createNote ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete a Note
    *  Deletes a note
    *  * @param noteId noteId (optional)
    *  * @return void
    */
  override suspend fun deleteNote(noteId: Long?) : Unit {
    val call = request( "/notes/{noteId}", mapOf("noteId" to "$noteId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve a Note
    *  Retrieves a single note
    *  * @param noteId noteId (optional)
    *  * @return Note
    */
  override suspend fun getNote(noteId: Long?) : Note {
    val call = request( "/notes/{noteId}", mapOf("noteId" to "$noteId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Notes
    *  Retrieves a list of all notes
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Filter based on the user id assigned to the note. 
    *  * @param contactId Filter based on the contact id assigned to the note. 
    *  * @return NoteList
    */
  override suspend fun listNotes(limit: Int, offset: Int, userId: Long, contactId: Long) : NoteList {
    val call = request( "/notes", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (userId != null) url.parameters.append("user_id", "$userId")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
    }
    return call.receive()
  }

  /**
    *  Replace a Note
    *  Replaces all values of a given note
    *  * @param note note (optional)
    *  * @param requestNote requestNote (optional)
    *  * @return Note
    */
  override suspend fun updateNote(note: Long?, requestNote: RequestNote?) : Note {
    val call = request( "/notes/{noteId}", mapOf("note" to "$note")) {
      method = HttpMethod.parse("PUT")
      body = requestNote ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Update a Note
    *  Updates a note with only the values provided in the request
    *  * @param noteId noteId (optional)
    *  * @param note note 
    *  * @return Note
    */
  override suspend fun updatePropertiesOnNote(noteId: Long?, note: UpdateNote) : Note {
    val call = request( "/notes/{noteId}", mapOf("noteId" to "$noteId")) {
      method = HttpMethod.parse("PATCH")
      body = note ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

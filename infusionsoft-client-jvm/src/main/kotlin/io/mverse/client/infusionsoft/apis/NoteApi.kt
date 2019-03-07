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
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface NoteApi {

  /**
    *  Create a Note
    *  Creates a new note as the authenticated user. Either a \"title\" or \"body\" is required
    *  * @param createNote createNote (optional)
    *  * @return Note
    */
  suspend fun createNote(createNote: RequestNote) : Note
  
  /**
    *  Asynchronous implementation of Create a Note
    *  Creates a new note as the authenticated user. Either a \"title\" or \"body\" is required
    *  * @param createNote createNote (optional)
    *  * @return A deferred reference to the final Note  
    */
  fun createNoteAsync(createNote: RequestNote) : Deferred<Note>

  /**
    *  Delete a Note
    *  Deletes a note
    *  * @param noteId noteId (optional)
    *  * @return void
    */
  suspend fun deleteNote(noteId: Long)
  
  /**
    *  Asynchronous implementation of Delete a Note
    *  Deletes a note
    *  * @param noteId noteId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteNoteAsync(noteId: Long) : Deferred<Unit>

  /**
    *  Retrieve a Note
    *  Retrieves a single note
    *  * @param noteId noteId (optional)
    *  * @return Note
    */
  suspend fun getNote(noteId: Long) : Note
  
  /**
    *  Asynchronous implementation of Retrieve a Note
    *  Retrieves a single note
    *  * @param noteId noteId (optional)
    *  * @return A deferred reference to the final Note  
    */
  fun getNoteAsync(noteId: Long) : Deferred<Note>

  /**
    *  List Notes
    *  Retrieves a list of all notes
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Filter based on the user id assigned to the note. 
    *  * @param contactId Filter based on the contact id assigned to the note. 
    *  * @return NoteList
    */
  suspend fun listNotes(limit: Int? = null, offset: Int? = null, userId: Long? = null, contactId: Long? = null) : NoteList
  
  /**
    *  Asynchronous implementation of List Notes
    *  Retrieves a list of all notes
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Filter based on the user id assigned to the note. 
    *  * @param contactId Filter based on the contact id assigned to the note. 
    *  * @return A deferred reference to the final NoteList  
    */
  fun listNotesAsync(limit: Int? = null, offset: Int? = null, userId: Long? = null, contactId: Long? = null) : Deferred<NoteList>

  /**
    *  Replace a Note
    *  Replaces all values of a given note
    *  * @param note note (optional)
    *  * @param requestNote requestNote (optional)
    *  * @return Note
    */
  suspend fun updateNote(note: Long, requestNote: RequestNote) : Note
  
  /**
    *  Asynchronous implementation of Replace a Note
    *  Replaces all values of a given note
    *  * @param note note (optional)
    *  * @param requestNote requestNote (optional)
    *  * @return A deferred reference to the final Note  
    */
  fun updateNoteAsync(note: Long, requestNote: RequestNote) : Deferred<Note>

  /**
    *  Update a Note
    *  Updates a note with only the values provided in the request
    *  * @param noteId noteId (optional)
    *  * @param note note 
    *  * @return Note
    */
  suspend fun updatePropertiesOnNote(noteId: Long, note: UpdateNote? = null) : Note
  
  /**
    *  Asynchronous implementation of Update a Note
    *  Updates a note with only the values provided in the request
    *  * @param noteId noteId (optional)
    *  * @param note note 
    *  * @return A deferred reference to the final Note  
    */
  fun updatePropertiesOnNoteAsync(noteId: Long, note: UpdateNote? = null) : Deferred<Note>

}

class NoteApiImpl(bearerToken:String, basePath: String, gson: Gson) : NoteApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Note
    *  Creates a new note as the authenticated user. Either a \"title\" or \"body\" is required
    *  * @param createNote createNote (optional)
    *  * @return Note
    */
  override suspend fun createNote(createNote: RequestNote) : Note {
    val uri = uriTemplate("/notes")
      .build()
    val call = post(uri) {
      body = createNote ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Note
    *  Creates a new note as the authenticated user. Either a \"title\" or \"body\" is required
    *  * @param createNote createNote (optional)
    *  * @return A deferred reference to the final Note  
    */
  override fun createNoteAsync(createNote: RequestNote)  = 
        client.async { createNote(createNote) }

  /**
    *  Delete a Note
    *  Deletes a note
    *  * @param noteId noteId (optional)
    *  * @return void
    */
  override suspend fun deleteNote(noteId: Long) {
    val uri = uriTemplate("/notes/{noteId}")
      .parameter("noteId", noteId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete a Note
    *  Deletes a note
    *  * @param noteId noteId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteNoteAsync(noteId: Long)  = 
        client.async { deleteNote(noteId) }

  /**
    *  Retrieve a Note
    *  Retrieves a single note
    *  * @param noteId noteId (optional)
    *  * @return Note
    */
  override suspend fun getNote(noteId: Long) : Note {
    val uri = uriTemplate("/notes/{noteId}")
      .parameter("noteId", noteId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Note
    *  Retrieves a single note
    *  * @param noteId noteId (optional)
    *  * @return A deferred reference to the final Note  
    */
  override fun getNoteAsync(noteId: Long)  = 
        client.async { getNote(noteId) }

  /**
    *  List Notes
    *  Retrieves a list of all notes
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Filter based on the user id assigned to the note. 
    *  * @param contactId Filter based on the contact id assigned to the note. 
    *  * @return NoteList
    */
  override suspend fun listNotes(limit: Int?, offset: Int?, userId: Long?, contactId: Long?) : NoteList {
    val uri = uriTemplate("/notes")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("user_id",  userId)
      queryParam("contact_id",  contactId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Notes
    *  Retrieves a list of all notes
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param userId Filter based on the user id assigned to the note. 
    *  * @param contactId Filter based on the contact id assigned to the note. 
    *  * @return A deferred reference to the final NoteList  
    */
  override fun listNotesAsync(limit: Int?, offset: Int?, userId: Long?, contactId: Long?)  = 
        client.async { listNotes(limit, offset, userId, contactId) }

  /**
    *  Replace a Note
    *  Replaces all values of a given note
    *  * @param note note (optional)
    *  * @param requestNote requestNote (optional)
    *  * @return Note
    */
  override suspend fun updateNote(note: Long, requestNote: RequestNote) : Note {
    val uri = uriTemplate("/notes/{noteId}")
      .parameter("note", note)
      .build()
    val call = put(uri) {
      body = requestNote ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Replace a Note
    *  Replaces all values of a given note
    *  * @param note note (optional)
    *  * @param requestNote requestNote (optional)
    *  * @return A deferred reference to the final Note  
    */
  override fun updateNoteAsync(note: Long, requestNote: RequestNote)  = 
        client.async { updateNote(note, requestNote) }

  /**
    *  Update a Note
    *  Updates a note with only the values provided in the request
    *  * @param noteId noteId (optional)
    *  * @param note note 
    *  * @return Note
    */
  override suspend fun updatePropertiesOnNote(noteId: Long, note: UpdateNote?) : Note {
    val uri = uriTemplate("/notes/{noteId}")
      .parameter("noteId", noteId)
      .build()
    val call = patch(uri) {
      body = note ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Update a Note
    *  Updates a note with only the values provided in the request
    *  * @param noteId noteId (optional)
    *  * @param note note 
    *  * @return A deferred reference to the final Note  
    */
  override fun updatePropertiesOnNoteAsync(noteId: Long, note: UpdateNote?)  = 
        client.async { updatePropertiesOnNote(noteId, note) }

}
   

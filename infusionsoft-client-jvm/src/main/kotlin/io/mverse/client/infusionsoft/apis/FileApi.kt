@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.FileInformation
import io.mverse.client.infusionsoft.models.FileList
import io.mverse.client.infusionsoft.models.FileUpload


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


interface FileApi {

  /**
    *  Upload File
    *  Upload a base64 encoded file. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  suspend fun createFile(fileUpload: FileUpload? = null) : FileInformation
  
  /**
    *  Asynchronous implementation of Upload File
    *  Upload a base64 encoded file. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileUpload fileUpload 
    *  * @return A deferred reference to the final FileInformation  
    */
  fun createFileAsync(fileUpload: FileUpload? = null) : Deferred<FileInformation>

  /**
    *  Delete File
    *  Deletes the specified file
    *  * @param fileId fileId (optional)
    *  * @return void
    */
  suspend fun deleteFile(fileId: Long)
  
  /**
    *  Asynchronous implementation of Delete File
    *  Deletes the specified file
    *  * @param fileId fileId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteFileAsync(fileId: Long) : Deferred<Unit>

  /**
    *  Retrieve File
    *  Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.
    *  * @param fileId fileId (optional)
    *  * @param optionalProperties Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.) 
    *  * @return FileInformation
    */
  suspend fun getFile(fileId: Long, optionalProperties: List<String>? = null) : FileInformation
  
  /**
    *  Asynchronous implementation of Retrieve File
    *  Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.
    *  * @param fileId fileId (optional)
    *  * @param optionalProperties Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.) 
    *  * @return A deferred reference to the final FileInformation  
    */
  fun getFileAsync(fileId: Long, optionalProperties: List<String>? = null) : Deferred<FileInformation>

  /**
    *  List Files
    *  Retrieves a list of all files
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param viewable Include public or private files in response (PUBLIC or PRIVATE), defaults to BOTH. 
    *  * @param permission Filter based on the permission of files (USER or COMPANY), defaults to BOTH. 
    *  * @param type Filter based on the type of file. 
    *  * @param name Filter files based on name, with '*' preceding or following to indicate LIKE queries. 
    *  * @param contactId Filter based on Contact Id, if user has permission to see Contact files. 
    *  * @return FileList
    */
  suspend fun listFiles(limit: Int? = null, offset: Int? = null, viewable: String? = null, permission: String? = null, type: String? = null, name: String? = null, contactId: Long? = null) : FileList
  
  /**
    *  Asynchronous implementation of List Files
    *  Retrieves a list of all files
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param viewable Include public or private files in response (PUBLIC or PRIVATE), defaults to BOTH. 
    *  * @param permission Filter based on the permission of files (USER or COMPANY), defaults to BOTH. 
    *  * @param type Filter based on the type of file. 
    *  * @param name Filter files based on name, with '*' preceding or following to indicate LIKE queries. 
    *  * @param contactId Filter based on Contact Id, if user has permission to see Contact files. 
    *  * @return A deferred reference to the final FileList  
    */
  fun listFilesAsync(limit: Int? = null, offset: Int? = null, viewable: String? = null, permission: String? = null, type: String? = null, name: String? = null, contactId: Long? = null) : Deferred<FileList>

  /**
    *  Replace File
    *  Upload a base64 encoded file to replace an existing one. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileId fileId (optional)
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  suspend fun updateFile(fileId: Long, fileUpload: FileUpload? = null) : FileInformation
  
  /**
    *  Asynchronous implementation of Replace File
    *  Upload a base64 encoded file to replace an existing one. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileId fileId (optional)
    *  * @param fileUpload fileUpload 
    *  * @return A deferred reference to the final FileInformation  
    */
  fun updateFileAsync(fileId: Long, fileUpload: FileUpload? = null) : Deferred<FileInformation>

}

class FileApiImpl(bearerToken:String, basePath: String, gson: Gson) : FileApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Upload File
    *  Upload a base64 encoded file. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  override suspend fun createFile(fileUpload: FileUpload?) : FileInformation {
    val uri = uriTemplate("/files")
      .build()
    val call = post(uri) {
      body = fileUpload ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Upload File
    *  Upload a base64 encoded file. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileUpload fileUpload 
    *  * @return A deferred reference to the final FileInformation  
    */
  override fun createFileAsync(fileUpload: FileUpload?)  = 
        client.async { createFile(fileUpload) }

  /**
    *  Delete File
    *  Deletes the specified file
    *  * @param fileId fileId (optional)
    *  * @return void
    */
  override suspend fun deleteFile(fileId: Long) {
    val uri = uriTemplate("/files/{fileId}")
      .parameter("fileId", fileId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete File
    *  Deletes the specified file
    *  * @param fileId fileId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteFileAsync(fileId: Long)  = 
        client.async { deleteFile(fileId) }

  /**
    *  Retrieve File
    *  Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.
    *  * @param fileId fileId (optional)
    *  * @param optionalProperties Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.) 
    *  * @return FileInformation
    */
  override suspend fun getFile(fileId: Long, optionalProperties: List<String>?) : FileInformation {
    val uri = uriTemplate("/files/{fileId}")
      .parameter("fileId", fileId)
      .build()
    val call = get(uri) {
      queryParam("optional_properties",  optionalProperties)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve File
    *  Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.
    *  * @param fileId fileId (optional)
    *  * @param optionalProperties Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.) 
    *  * @return A deferred reference to the final FileInformation  
    */
  override fun getFileAsync(fileId: Long, optionalProperties: List<String>?)  = 
        client.async { getFile(fileId, optionalProperties) }

  /**
    *  List Files
    *  Retrieves a list of all files
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param viewable Include public or private files in response (PUBLIC or PRIVATE), defaults to BOTH. 
    *  * @param permission Filter based on the permission of files (USER or COMPANY), defaults to BOTH. 
    *  * @param type Filter based on the type of file. 
    *  * @param name Filter files based on name, with '*' preceding or following to indicate LIKE queries. 
    *  * @param contactId Filter based on Contact Id, if user has permission to see Contact files. 
    *  * @return FileList
    */
  override suspend fun listFiles(limit: Int?, offset: Int?, viewable: String?, permission: String?, type: String?, name: String?, contactId: Long?) : FileList {
    val uri = uriTemplate("/files")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("viewable",  viewable)
      queryParam("permission",  permission)
      queryParam("type",  type)
      queryParam("name",  name)
      queryParam("contact_id",  contactId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Files
    *  Retrieves a list of all files
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param viewable Include public or private files in response (PUBLIC or PRIVATE), defaults to BOTH. 
    *  * @param permission Filter based on the permission of files (USER or COMPANY), defaults to BOTH. 
    *  * @param type Filter based on the type of file. 
    *  * @param name Filter files based on name, with '*' preceding or following to indicate LIKE queries. 
    *  * @param contactId Filter based on Contact Id, if user has permission to see Contact files. 
    *  * @return A deferred reference to the final FileList  
    */
  override fun listFilesAsync(limit: Int?, offset: Int?, viewable: String?, permission: String?, type: String?, name: String?, contactId: Long?)  = 
        client.async { listFiles(limit, offset, viewable, permission, type, name, contactId) }

  /**
    *  Replace File
    *  Upload a base64 encoded file to replace an existing one. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileId fileId (optional)
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  override suspend fun updateFile(fileId: Long, fileUpload: FileUpload?) : FileInformation {
    val uri = uriTemplate("/files/{fileId}")
      .parameter("fileId", fileId)
      .build()
    val call = put(uri) {
      body = fileUpload ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Replace File
    *  Upload a base64 encoded file to replace an existing one. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileId fileId (optional)
    *  * @param fileUpload fileUpload 
    *  * @return A deferred reference to the final FileInformation  
    */
  override fun updateFileAsync(fileId: Long, fileUpload: FileUpload?)  = 
        client.async { updateFile(fileId, fileUpload) }

}
   

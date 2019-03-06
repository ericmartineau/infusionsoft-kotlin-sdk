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
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface FileApi {

  /**
    *  Upload File
    *  Upload a base64 encoded file. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  suspend fun createFile(fileUpload: FileUpload) : FileInformation
    
  /**
    *  Delete File
    *  Deletes the specified file
    *  * @param fileId fileId (optional)
    *  * @return void
    */
  suspend fun deleteFile(fileId: Long? = null) : Unit
    
  /**
    *  Retrieve File
    *  Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.
    *  * @param fileId fileId (optional)
    *  * @param optionalProperties Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.) 
    *  * @return FileInformation
    */
  suspend fun getFile(fileId: Long? = null, optionalProperties: List<String>) : FileInformation
    
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
  suspend fun listFiles(limit: Int, offset: Int, viewable: String, permission: String, type: String, name: String, contactId: Long) : FileList
    
  /**
    *  Replace File
    *  Upload a base64 encoded file to replace an existing one. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileId fileId (optional)
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  suspend fun updateFile(fileId: Long? = null, fileUpload: FileUpload) : FileInformation
    
}

class FileApiImpl(bearerToken:String, basePath: String, gson: Gson) : FileApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Upload File
    *  Upload a base64 encoded file. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  override suspend fun createFile(fileUpload: FileUpload) : FileInformation {
    val call = request( "/files", mapOf()) {
      method = HttpMethod.parse("POST")
      body = fileUpload ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete File
    *  Deletes the specified file
    *  * @param fileId fileId (optional)
    *  * @return void
    */
  override suspend fun deleteFile(fileId: Long?) : Unit {
    val call = request( "/files/{fileId}", mapOf("fileId" to "$fileId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve File
    *  Retrieves metadata about a specific file. Optionally returns the base64 encoded file data.
    *  * @param fileId fileId (optional)
    *  * @param optionalProperties Comma-delimited list of File properties to include in the response. (Some fields such as `file_data` aren't included, by default.) 
    *  * @return FileInformation
    */
  override suspend fun getFile(fileId: Long?, optionalProperties: List<String>) : FileInformation {
    val call = request( "/files/{fileId}", mapOf("fileId" to "$fileId")) {
      method = HttpMethod.parse("GET")
      if (optionalProperties != null) url.parameters.appendAll("optional_properties",  optionalProperties.map {"$it"})
      
    
    }
    return call.receive()
  }

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
  override suspend fun listFiles(limit: Int, offset: Int, viewable: String, permission: String, type: String, name: String, contactId: Long) : FileList {
    val call = request( "/files", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (viewable != null) url.parameters.append("viewable", "$viewable")
      
    
      if (permission != null) url.parameters.append("permission", "$permission")
      
    
      if (type != null) url.parameters.append("type", "$type")
      
    
      if (name != null) url.parameters.append("name", "$name")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
    }
    return call.receive()
  }

  /**
    *  Replace File
    *  Upload a base64 encoded file to replace an existing one. `contact_id` is required only when `file_association` is `CONTACT`.
    *  * @param fileId fileId (optional)
    *  * @param fileUpload fileUpload 
    *  * @return FileInformation
    */
  override suspend fun updateFile(fileId: Long?, fileUpload: FileUpload) : FileInformation {
    val call = request( "/files/{fileId}", mapOf("fileId" to "$fileId")) {
      method = HttpMethod.parse("PUT")
      body = fileUpload ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

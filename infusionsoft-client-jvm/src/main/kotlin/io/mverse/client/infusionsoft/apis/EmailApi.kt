@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.EmailSendRequest
import io.mverse.client.infusionsoft.models.EmailSentCreate
import io.mverse.client.infusionsoft.models.EmailSentCreateList
import io.mverse.client.infusionsoft.models.EmailSentQueryResultList
import io.mverse.client.infusionsoft.models.EmailSentQueryResultWithContent
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.SetOfIds


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface EmailApi {

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  suspend fun createEmail(emailWithContent: EmailSentCreate) : EmailSentCreate
    
  /**
    *  Create a set of Email Records
    *  Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreateList
    */
  suspend fun createEmails(emailWithContent: EmailSentCreateList) : EmailSentCreateList
    
  /**
    *  Delete an Email Record
    *  Delete a specific email record
    *  * @param id id (optional)
    *  * @return void
    */
  suspend fun deleteEmail(id: Long? = null) : Unit
    
  /**
    *  Un-sync a batch of Email Records
    *  Un-syncs a batch of email records
    *  * @param emailIds emailIds (optional)
    *  * @return Map<kotlin.String, String>
    */
  suspend fun deleteEmails(emailIds: SetOfIds? = null) : Map<kotlin.String, String>
    
  /**
    *  Retrieve an Email
    *  Retrieves a single email that has been sent
    *  * @param id id (optional)
    *  * @return EmailSentQueryResultWithContent
    */
  suspend fun getEmail(id: Long? = null) : EmailSentQueryResultWithContent
    
  /**
    *  List Emails
    *  Retrieve a list of emails that have been sent
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Optional Contact Id to find Emails for 
    *  * @param email Optional email address to query on 
    *  * @param sinceSentDate Optional date to query on, emails sent since the provided date, must be present if untilDate is provided 
    *  * @param untilSentDate Optional date to query on, email sent until the provided date 
    *  * @return EmailSentQueryResultList
    */
  suspend fun listEmails(limit: Int, offset: Int, contactId: Long, email: String, sinceSentDate: String, untilSentDate: String) : EmailSentQueryResultList
    
  /**
    *  Send an Email
    *  Send an Email to a list of Contacts
    *  * @param emailSendRequest emailSendRequest 
    *  * @return void
    */
  suspend fun sendEmail(emailSendRequest: EmailSendRequest) : Unit
    
  /**
    *  Update an Email Record
    *  Update a record of an email sent to a contact
    *  * @param id id (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  suspend fun updateEmail(id: Long? = null, emailWithContent: EmailSentCreate) : EmailSentCreate
    
}

class EmailApiImpl(bearerToken:String, basePath: String, gson: Gson) : EmailApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  override suspend fun createEmail(emailWithContent: EmailSentCreate) : EmailSentCreate {
    val call = request( "/emails", mapOf()) {
      method = HttpMethod.parse("POST")
      body = emailWithContent ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create a set of Email Records
    *  Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreateList
    */
  override suspend fun createEmails(emailWithContent: EmailSentCreateList) : EmailSentCreateList {
    val call = request( "/emails/sync", mapOf()) {
      method = HttpMethod.parse("POST")
      body = emailWithContent ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete an Email Record
    *  Delete a specific email record
    *  * @param id id (optional)
    *  * @return void
    */
  override suspend fun deleteEmail(id: Long?) : Unit {
    val call = request( "/emails/{id}", mapOf("id" to "$id")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Un-sync a batch of Email Records
    *  Un-syncs a batch of email records
    *  * @param emailIds emailIds (optional)
    *  * @return Map<kotlin.String, String>
    */
  override suspend fun deleteEmails(emailIds: SetOfIds?) : Map<kotlin.String, String> {
    val call = request( "/emails/unsync", mapOf()) {
      method = HttpMethod.parse("POST")
      body = emailIds ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Retrieve an Email
    *  Retrieves a single email that has been sent
    *  * @param id id (optional)
    *  * @return EmailSentQueryResultWithContent
    */
  override suspend fun getEmail(id: Long?) : EmailSentQueryResultWithContent {
    val call = request( "/emails/{id}", mapOf("id" to "$id")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Emails
    *  Retrieve a list of emails that have been sent
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Optional Contact Id to find Emails for 
    *  * @param email Optional email address to query on 
    *  * @param sinceSentDate Optional date to query on, emails sent since the provided date, must be present if untilDate is provided 
    *  * @param untilSentDate Optional date to query on, email sent until the provided date 
    *  * @return EmailSentQueryResultList
    */
  override suspend fun listEmails(limit: Int, offset: Int, contactId: Long, email: String, sinceSentDate: String, untilSentDate: String) : EmailSentQueryResultList {
    val call = request( "/emails", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
      if (email != null) url.parameters.append("email", "$email")
      
    
      if (sinceSentDate != null) url.parameters.append("since_sent_date", "$sinceSentDate")
      
    
      if (untilSentDate != null) url.parameters.append("until_sent_date", "$untilSentDate")
      
    
    }
    return call.receive()
  }

  /**
    *  Send an Email
    *  Send an Email to a list of Contacts
    *  * @param emailSendRequest emailSendRequest 
    *  * @return void
    */
  override suspend fun sendEmail(emailSendRequest: EmailSendRequest) : Unit {
    val call = request( "/emails/queue", mapOf()) {
      method = HttpMethod.parse("POST")
      body = emailSendRequest ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Update an Email Record
    *  Update a record of an email sent to a contact
    *  * @param id id (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  override suspend fun updateEmail(id: Long?, emailWithContent: EmailSentCreate) : EmailSentCreate {
    val call = request( "/emails/{id}", mapOf("id" to "$id")) {
      method = HttpMethod.parse("PUT")
      body = emailWithContent ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

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
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface EmailApi {

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  suspend fun createEmail(emailWithContent: EmailSentCreate? = null) : EmailSentCreate
  
  /**
    *  Asynchronous implementation of Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return A deferred reference to the final EmailSentCreate  
    */
  fun createEmailAsync(emailWithContent: EmailSentCreate? = null) : Deferred<EmailSentCreate>

  /**
    *  Create a set of Email Records
    *  Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreateList
    */
  suspend fun createEmails(emailWithContent: EmailSentCreateList? = null) : EmailSentCreateList
  
  /**
    *  Asynchronous implementation of Create a set of Email Records
    *  Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return A deferred reference to the final EmailSentCreateList  
    */
  fun createEmailsAsync(emailWithContent: EmailSentCreateList? = null) : Deferred<EmailSentCreateList>

  /**
    *  Delete an Email Record
    *  Delete a specific email record
    *  * @param id id (optional)
    *  * @return void
    */
  suspend fun deleteEmail(id: Long)
  
  /**
    *  Asynchronous implementation of Delete an Email Record
    *  Delete a specific email record
    *  * @param id id (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteEmailAsync(id: Long) : Deferred<Unit>

  /**
    *  Un-sync a batch of Email Records
    *  Un-syncs a batch of email records
    *  * @param emailIds emailIds (optional)
    *  * @return Map<kotlin.String, String>
    */
  suspend fun deleteEmails(emailIds: SetOfIds) : Map<kotlin.String, String>
  
  /**
    *  Asynchronous implementation of Un-sync a batch of Email Records
    *  Un-syncs a batch of email records
    *  * @param emailIds emailIds (optional)
    *  * @return A deferred reference to the final Map<kotlin.String, String>  
    */
  fun deleteEmailsAsync(emailIds: SetOfIds) : Deferred<Map<kotlin.String, String>>

  /**
    *  Retrieve an Email
    *  Retrieves a single email that has been sent
    *  * @param id id (optional)
    *  * @return EmailSentQueryResultWithContent
    */
  suspend fun getEmail(id: Long) : EmailSentQueryResultWithContent
  
  /**
    *  Asynchronous implementation of Retrieve an Email
    *  Retrieves a single email that has been sent
    *  * @param id id (optional)
    *  * @return A deferred reference to the final EmailSentQueryResultWithContent  
    */
  fun getEmailAsync(id: Long) : Deferred<EmailSentQueryResultWithContent>

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
  suspend fun listEmails(limit: Int? = null, offset: Int? = null, contactId: Long? = null, email: String? = null, sinceSentDate: String? = null, untilSentDate: String? = null) : EmailSentQueryResultList
  
  /**
    *  Asynchronous implementation of List Emails
    *  Retrieve a list of emails that have been sent
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Optional Contact Id to find Emails for 
    *  * @param email Optional email address to query on 
    *  * @param sinceSentDate Optional date to query on, emails sent since the provided date, must be present if untilDate is provided 
    *  * @param untilSentDate Optional date to query on, email sent until the provided date 
    *  * @return A deferred reference to the final EmailSentQueryResultList  
    */
  fun listEmailsAsync(limit: Int? = null, offset: Int? = null, contactId: Long? = null, email: String? = null, sinceSentDate: String? = null, untilSentDate: String? = null) : Deferred<EmailSentQueryResultList>

  /**
    *  Send an Email
    *  Send an Email to a list of Contacts
    *  * @param emailSendRequest emailSendRequest 
    *  * @return void
    */
  suspend fun sendEmail(emailSendRequest: EmailSendRequest? = null)
  
  /**
    *  Asynchronous implementation of Send an Email
    *  Send an Email to a list of Contacts
    *  * @param emailSendRequest emailSendRequest 
    *  * @return A deferred reference to the final void  
    */
  fun sendEmailAsync(emailSendRequest: EmailSendRequest? = null) : Deferred<Unit>

  /**
    *  Update an Email Record
    *  Update a record of an email sent to a contact
    *  * @param id id (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  suspend fun updateEmail(id: Long, emailWithContent: EmailSentCreate? = null) : EmailSentCreate
  
  /**
    *  Asynchronous implementation of Update an Email Record
    *  Update a record of an email sent to a contact
    *  * @param id id (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return A deferred reference to the final EmailSentCreate  
    */
  fun updateEmailAsync(id: Long, emailWithContent: EmailSentCreate? = null) : Deferred<EmailSentCreate>

}

class EmailApiImpl(bearerToken:String, basePath: String, gson: Gson) : EmailApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  override suspend fun createEmail(emailWithContent: EmailSentCreate?) : EmailSentCreate {
    val uri = uriTemplate("/emails")
      .build()
    val call = post(uri) {
      body = emailWithContent ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create an Email Record
    *  Create a record of an email sent to a contact
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return A deferred reference to the final EmailSentCreate  
    */
  override fun createEmailAsync(emailWithContent: EmailSentCreate?)  = 
        client.async { createEmail(emailWithContent) }

  /**
    *  Create a set of Email Records
    *  Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreateList
    */
  override suspend fun createEmails(emailWithContent: EmailSentCreateList?) : EmailSentCreateList {
    val uri = uriTemplate("/emails/sync")
      .build()
    val call = post(uri) {
      body = emailWithContent ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a set of Email Records
    *  Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return A deferred reference to the final EmailSentCreateList  
    */
  override fun createEmailsAsync(emailWithContent: EmailSentCreateList?)  = 
        client.async { createEmails(emailWithContent) }

  /**
    *  Delete an Email Record
    *  Delete a specific email record
    *  * @param id id (optional)
    *  * @return void
    */
  override suspend fun deleteEmail(id: Long) {
    val uri = uriTemplate("/emails/{id}")
      .parameter("id", id)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete an Email Record
    *  Delete a specific email record
    *  * @param id id (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteEmailAsync(id: Long)  = 
        client.async { deleteEmail(id) }

  /**
    *  Un-sync a batch of Email Records
    *  Un-syncs a batch of email records
    *  * @param emailIds emailIds (optional)
    *  * @return Map<kotlin.String, String>
    */
  override suspend fun deleteEmails(emailIds: SetOfIds) : Map<kotlin.String, String> {
    val uri = uriTemplate("/emails/unsync")
      .build()
    val call = post(uri) {
      body = emailIds ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Un-sync a batch of Email Records
    *  Un-syncs a batch of email records
    *  * @param emailIds emailIds (optional)
    *  * @return A deferred reference to the final Map<kotlin.String, String>  
    */
  override fun deleteEmailsAsync(emailIds: SetOfIds)  = 
        client.async { deleteEmails(emailIds) }

  /**
    *  Retrieve an Email
    *  Retrieves a single email that has been sent
    *  * @param id id (optional)
    *  * @return EmailSentQueryResultWithContent
    */
  override suspend fun getEmail(id: Long) : EmailSentQueryResultWithContent {
    val uri = uriTemplate("/emails/{id}")
      .parameter("id", id)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve an Email
    *  Retrieves a single email that has been sent
    *  * @param id id (optional)
    *  * @return A deferred reference to the final EmailSentQueryResultWithContent  
    */
  override fun getEmailAsync(id: Long)  = 
        client.async { getEmail(id) }

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
  override suspend fun listEmails(limit: Int?, offset: Int?, contactId: Long?, email: String?, sinceSentDate: String?, untilSentDate: String?) : EmailSentQueryResultList {
    val uri = uriTemplate("/emails")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("contact_id",  contactId)
      queryParam("email",  email)
      queryParam("since_sent_date",  sinceSentDate)
      queryParam("until_sent_date",  untilSentDate)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Emails
    *  Retrieve a list of emails that have been sent
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Optional Contact Id to find Emails for 
    *  * @param email Optional email address to query on 
    *  * @param sinceSentDate Optional date to query on, emails sent since the provided date, must be present if untilDate is provided 
    *  * @param untilSentDate Optional date to query on, email sent until the provided date 
    *  * @return A deferred reference to the final EmailSentQueryResultList  
    */
  override fun listEmailsAsync(limit: Int?, offset: Int?, contactId: Long?, email: String?, sinceSentDate: String?, untilSentDate: String?)  = 
        client.async { listEmails(limit, offset, contactId, email, sinceSentDate, untilSentDate) }

  /**
    *  Send an Email
    *  Send an Email to a list of Contacts
    *  * @param emailSendRequest emailSendRequest 
    *  * @return void
    */
  override suspend fun sendEmail(emailSendRequest: EmailSendRequest?) {
    val uri = uriTemplate("/emails/queue")
      .build()
    val call = post(uri) {
      body = emailSendRequest ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Send an Email
    *  Send an Email to a list of Contacts
    *  * @param emailSendRequest emailSendRequest 
    *  * @return A deferred reference to the final void  
    */
  override fun sendEmailAsync(emailSendRequest: EmailSendRequest?)  = 
        client.async { sendEmail(emailSendRequest) }

  /**
    *  Update an Email Record
    *  Update a record of an email sent to a contact
    *  * @param id id (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return EmailSentCreate
    */
  override suspend fun updateEmail(id: Long, emailWithContent: EmailSentCreate?) : EmailSentCreate {
    val uri = uriTemplate("/emails/{id}")
      .parameter("id", id)
      .build()
    val call = put(uri) {
      body = emailWithContent ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Update an Email Record
    *  Update a record of an email sent to a contact
    *  * @param id id (optional)
    *  * @param emailWithContent Email records to persist, with content. 
    *  * @return A deferred reference to the final EmailSentCreate  
    */
  override fun updateEmailAsync(id: Long, emailWithContent: EmailSentCreate?)  = 
        client.async { updateEmail(id, emailWithContent) }

}
   

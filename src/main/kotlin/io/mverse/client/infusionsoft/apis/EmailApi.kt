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

import io.mverse.client.infusionsoft.models.EmailSendRequest
import io.mverse.client.infusionsoft.models.EmailSentCreate
import io.mverse.client.infusionsoft.models.EmailSentCreateList
import io.mverse.client.infusionsoft.models.EmailSentQueryResultList
import io.mverse.client.infusionsoft.models.EmailSentQueryResultWithContent
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.SetOfIds

import io.mverse.client.infusionsoft.infrastructure.*

class EmailApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Create an Email Record
    * Create a record of an email sent to a contact
    * @param emailWithContent Email records to persist, with content. (optional)
    * @return EmailSentCreate
    */
    @Suppress("UNCHECKED_CAST")
    fun createEmail(emailWithContent: EmailSentCreate? = null) : EmailSentCreate {
        val localVariableBody: Any? = emailWithContent
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/emails",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<EmailSentCreate>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as EmailSentCreate
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Create a set of Email Records
    * Create a set of records of emails sent to contacts, maximum 1000 per transaction.
    * @param emailWithContent Email records to persist, with content. (optional)
    * @return EmailSentCreateList
    */
    @Suppress("UNCHECKED_CAST")
    fun createEmails(emailWithContent: EmailSentCreateList? = null) : EmailSentCreateList {
        val localVariableBody: Any? = emailWithContent
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/emails/sync",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<EmailSentCreateList>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as EmailSentCreateList
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Delete an Email Record
    * Delete a specific email record
    * @param id id 
    * @return void
    */
    fun deleteEmail(id: Long) : Unit {
        val localVariableBody: Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.DELETE,
            "/emails/{id}".replace("{"+"id"+"}", "$id"),
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
    * Un-sync a batch of Email Records
    * Un-syncs a batch of email records
    * @param emailIds emailIds 
    * @return Map<kotlin.String, String>
    */
    @Suppress("UNCHECKED_CAST")
    fun deleteEmails(emailIds: SetOfIds) : Map<kotlin.String, String> {
        val localVariableBody: Any? = emailIds
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/emails/unsync",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<Map<kotlin.String, String>>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Map<kotlin.String, String>
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Retrieve an Email
    * Retrieves a single email that has been sent
    * @param id id 
    * @return EmailSentQueryResultWithContent
    */
    @Suppress("UNCHECKED_CAST")
    fun getEmail(id: Long) : EmailSentQueryResultWithContent {
        val localVariableBody: Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/emails/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<EmailSentQueryResultWithContent>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as EmailSentQueryResultWithContent
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * List Emails
    * Retrieve a list of emails that have been sent
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param contactId Optional Contact Id to find Emails for (optional)
    * @param email Optional email address to query on (optional)
    * @param sinceSentDate Optional date to query on, emails sent since the provided date, must be present if untilDate is provided (optional)
    * @param untilSentDate Optional date to query on, email sent until the provided date (optional)
    * @return EmailSentQueryResultList
    */
    @Suppress("UNCHECKED_CAST")
    fun listEmails(limit: Int? = null, offset: Int? = null, contactId: Long? = null, email: String? = null, sinceSentDate: String? = null, untilSentDate: String? = null) : EmailSentQueryResultList {
        val localVariableBody: Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        if (limit != null) localVariableQuery["limit"] to listOf("$limit")
if (offset != null) localVariableQuery["offset"] to listOf("$offset")
if (contactId != null) localVariableQuery["contact_id"] to listOf("$contactId")
if (email != null) localVariableQuery["email"] to listOf("$email")
if (sinceSentDate != null) localVariableQuery["since_sent_date"] to listOf("$sinceSentDate")
if (untilSentDate != null) localVariableQuery["until_sent_date"] to listOf("$untilSentDate")

        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/emails",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<EmailSentQueryResultList>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as EmailSentQueryResultList
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

    /**
    * Send an Email
    * Send an Email to a list of Contacts
    * @param emailSendRequest emailSendRequest (optional)
    * @return void
    */
    fun sendEmail(emailSendRequest: EmailSendRequest? = null) : Unit {
        val localVariableBody: Any? = emailSendRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/emails/queue",
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
    * Update an Email Record
    * Update a record of an email sent to a contact
    * @param id id 
    * @param emailWithContent Email records to persist, with content. (optional)
    * @return EmailSentCreate
    */
    @Suppress("UNCHECKED_CAST")
    fun updateEmail(id: Long, emailWithContent: EmailSentCreate? = null) : EmailSentCreate {
        val localVariableBody: Any? = emailWithContent
        val localVariableQuery: MultiValueMap = mutableMapOf()
        
        val contentHeaders: Map<String, String> = mapOf()
        val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)

        val localVariableConfig = RequestConfig(
            RequestMethod.PUT,
            "/emails/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<EmailSentCreate>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as EmailSentCreate
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
            else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
        }
    }

}

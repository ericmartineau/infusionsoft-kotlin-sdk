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

import io.mverse.client.infusionsoft.models.CreateTag
import io.mverse.client.infusionsoft.models.CreateTagCategory
import io.mverse.client.infusionsoft.models.EntryLongCommastring_
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.SetOfIds
import io.mverse.client.infusionsoft.models.Tag
import io.mverse.client.infusionsoft.models.TagCategory
import io.mverse.client.infusionsoft.models.TaggedCompanyList
import io.mverse.client.infusionsoft.models.TaggedContactList
import io.mverse.client.infusionsoft.models.Tags

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*




class TagsApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Apply Tag to Contacts
    * Apply a tag to a list of contacts
    * @param tagId tagId 
    * @param ids ids 
    * @return List<EntryLongCommastring_>
    */
    @Suppress("UNCHECKED_CAST")
    fun applyTagToContactIds(tagId: Long, ids: SetOfIds) : List<EntryLongCommastring_> {
       val requestBody = ids
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/tags/{tagId}/contacts".replace("{"+"tagId"+"}", "$tagId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           EntryLongCommastring_.serializer().list
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as List<EntryLongCommastring_>
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Create Tag
    * Create a new tag
    * @param tag tag 
    * @return Tag
    */
    @Suppress("UNCHECKED_CAST")
    fun createTag(tag: CreateTag) : Tag {
       val requestBody = tag
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/tags",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           Tag.serializer()
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Tag
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Create Tag Category
    * Create a new tag category
    * @param tagCategory tagCategory 
    * @return TagCategory
    */
    @Suppress("UNCHECKED_CAST")
    fun createTagCategory(tagCategory: CreateTagCategory) : TagCategory {
       val requestBody = tagCategory
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/tags/categories",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           TagCategory.serializer()
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as TagCategory
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Retrieve a Tag
    * Retrieves a single tag
    * @param id id 
    * @return Tag
    */
    @Suppress("UNCHECKED_CAST")
    fun getTag(id: Long) : Tag {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tags/{id}".replace("{"+"id"+"}", "$id"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           Tag.serializer()
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Tag
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Tagged Companies
    * Retrieves a list of companies that have the given tag applied
    * @param tagId tagId 
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @return TaggedCompanyList
    */
    @Suppress("UNCHECKED_CAST")
    fun listCompaniesForTagId(tagId: Long, limit: Int? = null, offset: Int? = null) : TaggedCompanyList {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tags/{tagId}/companies".replace("{"+"tagId"+"}", "$tagId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           TaggedCompanyList.serializer()
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as TaggedCompanyList
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Tagged Contacts
    * Retrieves a list of contacts that have the given tag applied
    * @param tagId tagId 
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @return TaggedContactList
    */
    @Suppress("UNCHECKED_CAST")
    fun listContactsForTagId(tagId: Long, limit: Int? = null, offset: Int? = null) : TaggedContactList {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tags/{tagId}/contacts".replace("{"+"tagId"+"}", "$tagId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           TaggedContactList.serializer()
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as TaggedContactList
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Tags
    * Retrieve a list of tags defined in the application
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param category Category Id of tags to filter by (optional)
    * @param name Filter for tags with a specific name (optional)
    * @return Tags
    */
    @Suppress("UNCHECKED_CAST")
    fun listTags(limit: Int? = null, offset: Int? = null, category: Long? = null, name: String? = null) : Tags {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")
      if (category != null) localVariableQuery["category"] = listOf("$category")
      if (name != null) localVariableQuery["name"] = listOf("$name")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tags",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           Tags.serializer()
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Tags
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Remove Tag from Contact
    * Remove a tag from a Contact
    * @param tagId tagId 
    * @param contactId contactId 
    * @return void
    */
    fun removeTagFromContactId(tagId: Long, contactId: Long) : Unit {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.DELETE,
           "/tags/{tagId}/contacts/{contactId}".replace("{"+"tagId"+"}", "$tagId").replace("{"+"contactId"+"}", "$contactId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           UnitSerializer
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
    * Remove Tag from Contacts
    * Remove a tag from a list of contacts
    * @param tagId tagId 
    * @param ids ids 
    * @return void
    */
    fun removeTagFromContactIds(tagId: Long, ids: List<Long>) : Unit {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (ids != null) localVariableQuery["ids"] = toMultiValue(ids!!.toList(), "multi")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.DELETE,
           "/tags/{tagId}/contacts".replace("{"+"tagId"+"}", "$tagId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request(
           localVariableConfig,
           requestBody,
           UnitSerializer
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

}

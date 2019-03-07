@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.CreateTag
import io.mverse.client.infusionsoft.models.CreateTagCategory
import io.mverse.client.infusionsoft.models.SetOfIds
import io.mverse.client.infusionsoft.models.Tag
import io.mverse.client.infusionsoft.models.TagCategory
import io.mverse.client.infusionsoft.models.TaggedCompanyList
import io.mverse.client.infusionsoft.models.TaggedContactList
import io.mverse.client.infusionsoft.models.Tags


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface TagsApi {

  /**
    *  Apply Tag to Contacts
    *  Apply a tag to a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return List<EntryLongCommastring_>
    */
  suspend fun applyTagToContactIds(tagId: Long, ids: SetOfIds) : Map<String, String>

  /**
    *  Asynchronous implementation of Apply Tag to Contacts
    *  Apply a tag to a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final List<EntryLongCommastring_>
    */
  fun applyTagToContactIdsAsync(tagId: Long, ids: SetOfIds) : Deferred<Map<String, String>>

  /**
    *  Create Tag
    *  Create a new tag
    *  * @param tag tag (optional)
    *  * @return Tag
    */
  suspend fun createTag(tag: CreateTag) : Tag

  /**
    *  Asynchronous implementation of Create Tag
    *  Create a new tag
    *  * @param tag tag (optional)
    *  * @return A deferred reference to the final Tag
    */
  fun createTagAsync(tag: CreateTag) : Deferred<Tag>

  /**
    *  Create Tag Category
    *  Create a new tag category
    *  * @param tagCategory tagCategory (optional)
    *  * @return TagCategory
    */
  suspend fun createTagCategory(tagCategory: CreateTagCategory) : TagCategory

  /**
    *  Asynchronous implementation of Create Tag Category
    *  Create a new tag category
    *  * @param tagCategory tagCategory (optional)
    *  * @return A deferred reference to the final TagCategory
    */
  fun createTagCategoryAsync(tagCategory: CreateTagCategory) : Deferred<TagCategory>

  /**
    *  Retrieve a Tag
    *  Retrieves a single tag
    *  * @param id id (optional)
    *  * @return Tag
    */
  suspend fun getTag(id: Long) : Tag

  /**
    *  Asynchronous implementation of Retrieve a Tag
    *  Retrieves a single tag
    *  * @param id id (optional)
    *  * @return A deferred reference to the final Tag
    */
  fun getTagAsync(id: Long) : Deferred<Tag>

  /**
    *  List Tagged Companies
    *  Retrieves a list of companies that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return TaggedCompanyList
    */
  suspend fun listCompaniesForTagId(tagId: Long, limit: Int? = null, offset: Int? = null) : TaggedCompanyList

  /**
    *  Asynchronous implementation of List Tagged Companies
    *  Retrieves a list of companies that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return A deferred reference to the final TaggedCompanyList
    */
  fun listCompaniesForTagIdAsync(tagId: Long, limit: Int? = null, offset: Int? = null) : Deferred<TaggedCompanyList>

  /**
    *  List Tagged Contacts
    *  Retrieves a list of contacts that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return TaggedContactList
    */
  suspend fun listContactsForTagId(tagId: Long, limit: Int? = null, offset: Int? = null) : TaggedContactList

  /**
    *  Asynchronous implementation of List Tagged Contacts
    *  Retrieves a list of contacts that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return A deferred reference to the final TaggedContactList
    */
  fun listContactsForTagIdAsync(tagId: Long, limit: Int? = null, offset: Int? = null) : Deferred<TaggedContactList>

  /**
    *  List Tags
    *  Retrieve a list of tags defined in the application
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param category Category Id of tags to filter by
    *  * @param name Filter for tags with a specific name
    *  * @return Tags
    */
  suspend fun listTags(limit: Int? = null, offset: Int? = null, category: Long? = null, name: String? = null) : Tags

  /**
    *  Asynchronous implementation of List Tags
    *  Retrieve a list of tags defined in the application
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param category Category Id of tags to filter by
    *  * @param name Filter for tags with a specific name
    *  * @return A deferred reference to the final Tags
    */
  fun listTagsAsync(limit: Int? = null, offset: Int? = null, category: Long? = null, name: String? = null) : Deferred<Tags>

  /**
    *  Remove Tag from Contact
    *  Remove a tag from a Contact
    *  * @param tagId tagId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun removeTagFromContactId(tagId: Long, contactId: Long)

  /**
    *  Asynchronous implementation of Remove Tag from Contact
    *  Remove a tag from a Contact
    *  * @param tagId tagId (optional)
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void
    */
  fun removeTagFromContactIdAsync(tagId: Long, contactId: Long) : Deferred<Unit>

  /**
    *  Remove Tag from Contacts
    *  Remove a tag from a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  suspend fun removeTagFromContactIds(tagId: Long, ids: List<Long>)

  /**
    *  Asynchronous implementation of Remove Tag from Contacts
    *  Remove a tag from a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final void
    */
  fun removeTagFromContactIdsAsync(tagId: Long, ids: List<Long>) : Deferred<Unit>

}

class TagsApiImpl(bearerToken:String, basePath: String, gson: Gson) : TagsApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Apply Tag to Contacts
    *  Apply a tag to a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return List<EntryLongCommastring_>
    */
  override suspend fun applyTagToContactIds(tagId: Long, ids: SetOfIds) : Map<String, String> {
    val uri = uriTemplate("/tags/{tagId}/contacts")
      .parameter("tagId", tagId)
      .build()
    val call = post(uri) {
      body = ids ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Apply Tag to Contacts
    *  Apply a tag to a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final List<EntryLongCommastring_>
    */
  override fun applyTagToContactIdsAsync(tagId: Long, ids: SetOfIds)  =
        client.async { applyTagToContactIds(tagId, ids) }

  /**
    *  Create Tag
    *  Create a new tag
    *  * @param tag tag (optional)
    *  * @return Tag
    */
  override suspend fun createTag(tag: CreateTag) : Tag {
    val uri = uriTemplate("/tags")
      .build()
    val call = post(uri) {
      body = tag ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create Tag
    *  Create a new tag
    *  * @param tag tag (optional)
    *  * @return A deferred reference to the final Tag
    */
  override fun createTagAsync(tag: CreateTag)  =
        client.async { createTag(tag) }

  /**
    *  Create Tag Category
    *  Create a new tag category
    *  * @param tagCategory tagCategory (optional)
    *  * @return TagCategory
    */
  override suspend fun createTagCategory(tagCategory: CreateTagCategory) : TagCategory {
    val uri = uriTemplate("/tags/categories")
      .build()
    val call = post(uri) {
      body = tagCategory ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Create Tag Category
    *  Create a new tag category
    *  * @param tagCategory tagCategory (optional)
    *  * @return A deferred reference to the final TagCategory
    */
  override fun createTagCategoryAsync(tagCategory: CreateTagCategory)  =
        client.async { createTagCategory(tagCategory) }

  /**
    *  Retrieve a Tag
    *  Retrieves a single tag
    *  * @param id id (optional)
    *  * @return Tag
    */
  override suspend fun getTag(id: Long) : Tag {
    val uri = uriTemplate("/tags/{id}")
      .parameter("id", id)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Retrieve a Tag
    *  Retrieves a single tag
    *  * @param id id (optional)
    *  * @return A deferred reference to the final Tag
    */
  override fun getTagAsync(id: Long)  =
        client.async { getTag(id) }

  /**
    *  List Tagged Companies
    *  Retrieves a list of companies that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return TaggedCompanyList
    */
  override suspend fun listCompaniesForTagId(tagId: Long, limit: Int?, offset: Int?) : TaggedCompanyList {
    val uri = uriTemplate("/tags/{tagId}/companies")
      .parameter("tagId", tagId)
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Tagged Companies
    *  Retrieves a list of companies that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return A deferred reference to the final TaggedCompanyList
    */
  override fun listCompaniesForTagIdAsync(tagId: Long, limit: Int?, offset: Int?)  =
        client.async { listCompaniesForTagId(tagId, limit, offset) }

  /**
    *  List Tagged Contacts
    *  Retrieves a list of contacts that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return TaggedContactList
    */
  override suspend fun listContactsForTagId(tagId: Long, limit: Int?, offset: Int?) : TaggedContactList {
    val uri = uriTemplate("/tags/{tagId}/contacts")
      .parameter("tagId", tagId)
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Tagged Contacts
    *  Retrieves a list of contacts that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @return A deferred reference to the final TaggedContactList
    */
  override fun listContactsForTagIdAsync(tagId: Long, limit: Int?, offset: Int?)  =
        client.async { listContactsForTagId(tagId, limit, offset) }

  /**
    *  List Tags
    *  Retrieve a list of tags defined in the application
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param category Category Id of tags to filter by
    *  * @param name Filter for tags with a specific name
    *  * @return Tags
    */
  override suspend fun listTags(limit: Int?, offset: Int?, category: Long?, name: String?) : Tags {
    val uri = uriTemplate("/tags")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("category",  category)
      queryParam("name",  name)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of List Tags
    *  Retrieve a list of tags defined in the application
    *  * @param limit Sets a total of items to return
    *  * @param offset Sets a beginning range of items to return
    *  * @param category Category Id of tags to filter by
    *  * @param name Filter for tags with a specific name
    *  * @return A deferred reference to the final Tags
    */
  override fun listTagsAsync(limit: Int?, offset: Int?, category: Long?, name: String?)  =
        client.async { listTags(limit, offset, category, name) }

  /**
    *  Remove Tag from Contact
    *  Remove a tag from a Contact
    *  * @param tagId tagId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun removeTagFromContactId(tagId: Long, contactId: Long) {
    val uri = uriTemplate("/tags/{tagId}/contacts/{contactId}")
      .parameter("tagId", tagId)
      .parameter("contactId", contactId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Remove Tag from Contact
    *  Remove a tag from a Contact
    *  * @param tagId tagId (optional)
    *  * @param contactId contactId (optional)
    *  * @return A deferred reference to the final void
    */
  override fun removeTagFromContactIdAsync(tagId: Long, contactId: Long)  =
        client.async { removeTagFromContactId(tagId, contactId) }

  /**
    *  Remove Tag from Contacts
    *  Remove a tag from a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  override suspend fun removeTagFromContactIds(tagId: Long, ids: List<Long>) {
    val uri = uriTemplate("/tags/{tagId}/contacts")
      .parameter("tagId", tagId)
      .build()
    val call = delete(uri) {
      queryParam("ids",  ids)
    }
    return call.receive()
  }

  /**
    *  Asynchronous implementation of Remove Tag from Contacts
    *  Remove a tag from a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return A deferred reference to the final void
    */
  override fun removeTagFromContactIdsAsync(tagId: Long, ids: List<Long>)  =
        client.async { removeTagFromContactIds(tagId, ids) }

}


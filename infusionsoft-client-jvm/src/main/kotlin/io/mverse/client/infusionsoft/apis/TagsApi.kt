@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
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
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface TagsApi {

  /**
    *  Apply Tag to Contacts
    *  Apply a tag to a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return List<EntryLongCommastring_>
    */
  suspend fun applyTagToContactIds(tagId: Long? = null, ids: SetOfIds? = null) : List<EntryLongCommastring_>
    
  /**
    *  Create Tag
    *  Create a new tag
    *  * @param tag tag (optional)
    *  * @return Tag
    */
  suspend fun createTag(tag: CreateTag? = null) : Tag
    
  /**
    *  Create Tag Category
    *  Create a new tag category
    *  * @param tagCategory tagCategory (optional)
    *  * @return TagCategory
    */
  suspend fun createTagCategory(tagCategory: CreateTagCategory? = null) : TagCategory
    
  /**
    *  Retrieve a Tag
    *  Retrieves a single tag
    *  * @param id id (optional)
    *  * @return Tag
    */
  suspend fun getTag(id: Long? = null) : Tag
    
  /**
    *  List Tagged Companies
    *  Retrieves a list of companies that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return TaggedCompanyList
    */
  suspend fun listCompaniesForTagId(tagId: Long? = null, limit: Int, offset: Int) : TaggedCompanyList
    
  /**
    *  List Tagged Contacts
    *  Retrieves a list of contacts that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return TaggedContactList
    */
  suspend fun listContactsForTagId(tagId: Long? = null, limit: Int, offset: Int) : TaggedContactList
    
  /**
    *  List Tags
    *  Retrieve a list of tags defined in the application
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param category Category Id of tags to filter by 
    *  * @param name Filter for tags with a specific name 
    *  * @return Tags
    */
  suspend fun listTags(limit: Int, offset: Int, category: Long, name: String) : Tags
    
  /**
    *  Remove Tag from Contact
    *  Remove a tag from a Contact
    *  * @param tagId tagId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  suspend fun removeTagFromContactId(tagId: Long? = null, contactId: Long? = null) : Unit
    
  /**
    *  Remove Tag from Contacts
    *  Remove a tag from a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  suspend fun removeTagFromContactIds(tagId: Long? = null, ids: List<Long>? = null) : Unit
    
}

class TagsApiImpl(bearerToken:String, basePath: String, gson: Gson) : TagsApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Apply Tag to Contacts
    *  Apply a tag to a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return List<EntryLongCommastring_>
    */
  override suspend fun applyTagToContactIds(tagId: Long?, ids: SetOfIds?) : List<EntryLongCommastring_> {
    val call = request( "/tags/{tagId}/contacts", mapOf("tagId" to "$tagId")) {
      method = HttpMethod.parse("POST")
      body = ids ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create Tag
    *  Create a new tag
    *  * @param tag tag (optional)
    *  * @return Tag
    */
  override suspend fun createTag(tag: CreateTag?) : Tag {
    val call = request( "/tags", mapOf()) {
      method = HttpMethod.parse("POST")
      body = tag ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create Tag Category
    *  Create a new tag category
    *  * @param tagCategory tagCategory (optional)
    *  * @return TagCategory
    */
  override suspend fun createTagCategory(tagCategory: CreateTagCategory?) : TagCategory {
    val call = request( "/tags/categories", mapOf()) {
      method = HttpMethod.parse("POST")
      body = tagCategory ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Retrieve a Tag
    *  Retrieves a single tag
    *  * @param id id (optional)
    *  * @return Tag
    */
  override suspend fun getTag(id: Long?) : Tag {
    val call = request( "/tags/{id}", mapOf("id" to "$id")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Tagged Companies
    *  Retrieves a list of companies that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return TaggedCompanyList
    */
  override suspend fun listCompaniesForTagId(tagId: Long?, limit: Int, offset: Int) : TaggedCompanyList {
    val call = request( "/tags/{tagId}/companies", mapOf("tagId" to "$tagId")) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
    }
    return call.receive()
  }

  /**
    *  List Tagged Contacts
    *  Retrieves a list of contacts that have the given tag applied
    *  * @param tagId tagId (optional)
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return TaggedContactList
    */
  override suspend fun listContactsForTagId(tagId: Long?, limit: Int, offset: Int) : TaggedContactList {
    val call = request( "/tags/{tagId}/contacts", mapOf("tagId" to "$tagId")) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
    }
    return call.receive()
  }

  /**
    *  List Tags
    *  Retrieve a list of tags defined in the application
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param category Category Id of tags to filter by 
    *  * @param name Filter for tags with a specific name 
    *  * @return Tags
    */
  override suspend fun listTags(limit: Int, offset: Int, category: Long, name: String) : Tags {
    val call = request( "/tags", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (category != null) url.parameters.append("category", "$category")
      
    
      if (name != null) url.parameters.append("name", "$name")
      
    
    }
    return call.receive()
  }

  /**
    *  Remove Tag from Contact
    *  Remove a tag from a Contact
    *  * @param tagId tagId (optional)
    *  * @param contactId contactId (optional)
    *  * @return void
    */
  override suspend fun removeTagFromContactId(tagId: Long?, contactId: Long?) : Unit {
    val call = request( "/tags/{tagId}/contacts/{contactId}", mapOf("tagId" to "$tagId", "contactId" to "$contactId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Remove Tag from Contacts
    *  Remove a tag from a list of contacts
    *  * @param tagId tagId (optional)
    *  * @param ids ids (optional)
    *  * @return void
    */
  override suspend fun removeTagFromContactIds(tagId: Long?, ids: List<Long>?) : Unit {
    val call = request( "/tags/{tagId}/contacts", mapOf("tagId" to "$tagId")) {
      method = HttpMethod.parse("DELETE")
      if (ids != null) url.parameters.appendAll("ids",  ids.map {"$it"})
      
    
    }
    return call.receive()
  }

}
   

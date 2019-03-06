@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.Task
import io.mverse.client.infusionsoft.models.TaskList


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface TaskApi {

  /**
    *  Create a Task
    *  Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields `title` and `due_date`. All other attributes are optional
    *  * @param task task (optional)
    *  * @return Task
    */
  suspend fun createTask(task: Task? = null) : Task
    
  /**
    *  Delete a Task
    *  Permanently deletes a task
    *  * @param taskId taskId (optional)
    *  * @return void
    */
  suspend fun deleteTask(taskId: String? = null) : Unit
    
  /**
    *  Retrieve a Task
    *  Retrieves a single task
    *  * @param taskId taskId (optional)
    *  * @return Task
    */
  suspend fun getTask(taskId: String? = null) : Task
    
  /**
    *  List Tasks
    *  Retrieves a list of all tasks using the specified search criteria
    *  * @param contactId contact_id 
    *  * @param hasDueDate has_due_date 
    *  * @param userId user_id 
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param completed Sets completed status of items to return 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param order Attribute to order items by 
    *  * @return TaskList
    */
  suspend fun listTasks(contactId: Long, hasDueDate: Boolean, userId: Long, since: String, until: String, completed: Boolean, limit: Int, offset: Int, order: String) : TaskList
    
  /**
    *  Search Tasks
    *  Retrieves Tasks belonging to the authenticated user using the specified search criteria
    *  * @param contactId Returns tasks for the provided contact id 
    *  * @param hasDueDate Returns tasks that have an 'action date' when set to true 
    *  * @param userId Returns tasks for the provided user id 
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param completed Sets completed status of items to return 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param order Attribute to order items by 
    *  * @return TaskList
    */
  suspend fun listTasksForCurrentUser(contactId: Long, hasDueDate: Boolean, userId: Long, since: String, until: String, completed: Boolean, limit: Int, offset: Int, order: String) : TaskList
    
  /**
    *  Retrieve Task Model
    *  Get the custom fields for the Task object
    *  * @return ObjectModel
    */
  suspend fun retrieveTaskModel() : ObjectModel
    
  /**
    *  Update a Task
    *  Updates a task with only the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  suspend fun updatePropertiesOnTask(taskId: String? = null, task: Task? = null) : Task
    
  /**
    *  Replace a Task
    *  Replaces a task with the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  suspend fun updateTask(taskId: String? = null, task: Task? = null) : Task
    
}

class TaskApiImpl(bearerToken:String, basePath: String, gson: Gson) : TaskApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Task
    *  Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields `title` and `due_date`. All other attributes are optional
    *  * @param task task (optional)
    *  * @return Task
    */
  override suspend fun createTask(task: Task?) : Task {
    val call = request( "/tasks", mapOf()) {
      method = HttpMethod.parse("POST")
      body = task ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete a Task
    *  Permanently deletes a task
    *  * @param taskId taskId (optional)
    *  * @return void
    */
  override suspend fun deleteTask(taskId: String?) : Unit {
    val call = request( "/tasks/{taskId}", mapOf("taskId" to "$taskId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve a Task
    *  Retrieves a single task
    *  * @param taskId taskId (optional)
    *  * @return Task
    */
  override suspend fun getTask(taskId: String?) : Task {
    val call = request( "/tasks/{taskId}", mapOf("taskId" to "$taskId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Tasks
    *  Retrieves a list of all tasks using the specified search criteria
    *  * @param contactId contact_id 
    *  * @param hasDueDate has_due_date 
    *  * @param userId user_id 
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param completed Sets completed status of items to return 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param order Attribute to order items by 
    *  * @return TaskList
    */
  override suspend fun listTasks(contactId: Long, hasDueDate: Boolean, userId: Long, since: String, until: String, completed: Boolean, limit: Int, offset: Int, order: String) : TaskList {
    val call = request( "/tasks", mapOf()) {
      method = HttpMethod.parse("GET")
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
      if (hasDueDate != null) url.parameters.append("has_due_date", "$hasDueDate")
      
    
      if (userId != null) url.parameters.append("user_id", "$userId")
      
    
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (completed != null) url.parameters.append("completed", "$completed")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
    }
    return call.receive()
  }

  /**
    *  Search Tasks
    *  Retrieves Tasks belonging to the authenticated user using the specified search criteria
    *  * @param contactId Returns tasks for the provided contact id 
    *  * @param hasDueDate Returns tasks that have an 'action date' when set to true 
    *  * @param userId Returns tasks for the provided user id 
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param completed Sets completed status of items to return 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param order Attribute to order items by 
    *  * @return TaskList
    */
  override suspend fun listTasksForCurrentUser(contactId: Long, hasDueDate: Boolean, userId: Long, since: String, until: String, completed: Boolean, limit: Int, offset: Int, order: String) : TaskList {
    val call = request( "/tasks/search", mapOf()) {
      method = HttpMethod.parse("GET")
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
      if (hasDueDate != null) url.parameters.append("has_due_date", "$hasDueDate")
      
    
      if (userId != null) url.parameters.append("user_id", "$userId")
      
    
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (completed != null) url.parameters.append("completed", "$completed")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Task Model
    *  Get the custom fields for the Task object
    *  * @return ObjectModel
    */
  override suspend fun retrieveTaskModel() : ObjectModel {
    val call = request( "/tasks/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Update a Task
    *  Updates a task with only the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  override suspend fun updatePropertiesOnTask(taskId: String?, task: Task?) : Task {
    val call = request( "/tasks/{taskId}", mapOf("taskId" to "$taskId")) {
      method = HttpMethod.parse("PATCH")
      body = task ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Replace a Task
    *  Replaces a task with the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  override suspend fun updateTask(taskId: String?, task: Task?) : Task {
    val call = request( "/tasks/{taskId}", mapOf("taskId" to "$taskId")) {
      method = HttpMethod.parse("PUT")
      body = task ?: EmptyContent
    
    }
    return call.receive()
  }

}
   

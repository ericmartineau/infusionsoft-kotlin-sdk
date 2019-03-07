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
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface TaskApi {

  /**
    *  Create a Task
    *  Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields `title` and `due_date`. All other attributes are optional
    *  * @param task task (optional)
    *  * @return Task
    */
  suspend fun createTask(task: Task) : Task
  
  /**
    *  Asynchronous implementation of Create a Task
    *  Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields `title` and `due_date`. All other attributes are optional
    *  * @param task task (optional)
    *  * @return A deferred reference to the final Task  
    */
  fun createTaskAsync(task: Task) : Deferred<Task>

  /**
    *  Delete a Task
    *  Permanently deletes a task
    *  * @param taskId taskId (optional)
    *  * @return void
    */
  suspend fun deleteTask(taskId: String)
  
  /**
    *  Asynchronous implementation of Delete a Task
    *  Permanently deletes a task
    *  * @param taskId taskId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteTaskAsync(taskId: String) : Deferred<Unit>

  /**
    *  Retrieve a Task
    *  Retrieves a single task
    *  * @param taskId taskId (optional)
    *  * @return Task
    */
  suspend fun getTask(taskId: String) : Task
  
  /**
    *  Asynchronous implementation of Retrieve a Task
    *  Retrieves a single task
    *  * @param taskId taskId (optional)
    *  * @return A deferred reference to the final Task  
    */
  fun getTaskAsync(taskId: String) : Deferred<Task>

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
  suspend fun listTasks(contactId: Long? = null, hasDueDate: Boolean? = null, userId: Long? = null, since: String? = null, until: String? = null, completed: Boolean? = null, limit: Int? = null, offset: Int? = null, order: String? = null) : TaskList
  
  /**
    *  Asynchronous implementation of List Tasks
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
    *  * @return A deferred reference to the final TaskList  
    */
  fun listTasksAsync(contactId: Long? = null, hasDueDate: Boolean? = null, userId: Long? = null, since: String? = null, until: String? = null, completed: Boolean? = null, limit: Int? = null, offset: Int? = null, order: String? = null) : Deferred<TaskList>

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
  suspend fun listTasksForCurrentUser(contactId: Long? = null, hasDueDate: Boolean? = null, userId: Long? = null, since: String? = null, until: String? = null, completed: Boolean? = null, limit: Int? = null, offset: Int? = null, order: String? = null) : TaskList
  
  /**
    *  Asynchronous implementation of Search Tasks
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
    *  * @return A deferred reference to the final TaskList  
    */
  fun listTasksForCurrentUserAsync(contactId: Long? = null, hasDueDate: Boolean? = null, userId: Long? = null, since: String? = null, until: String? = null, completed: Boolean? = null, limit: Int? = null, offset: Int? = null, order: String? = null) : Deferred<TaskList>

  /**
    *  Retrieve Task Model
    *  Get the custom fields for the Task object
    *  * @return ObjectModel
    */
  suspend fun retrieveTaskModel() : ObjectModel
  
  /**
    *  Asynchronous implementation of Retrieve Task Model
    *  Get the custom fields for the Task object
    *  * @return A deferred reference to the final ObjectModel  
    */
  fun retrieveTaskModelAsync() : Deferred<ObjectModel>

  /**
    *  Update a Task
    *  Updates a task with only the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  suspend fun updatePropertiesOnTask(taskId: String, task: Task) : Task
  
  /**
    *  Asynchronous implementation of Update a Task
    *  Updates a task with only the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return A deferred reference to the final Task  
    */
  fun updatePropertiesOnTaskAsync(taskId: String, task: Task) : Deferred<Task>

  /**
    *  Replace a Task
    *  Replaces a task with the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  suspend fun updateTask(taskId: String, task: Task) : Task
  
  /**
    *  Asynchronous implementation of Replace a Task
    *  Replaces a task with the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return A deferred reference to the final Task  
    */
  fun updateTaskAsync(taskId: String, task: Task) : Deferred<Task>

}

class TaskApiImpl(bearerToken:String, basePath: String, gson: Gson) : TaskApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Task
    *  Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields `title` and `due_date`. All other attributes are optional
    *  * @param task task (optional)
    *  * @return Task
    */
  override suspend fun createTask(task: Task) : Task {
    val uri = uriTemplate("/tasks")
      .build()
    val call = post(uri) {
      body = task ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Task
    *  Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields `title` and `due_date`. All other attributes are optional
    *  * @param task task (optional)
    *  * @return A deferred reference to the final Task  
    */
  override fun createTaskAsync(task: Task)  = 
        client.async { createTask(task) }

  /**
    *  Delete a Task
    *  Permanently deletes a task
    *  * @param taskId taskId (optional)
    *  * @return void
    */
  override suspend fun deleteTask(taskId: String) {
    val uri = uriTemplate("/tasks/{taskId}")
      .parameter("taskId", taskId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete a Task
    *  Permanently deletes a task
    *  * @param taskId taskId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteTaskAsync(taskId: String)  = 
        client.async { deleteTask(taskId) }

  /**
    *  Retrieve a Task
    *  Retrieves a single task
    *  * @param taskId taskId (optional)
    *  * @return Task
    */
  override suspend fun getTask(taskId: String) : Task {
    val uri = uriTemplate("/tasks/{taskId}")
      .parameter("taskId", taskId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Task
    *  Retrieves a single task
    *  * @param taskId taskId (optional)
    *  * @return A deferred reference to the final Task  
    */
  override fun getTaskAsync(taskId: String)  = 
        client.async { getTask(taskId) }

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
  override suspend fun listTasks(contactId: Long?, hasDueDate: Boolean?, userId: Long?, since: String?, until: String?, completed: Boolean?, limit: Int?, offset: Int?, order: String?) : TaskList {
    val uri = uriTemplate("/tasks")
      .build()
    val call = get(uri) {
      queryParam("contact_id",  contactId)
      queryParam("has_due_date",  hasDueDate)
      queryParam("user_id",  userId)
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("completed",  completed)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("order",  order)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Tasks
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
    *  * @return A deferred reference to the final TaskList  
    */
  override fun listTasksAsync(contactId: Long?, hasDueDate: Boolean?, userId: Long?, since: String?, until: String?, completed: Boolean?, limit: Int?, offset: Int?, order: String?)  = 
        client.async { listTasks(contactId, hasDueDate, userId, since, until, completed, limit, offset, order) }

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
  override suspend fun listTasksForCurrentUser(contactId: Long?, hasDueDate: Boolean?, userId: Long?, since: String?, until: String?, completed: Boolean?, limit: Int?, offset: Int?, order: String?) : TaskList {
    val uri = uriTemplate("/tasks/search")
      .build()
    val call = get(uri) {
      queryParam("contact_id",  contactId)
      queryParam("has_due_date",  hasDueDate)
      queryParam("user_id",  userId)
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("completed",  completed)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("order",  order)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Search Tasks
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
    *  * @return A deferred reference to the final TaskList  
    */
  override fun listTasksForCurrentUserAsync(contactId: Long?, hasDueDate: Boolean?, userId: Long?, since: String?, until: String?, completed: Boolean?, limit: Int?, offset: Int?, order: String?)  = 
        client.async { listTasksForCurrentUser(contactId, hasDueDate, userId, since, until, completed, limit, offset, order) }

  /**
    *  Retrieve Task Model
    *  Get the custom fields for the Task object
    *  * @return ObjectModel
    */
  override suspend fun retrieveTaskModel() : ObjectModel {
    val uri = uriTemplate("/tasks/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Task Model
    *  Get the custom fields for the Task object
    *  * @return A deferred reference to the final ObjectModel  
    */
  override fun retrieveTaskModelAsync()  = 
        client.async { retrieveTaskModel() }

  /**
    *  Update a Task
    *  Updates a task with only the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  override suspend fun updatePropertiesOnTask(taskId: String, task: Task) : Task {
    val uri = uriTemplate("/tasks/{taskId}")
      .parameter("taskId", taskId)
      .build()
    val call = patch(uri) {
      body = task ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Update a Task
    *  Updates a task with only the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return A deferred reference to the final Task  
    */
  override fun updatePropertiesOnTaskAsync(taskId: String, task: Task)  = 
        client.async { updatePropertiesOnTask(taskId, task) }

  /**
    *  Replace a Task
    *  Replaces a task with the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return Task
    */
  override suspend fun updateTask(taskId: String, task: Task) : Task {
    val uri = uriTemplate("/tasks/{taskId}")
      .parameter("taskId", taskId)
      .build()
    val call = put(uri) {
      body = task ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Replace a Task
    *  Replaces a task with the values provided in the request
    *  * @param taskId taskId (optional)
    *  * @param task task (optional)
    *  * @return A deferred reference to the final Task  
    */
  override fun updateTaskAsync(taskId: String, task: Task)  = 
        client.async { updateTask(taskId, task) }

}
   

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

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.Task
import io.mverse.client.infusionsoft.models.TaskList

import io.mverse.client.infusionsoft.infrastructure.*

class TaskApi(bearerToken:String, basePath: kotlin.String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

    /**
    * Create a Task
    * Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields &#x60;title&#x60; and &#x60;due_date&#x60;. All other attributes are optional
    * @param task task 
    * @return Task
    */
    @Suppress("UNCHECKED_CAST")
    fun createTask(task: Task) : Task {
       val requestBody = task
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.POST,
           "/tasks",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Task, Task>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Task
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Delete a Task
    * Permanently deletes a task
    * @param taskId taskId 
    * @return void
    */
    fun deleteTask(taskId: String) : Unit {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.DELETE,
           "/tasks/{taskId}".replace("{"+"taskId"+"}", "$taskId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, Unit>(
           localVariableConfig,
           requestBody
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
    * Retrieve a Task
    * Retrieves a single task
    * @param taskId taskId 
    * @return Task
    */
    @Suppress("UNCHECKED_CAST")
    fun getTask(taskId: String) : Task {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tasks/{taskId}".replace("{"+"taskId"+"}", "$taskId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, Task>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Task
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * List Tasks
    * Retrieves a list of all tasks using the specified search criteria
    * @param contactId contact_id (optional)
    * @param hasDueDate has_due_date (optional)
    * @param userId user_id (optional)
    * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param completed Sets completed status of items to return (optional)
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param order Attribute to order items by (optional)
    * @return TaskList
    */
    @Suppress("UNCHECKED_CAST")
    fun listTasks(contactId: Long? = null, hasDueDate: Boolean? = null, userId: Long? = null, since: String? = null, until: String? = null, completed: Boolean? = null, limit: Int? = null, offset: Int? = null, order: String? = null) : TaskList {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")
      if (hasDueDate != null) localVariableQuery["has_due_date"] = listOf("$hasDueDate")
      if (userId != null) localVariableQuery["user_id"] = listOf("$userId")
      if (since != null) localVariableQuery["since"] = listOf("$since")
      if (until != null) localVariableQuery["until"] = listOf("$until")
      if (completed != null) localVariableQuery["completed"] = listOf("$completed")
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")
      if (order != null) localVariableQuery["order"] = listOf("$order")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tasks",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, TaskList>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as TaskList
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Search Tasks
    * Retrieves Tasks belonging to the authenticated user using the specified search criteria
    * @param contactId Returns tasks for the provided contact id (optional)
    * @param hasDueDate Returns tasks that have an &#39;action date&#39; when set to true (optional)
    * @param userId Returns tasks for the provided user id (optional)
    * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
    * @param completed Sets completed status of items to return (optional)
    * @param limit Sets a total of items to return (optional)
    * @param offset Sets a beginning range of items to return (optional)
    * @param order Attribute to order items by (optional)
    * @return TaskList
    */
    @Suppress("UNCHECKED_CAST")
    fun listTasksForCurrentUser(contactId: Long? = null, hasDueDate: Boolean? = null, userId: Long? = null, since: String? = null, until: String? = null, completed: Boolean? = null, limit: Int? = null, offset: Int? = null, order: String? = null) : TaskList {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()
      if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")
      if (hasDueDate != null) localVariableQuery["has_due_date"] = listOf("$hasDueDate")
      if (userId != null) localVariableQuery["user_id"] = listOf("$userId")
      if (since != null) localVariableQuery["since"] = listOf("$since")
      if (until != null) localVariableQuery["until"] = listOf("$until")
      if (completed != null) localVariableQuery["completed"] = listOf("$completed")
      if (limit != null) localVariableQuery["limit"] = listOf("$limit")
      if (offset != null) localVariableQuery["offset"] = listOf("$offset")
      if (order != null) localVariableQuery["order"] = listOf("$order")

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tasks/search",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, TaskList>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as TaskList
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Retrieve Task Model
    * Get the custom fields for the Task object
    * @return ObjectModel
    */
    @Suppress("UNCHECKED_CAST")
    fun retrieveTaskModel() : ObjectModel {
       val requestBody = null
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.GET,
           "/tasks/model",
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Any, ObjectModel>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as ObjectModel
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Update a Task
    * Updates a task with only the values provided in the request
    * @param taskId taskId 
    * @param task task 
    * @return Task
    */
    @Suppress("UNCHECKED_CAST")
    fun updatePropertiesOnTask(taskId: String, task: Task) : Task {
       val requestBody = task
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.PATCH,
           "/tasks/{taskId}".replace("{"+"taskId"+"}", "$taskId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Task, Task>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Task
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

    /**
    * Replace a Task
    * Replaces a task with the values provided in the request
    * @param taskId taskId 
    * @param task task 
    * @return Task
    */
    @Suppress("UNCHECKED_CAST")
    fun updateTask(taskId: String, task: Task) : Task {
       val requestBody = task
       val localVariableQuery: MultiValueMap = mutableMapOf()

       val contentHeaders: Map<String, String> = mapOf()
       val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
       val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
       localVariableHeaders.putAll(contentHeaders)
       localVariableHeaders.putAll(acceptsHeaders)

       val localVariableConfig = RequestConfig(
           RequestMethod.PUT,
           "/tasks/{taskId}".replace("{"+"taskId"+"}", "$taskId"),
           query = localVariableQuery,
           headers = localVariableHeaders
       )
       val response = request<Task, Task>(
           localVariableConfig,
           requestBody
       )

       return when (response.responseType) {
           ResponseType.Success -> (response as Success<*>).data as Task
           ResponseType.Informational -> TODO()
           ResponseType.Redirection -> TODO()
           ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
           ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
           else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
       }
    }

}

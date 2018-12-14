# TaskApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTask**](TaskApi.md#createTask) | **POST** /tasks | Create a Task
[**deleteTask**](TaskApi.md#deleteTask) | **DELETE** /tasks/{taskId} | Delete a Task
[**getTask**](TaskApi.md#getTask) | **GET** /tasks/{taskId} | Retrieve a Task
[**listTasks**](TaskApi.md#listTasks) | **GET** /tasks | List Tasks
[**listTasksForCurrentUser**](TaskApi.md#listTasksForCurrentUser) | **GET** /tasks/search | Search Tasks
[**retrieveTaskModel**](TaskApi.md#retrieveTaskModel) | **GET** /tasks/model | Retrieve Task Model
[**updatePropertiesOnTask**](TaskApi.md#updatePropertiesOnTask) | **PATCH** /tasks/{taskId} | Update a Task
[**updateTask**](TaskApi.md#updateTask) | **PUT** /tasks/{taskId} | Replace a Task


<a name="createTask"></a>
# **createTask**
> Task createTask(task)

Create a Task

Creates a new task as the authenticated user. NB: Contact must contain at least one item in the fields &#x60;title&#x60; and &#x60;due_date&#x60;. All other attributes are optional

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val task : Task =  // Task | task
try {
    val result : Task = apiInstance.createTask(task)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#createTask")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#createTask")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **task** | [**Task**](Task.md)| task |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteTask"></a>
# **deleteTask**
> deleteTask(taskId)

Delete a Task

Permanently deletes a task

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val taskId : String = taskId_example // String | taskId
try {
    apiInstance.deleteTask(taskId)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#deleteTask")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#deleteTask")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **String**| taskId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTask"></a>
# **getTask**
> Task getTask(taskId)

Retrieve a Task

Retrieves a single task

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val taskId : String = taskId_example // String | taskId
try {
    val result : Task = apiInstance.getTask(taskId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#getTask")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#getTask")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **String**| taskId |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listTasks"></a>
# **listTasks**
> TaskList listTasks(contactId, hasDueDate, userId, since, until, completed, limit, offset, order)

List Tasks

Retrieves a list of all tasks using the specified search criteria

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val contactId : Long = 789 // Long | contact_id
val hasDueDate : Boolean = true // Boolean | has_due_date
val userId : Long = 789 // Long | user_id
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val completed : Boolean = true // Boolean | Sets completed status of items to return
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val order : String = order_example // String | Attribute to order items by
try {
    val result : TaskList = apiInstance.listTasks(contactId, hasDueDate, userId, since, until, completed, limit, offset, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#listTasks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#listTasks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| contact_id | [optional]
 **hasDueDate** | **Boolean**| has_due_date | [optional]
 **userId** | **Long**| user_id | [optional]
 **since** | **String**| Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **completed** | **Boolean**| Sets completed status of items to return | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **order** | **String**| Attribute to order items by | [optional]

### Return type

[**TaskList**](TaskList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listTasksForCurrentUser"></a>
# **listTasksForCurrentUser**
> TaskList listTasksForCurrentUser(contactId, hasDueDate, userId, since, until, completed, limit, offset, order)

Search Tasks

Retrieves Tasks belonging to the authenticated user using the specified search criteria

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val contactId : Long = 789 // Long | Returns tasks for the provided contact id
val hasDueDate : Boolean = true // Boolean | Returns tasks that have an 'action date' when set to true
val userId : Long = 789 // Long | Returns tasks for the provided user id
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val completed : Boolean = true // Boolean | Sets completed status of items to return
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val order : String = order_example // String | Attribute to order items by
try {
    val result : TaskList = apiInstance.listTasksForCurrentUser(contactId, hasDueDate, userId, since, until, completed, limit, offset, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#listTasksForCurrentUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#listTasksForCurrentUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contactId** | **Long**| Returns tasks for the provided contact id | [optional]
 **hasDueDate** | **Boolean**| Returns tasks that have an &#39;action date&#39; when set to true | [optional]
 **userId** | **Long**| Returns tasks for the provided user id | [optional]
 **since** | **String**| Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **completed** | **Boolean**| Sets completed status of items to return | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **order** | **String**| Attribute to order items by | [optional]

### Return type

[**TaskList**](TaskList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveTaskModel"></a>
# **retrieveTaskModel**
> ObjectModel retrieveTaskModel()

Retrieve Task Model

Get the custom fields for the Task object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
try {
    val result : ObjectModel = apiInstance.retrieveTaskModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#retrieveTaskModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#retrieveTaskModel")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ObjectModel**](ObjectModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePropertiesOnTask"></a>
# **updatePropertiesOnTask**
> Task updatePropertiesOnTask(taskId, task)

Update a Task

Updates a task with only the values provided in the request

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val taskId : String = taskId_example // String | taskId
val task : Task =  // Task | task
try {
    val result : Task = apiInstance.updatePropertiesOnTask(taskId, task)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#updatePropertiesOnTask")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#updatePropertiesOnTask")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **String**| taskId |
 **task** | [**Task**](Task.md)| task |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateTask"></a>
# **updateTask**
> Task updateTask(taskId, task)

Replace a Task

Replaces a task with the values provided in the request

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = TaskApi()
val taskId : String = taskId_example // String | taskId
val task : Task =  // Task | task
try {
    val result : Task = apiInstance.updateTask(taskId, task)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaskApi#updateTask")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaskApi#updateTask")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **String**| taskId |
 **task** | [**Task**](Task.md)| task |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# ECommerceApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createOrder**](ECommerceApi.md#createOrder) | **POST** /orders | Create an Order
[**createOrderItemsOnOrder**](ECommerceApi.md#createOrderItemsOnOrder) | **POST** /orders/{orderId}/items | Create an Order Item
[**createPaymentOnOrder**](ECommerceApi.md#createPaymentOnOrder) | **POST** /orders/{orderId}/payments | Create a Payment
[**deleteOrder**](ECommerceApi.md#deleteOrder) | **DELETE** /orders/{orderId} | Delete an Order
[**deleteOrderOrderItem**](ECommerceApi.md#deleteOrderOrderItem) | **DELETE** /orders/{orderId}/items/{orderItemId} | Delete an Order Item
[**getOrder**](ECommerceApi.md#getOrder) | **GET** /orders/{orderId} | Retrieve an Order
[**getTransaction**](ECommerceApi.md#getTransaction) | **GET** /transactions/{transactionId} | Retrieve a Transaction
[**listOrders**](ECommerceApi.md#listOrders) | **GET** /orders | List Orders
[**listSubscriptions**](ECommerceApi.md#listSubscriptions) | **GET** /subscriptions | List Subscriptions
[**listTransactions**](ECommerceApi.md#listTransactions) | **GET** /transactions | List Transactions
[**listTransactionsForOrder**](ECommerceApi.md#listTransactionsForOrder) | **GET** /orders/{orderId}/transactions | Retrieve Order Transactions
[**replacePaymentPlan**](ECommerceApi.md#replacePaymentPlan) | **PUT** /orders/{orderId}/paymentPlan | Replace an Order Pay Plan
[**retrieveOrderModel**](ECommerceApi.md#retrieveOrderModel) | **GET** /orders/model | Retrieve Custom Order Model
[**retrieveSubscriptionModel**](ECommerceApi.md#retrieveSubscriptionModel) | **GET** /subscriptions/model | Retrieve Subscription Model


<a name="createOrder"></a>
# **createOrder**
> Order createOrder(createOrder)

Create an Order

Create a one time order with order items.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val createOrder : CreateOrder =  // CreateOrder | createOrder
try {
    val result : Order = apiInstance.createOrder(createOrder)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#createOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#createOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createOrder** | [**CreateOrder**](CreateOrder.md)| createOrder |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createOrderItemsOnOrder"></a>
# **createOrderItemsOnOrder**
> OrderItem createOrderItemsOnOrder(createOrderItem, orderId)

Create an Order Item

Creates an order item on an existing order.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val createOrderItem : CreateOrderItem =  // CreateOrderItem | createOrderItem
val orderId : Long = 789 // Long | orderId
try {
    val result : OrderItem = apiInstance.createOrderItemsOnOrder(createOrderItem, orderId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#createOrderItemsOnOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#createOrderItemsOnOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createOrderItem** | [**CreateOrderItem**](CreateOrderItem.md)| createOrderItem |
 **orderId** | **Long**| orderId |

### Return type

[**OrderItem**](OrderItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPaymentOnOrder"></a>
# **createPaymentOnOrder**
> PaymentResult createPaymentOnOrder(orderId, createPayment)

Create a Payment

Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val orderId : Long = 789 // Long | orderId
val createPayment : CreatePayment =  // CreatePayment | createPayment
try {
    val result : PaymentResult = apiInstance.createPaymentOnOrder(orderId, createPayment)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#createPaymentOnOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#createPaymentOnOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| orderId |
 **createPayment** | [**CreatePayment**](CreatePayment.md)| createPayment | [optional]

### Return type

[**PaymentResult**](PaymentResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteOrder"></a>
# **deleteOrder**
> deleteOrder(orderId)

Delete an Order

Delete an order that does not have a payment

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val orderId : Long = 789 // Long | orderId
try {
    apiInstance.deleteOrder(orderId)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#deleteOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#deleteOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| orderId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteOrderOrderItem"></a>
# **deleteOrderOrderItem**
> deleteOrderOrderItem(orderId, orderItemId)

Delete an Order Item

Delete an order Item on specified Order

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val orderId : Long = 789 // Long | orderId
val orderItemId : Long = 789 // Long | orderItemId
try {
    apiInstance.deleteOrderOrderItem(orderId, orderItemId)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#deleteOrderOrderItem")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#deleteOrderOrderItem")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| orderId |
 **orderItemId** | **Long**| orderItemId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOrder"></a>
# **getOrder**
> Order getOrder(orderId)

Retrieve an Order

Retrieves a single order. The order may or may not have items.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val orderId : Long = 789 // Long | orderId
try {
    val result : Order = apiInstance.getOrder(orderId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#getOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#getOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| orderId |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTransaction"></a>
# **getTransaction**
> Transaction getTransaction(transactionId)

Retrieve a Transaction

Retrieves a single transaction

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val transactionId : Long = 789 // Long | transactionId
try {
    val result : Transaction = apiInstance.getTransaction(transactionId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#getTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#getTransaction")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionId** | **Long**| transactionId |

### Return type

[**Transaction**](Transaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listOrders"></a>
# **listOrders**
> OrderList listOrders(since, until, limit, offset, paid, order, contactId, productId)

List Orders

Retrieves a list of all orders using the specified search criteria. Each order may or may not have items.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val paid : Boolean = true // Boolean | Sets paid status of items to return
val order : String = order_example // String | Attribute to order items by
val contactId : Long = 789 // Long | Returns orders for the provided contact id
val productId : Long = 789 // Long | Returns orders containing the provided product id
try {
    val result : OrderList = apiInstance.listOrders(since, until, limit, offset, paid, order, contactId, productId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#listOrders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#listOrders")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **since** | **String**| Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **paid** | **Boolean**| Sets paid status of items to return | [optional]
 **order** | **String**| Attribute to order items by | [optional]
 **contactId** | **Long**| Returns orders for the provided contact id | [optional]
 **productId** | **Long**| Returns orders containing the provided product id | [optional]

### Return type

[**OrderList**](OrderList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listSubscriptions"></a>
# **listSubscriptions**
> SubscriptionList listSubscriptions(limit, offset, contactId)

List Subscriptions

Retrieves a list of all subcriptions using the specified search criteria.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val contactId : Long = 789 // Long | Returns subscriptions for the provided contact id
try {
    val result : SubscriptionList = apiInstance.listSubscriptions(limit, offset, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#listSubscriptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#listSubscriptions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **contactId** | **Long**| Returns subscriptions for the provided contact id | [optional]

### Return type

[**SubscriptionList**](SubscriptionList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listTransactions"></a>
# **listTransactions**
> TransactionList listTransactions(since, until, limit, offset, contactId)

List Transactions

Retrieves a list transactions for a given contact

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val contactId : Long = 789 // Long | Returns transactions for the provided contact id
try {
    val result : TransactionList = apiInstance.listTransactions(since, until, limit, offset, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#listTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#listTransactions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **since** | **String**| Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **contactId** | **Long**| Returns transactions for the provided contact id | [optional]

### Return type

[**TransactionList**](TransactionList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listTransactionsForOrder"></a>
# **listTransactionsForOrder**
> TransactionList listTransactionsForOrder(orderId, since, until, limit, offset, contactId)

Retrieve Order Transactions

Retrieves a list of all transactions on a given order using the specified search criteria

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val orderId : Long = 789 // Long | orderId
val since : String = since_example // String | Date to start searching from ex. `2017-01-01T22:17:59.039Z`
val until : String = until_example // String | Date to search to ex. `2017-01-01T22:17:59.039Z`
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val contactId : Long = 789 // Long | Returns transactions for the provided contact id
try {
    val result : TransactionList = apiInstance.listTransactionsForOrder(orderId, since, until, limit, offset, contactId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#listTransactionsForOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#listTransactionsForOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| orderId |
 **since** | **String**| Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **until** | **String**| Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **contactId** | **Long**| Returns transactions for the provided contact id | [optional]

### Return type

[**TransactionList**](TransactionList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="replacePaymentPlan"></a>
# **replacePaymentPlan**
> PaymentPlan replacePaymentPlan(orderId, paymentPlan)

Replace an Order Pay Plan

Replaces the order&#39;s payment plan with the given values.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
val orderId : Long = 789 // Long | orderId
val paymentPlan : PaymentPlan =  // PaymentPlan | paymentPlan
try {
    val result : PaymentPlan = apiInstance.replacePaymentPlan(orderId, paymentPlan)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#replacePaymentPlan")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#replacePaymentPlan")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| orderId |
 **paymentPlan** | [**PaymentPlan**](PaymentPlan.md)| paymentPlan |

### Return type

[**PaymentPlan**](PaymentPlan.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveOrderModel"></a>
# **retrieveOrderModel**
> ObjectModel retrieveOrderModel()

Retrieve Custom Order Model

Get the custom fields for the Order object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
try {
    val result : ObjectModel = apiInstance.retrieveOrderModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#retrieveOrderModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#retrieveOrderModel")
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

<a name="retrieveSubscriptionModel"></a>
# **retrieveSubscriptionModel**
> ObjectModel retrieveSubscriptionModel()

Retrieve Subscription Model

Get the custom fields for the Subscription object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ECommerceApi()
try {
    val result : ObjectModel = apiInstance.retrieveSubscriptionModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ECommerceApi#retrieveSubscriptionModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ECommerceApi#retrieveSubscriptionModel")
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


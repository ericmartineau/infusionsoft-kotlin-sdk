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

import io.mverse.client.infusionsoft.models.CreateOrder
import io.mverse.client.infusionsoft.models.CreateOrderItem
import io.mverse.client.infusionsoft.models.CreatePayment
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.ObjectModel
import io.mverse.client.infusionsoft.models.Order
import io.mverse.client.infusionsoft.models.OrderItem
import io.mverse.client.infusionsoft.models.OrderList
import io.mverse.client.infusionsoft.models.PaymentPlan
import io.mverse.client.infusionsoft.models.PaymentResult
import io.mverse.client.infusionsoft.models.SubscriptionList
import io.mverse.client.infusionsoft.models.Transaction
import io.mverse.client.infusionsoft.models.TransactionList

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*


class ECommerceApi(bearerToken:String, basePath: String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

  /**
   *  Create an Order
   *  Create a one time order with order items.
   *  * @param createOrder createOrder 
   *  * @return Order
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createOrder(createOrder: CreateOrder) : Order {
    val requestBody = createOrder
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/orders",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Order.serializer(),
      CreateOrder.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Order
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create an Order Item
   *  Creates an order item on an existing order.
   *  * @param createOrderItem createOrderItem 
   *  * @param orderId orderId 
   *  * @return OrderItem
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createOrderItemsOnOrder(createOrderItem: CreateOrderItem, orderId: Long) : OrderItem {
    val requestBody = createOrderItem
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/orders/{orderId}/items".replace("{"+"orderId"+"}", "$orderId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      OrderItem.serializer(),
      CreateOrderItem.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as OrderItem
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Create a Payment
   *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
   *  * @param orderId orderId 
   *  * @param createPayment createPayment (optional)
   *  * @return PaymentResult
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createPaymentOnOrder(orderId: Long, createPayment: CreatePayment? = null) : PaymentResult {
    val requestBody = createPayment
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/orders/{orderId}/payments".replace("{"+"orderId"+"}", "$orderId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      PaymentResult.serializer(),
      CreatePayment.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as PaymentResult
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Delete an Order
   *  Delete an order that does not have a payment
   *  * @param orderId orderId 
   *  * @return void
   */ 
  fun deleteOrder(orderId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/orders/{orderId}".replace("{"+"orderId"+"}", "$orderId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, UnitSerializer)

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
   *  Delete an Order Item
   *  Delete an order Item on specified Order
   *  * @param orderId orderId 
   *  * @param orderItemId orderItemId 
   *  * @return void
   */ 
  fun deleteOrderOrderItem(orderId: Long, orderItemId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/orders/{orderId}/items/{orderItemId}".replace("{"+"orderId"+"}", "$orderId").replace("{"+"orderItemId"+"}", "$orderItemId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, UnitSerializer)

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
   *  Retrieve an Order
   *  Retrieves a single order. The order may or may not have items.
   *  * @param orderId orderId 
   *  * @return Order
   */ 
  @Suppress("UNCHECKED_CAST")
  fun getOrder(orderId: Long) : Order {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/orders/{orderId}".replace("{"+"orderId"+"}", "$orderId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Order.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Order
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve a Transaction
   *  Retrieves a single transaction
   *  * @param transactionId transactionId 
   *  * @return Transaction
   */ 
  @Suppress("UNCHECKED_CAST")
  fun getTransaction(transactionId: Long) : Transaction {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/transactions/{transactionId}".replace("{"+"transactionId"+"}", "$transactionId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Transaction.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Transaction
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Orders
   *  Retrieves a list of all orders using the specified search criteria. Each order may or may not have items.
   *  * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param paid Sets paid status of items to return (optional)
   *  * @param order Attribute to order items by (optional)
   *  * @param contactId Returns orders for the provided contact id (optional)
   *  * @param productId Returns orders containing the provided product id (optional)
   *  * @return OrderList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listOrders(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, paid: Boolean? = null, order: String? = null, contactId: Long? = null, productId: Long? = null) : OrderList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (since != null) localVariableQuery["since"] = listOf("$since")
    if (until != null) localVariableQuery["until"] = listOf("$until")
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (paid != null) localVariableQuery["paid"] = listOf("$paid")
    if (order != null) localVariableQuery["order"] = listOf("$order")
    if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")
    if (productId != null) localVariableQuery["product_id"] = listOf("$productId")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/orders",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      OrderList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as OrderList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Subscriptions
   *  Retrieves a list of all subcriptions using the specified search criteria.
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param contactId Returns subscriptions for the provided contact id (optional)
   *  * @return SubscriptionList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listSubscriptions(limit: Int? = null, offset: Int? = null, contactId: Long? = null) : SubscriptionList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/subscriptions",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      SubscriptionList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as SubscriptionList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Transactions
   *  Retrieves a list transactions for a given contact
   *  * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param contactId Returns transactions for the provided contact id (optional)
   *  * @return TransactionList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listTransactions(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : TransactionList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (since != null) localVariableQuery["since"] = listOf("$since")
    if (until != null) localVariableQuery["until"] = listOf("$until")
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/transactions",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      TransactionList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as TransactionList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Order Transactions
   *  Retrieves a list of all transactions on a given order using the specified search criteria
   *  * @param orderId orderId 
   *  * @param since Date to start searching from ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param until Date to search to ex. &#x60;2017-01-01T22:17:59.039Z&#x60; (optional)
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param contactId Returns transactions for the provided contact id (optional)
   *  * @return TransactionList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listTransactionsForOrder(orderId: Long, since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : TransactionList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (since != null) localVariableQuery["since"] = listOf("$since")
    if (until != null) localVariableQuery["until"] = listOf("$until")
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (contactId != null) localVariableQuery["contact_id"] = listOf("$contactId")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/orders/{orderId}/transactions".replace("{"+"orderId"+"}", "$orderId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      TransactionList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as TransactionList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Replace an Order Pay Plan
   *  Replaces the order&#39;s payment plan with the given values.
   *  * @param orderId orderId 
   *  * @param paymentPlan paymentPlan 
   *  * @return PaymentPlan
   */ 
  @Suppress("UNCHECKED_CAST")
  fun replacePaymentPlan(orderId: Long, paymentPlan: PaymentPlan) : PaymentPlan {
    val requestBody = paymentPlan
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PUT,
       "/orders/{orderId}/paymentPlan".replace("{"+"orderId"+"}", "$orderId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      PaymentPlan.serializer(),
      PaymentPlan.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as PaymentPlan
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Custom Order Model
   *  Get the custom fields for the Order object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveOrderModel() : ObjectModel {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/orders/model",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ObjectModel.serializer(),UnitSerializer)

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
   *  Retrieve Subscription Model
   *  Get the custom fields for the Subscription object
   *  * @return ObjectModel
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveSubscriptionModel() : ObjectModel {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/subscriptions/model",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ObjectModel.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ObjectModel
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
}

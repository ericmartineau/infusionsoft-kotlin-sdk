@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
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
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface ECommerceApi {

  /**
    *  Create an Order
    *  Create a one time order with order items.
    *  * @param createOrder createOrder (optional)
    *  * @return Order
    */
  suspend fun createOrder(createOrder: CreateOrder? = null) : Order
    
  /**
    *  Create an Order Item
    *  Creates an order item on an existing order.
    *  * @param createOrderItem createOrderItem (optional)
    *  * @param orderId orderId (optional)
    *  * @return OrderItem
    */
  suspend fun createOrderItemsOnOrder(createOrderItem: CreateOrderItem? = null, orderId: Long? = null) : OrderItem
    
  /**
    *  Create a Payment
    *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
    *  * @param orderId orderId (optional)
    *  * @param createPayment createPayment 
    *  * @return PaymentResult
    */
  suspend fun createPaymentOnOrder(orderId: Long? = null, createPayment: CreatePayment) : PaymentResult
    
  /**
    *  Delete an Order
    *  Delete an order that does not have a payment
    *  * @param orderId orderId (optional)
    *  * @return void
    */
  suspend fun deleteOrder(orderId: Long? = null) : Unit
    
  /**
    *  Delete an Order Item
    *  Delete an order Item on specified Order
    *  * @param orderId orderId (optional)
    *  * @param orderItemId orderItemId (optional)
    *  * @return void
    */
  suspend fun deleteOrderOrderItem(orderId: Long? = null, orderItemId: Long? = null) : Unit
    
  /**
    *  Retrieve an Order
    *  Retrieves a single order. The order may or may not have items.
    *  * @param orderId orderId (optional)
    *  * @return Order
    */
  suspend fun getOrder(orderId: Long? = null) : Order
    
  /**
    *  Retrieve a Transaction
    *  Retrieves a single transaction
    *  * @param transactionId transactionId (optional)
    *  * @return Transaction
    */
  suspend fun getTransaction(transactionId: Long? = null) : Transaction
    
  /**
    *  List Orders
    *  Retrieves a list of all orders using the specified search criteria. Each order may or may not have items.
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param paid Sets paid status of items to return 
    *  * @param order Attribute to order items by 
    *  * @param contactId Returns orders for the provided contact id 
    *  * @param productId Returns orders containing the provided product id 
    *  * @return OrderList
    */
  suspend fun listOrders(since: String, until: String, limit: Int, offset: Int, paid: Boolean, order: String, contactId: Long, productId: Long) : OrderList
    
  /**
    *  List Subscriptions
    *  Retrieves a list of all subcriptions using the specified search criteria.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns subscriptions for the provided contact id 
    *  * @return SubscriptionList
    */
  suspend fun listSubscriptions(limit: Int, offset: Int, contactId: Long) : SubscriptionList
    
  /**
    *  List Transactions
    *  Retrieves a list transactions for a given contact
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return TransactionList
    */
  suspend fun listTransactions(since: String, until: String, limit: Int, offset: Int, contactId: Long) : TransactionList
    
  /**
    *  Retrieve Order Transactions
    *  Retrieves a list of all transactions on a given order using the specified search criteria
    *  * @param orderId orderId (optional)
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return TransactionList
    */
  suspend fun listTransactionsForOrder(orderId: Long? = null, since: String, until: String, limit: Int, offset: Int, contactId: Long) : TransactionList
    
  /**
    *  Replace an Order Pay Plan
    *  Replaces the order's payment plan with the given values.
    *  * @param orderId orderId (optional)
    *  * @param paymentPlan paymentPlan (optional)
    *  * @return PaymentPlan
    */
  suspend fun replacePaymentPlan(orderId: Long? = null, paymentPlan: PaymentPlan? = null) : PaymentPlan
    
  /**
    *  Retrieve Custom Order Model
    *  Get the custom fields for the Order object
    *  * @return ObjectModel
    */
  suspend fun retrieveOrderModel() : ObjectModel
    
  /**
    *  Retrieve Subscription Model
    *  Get the custom fields for the Subscription object
    *  * @return ObjectModel
    */
  suspend fun retrieveSubscriptionModel() : ObjectModel
    
}

class ECommerceApiImpl(bearerToken:String, basePath: String, gson: Gson) : ECommerceApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Order
    *  Create a one time order with order items.
    *  * @param createOrder createOrder (optional)
    *  * @return Order
    */
  override suspend fun createOrder(createOrder: CreateOrder?) : Order {
    val call = request( "/orders", mapOf()) {
      method = HttpMethod.parse("POST")
      body = createOrder ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create an Order Item
    *  Creates an order item on an existing order.
    *  * @param createOrderItem createOrderItem (optional)
    *  * @param orderId orderId (optional)
    *  * @return OrderItem
    */
  override suspend fun createOrderItemsOnOrder(createOrderItem: CreateOrderItem?, orderId: Long?) : OrderItem {
    val call = request( "/orders/{orderId}/items", mapOf("orderId" to "$orderId")) {
      method = HttpMethod.parse("POST")
      body = createOrderItem ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create a Payment
    *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
    *  * @param orderId orderId (optional)
    *  * @param createPayment createPayment 
    *  * @return PaymentResult
    */
  override suspend fun createPaymentOnOrder(orderId: Long?, createPayment: CreatePayment) : PaymentResult {
    val call = request( "/orders/{orderId}/payments", mapOf("orderId" to "$orderId")) {
      method = HttpMethod.parse("POST")
      body = createPayment ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete an Order
    *  Delete an order that does not have a payment
    *  * @param orderId orderId (optional)
    *  * @return void
    */
  override suspend fun deleteOrder(orderId: Long?) : Unit {
    val call = request( "/orders/{orderId}", mapOf("orderId" to "$orderId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Delete an Order Item
    *  Delete an order Item on specified Order
    *  * @param orderId orderId (optional)
    *  * @param orderItemId orderItemId (optional)
    *  * @return void
    */
  override suspend fun deleteOrderOrderItem(orderId: Long?, orderItemId: Long?) : Unit {
    val call = request( "/orders/{orderId}/items/{orderItemId}", mapOf("orderId" to "$orderId", "orderItemId" to "$orderItemId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Retrieve an Order
    *  Retrieves a single order. The order may or may not have items.
    *  * @param orderId orderId (optional)
    *  * @return Order
    */
  override suspend fun getOrder(orderId: Long?) : Order {
    val call = request( "/orders/{orderId}", mapOf("orderId" to "$orderId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Retrieve a Transaction
    *  Retrieves a single transaction
    *  * @param transactionId transactionId (optional)
    *  * @return Transaction
    */
  override suspend fun getTransaction(transactionId: Long?) : Transaction {
    val call = request( "/transactions/{transactionId}", mapOf("transactionId" to "$transactionId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Orders
    *  Retrieves a list of all orders using the specified search criteria. Each order may or may not have items.
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param paid Sets paid status of items to return 
    *  * @param order Attribute to order items by 
    *  * @param contactId Returns orders for the provided contact id 
    *  * @param productId Returns orders containing the provided product id 
    *  * @return OrderList
    */
  override suspend fun listOrders(since: String, until: String, limit: Int, offset: Int, paid: Boolean, order: String, contactId: Long, productId: Long) : OrderList {
    val call = request( "/orders", mapOf()) {
      method = HttpMethod.parse("GET")
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (paid != null) url.parameters.append("paid", "$paid")
      
    
      if (order != null) url.parameters.append("order", "$order")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
      if (productId != null) url.parameters.append("product_id", "$productId")
      
    
    }
    return call.receive()
  }

  /**
    *  List Subscriptions
    *  Retrieves a list of all subcriptions using the specified search criteria.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns subscriptions for the provided contact id 
    *  * @return SubscriptionList
    */
  override suspend fun listSubscriptions(limit: Int, offset: Int, contactId: Long) : SubscriptionList {
    val call = request( "/subscriptions", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
    }
    return call.receive()
  }

  /**
    *  List Transactions
    *  Retrieves a list transactions for a given contact
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return TransactionList
    */
  override suspend fun listTransactions(since: String, until: String, limit: Int, offset: Int, contactId: Long) : TransactionList {
    val call = request( "/transactions", mapOf()) {
      method = HttpMethod.parse("GET")
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Order Transactions
    *  Retrieves a list of all transactions on a given order using the specified search criteria
    *  * @param orderId orderId (optional)
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return TransactionList
    */
  override suspend fun listTransactionsForOrder(orderId: Long?, since: String, until: String, limit: Int, offset: Int, contactId: Long) : TransactionList {
    val call = request( "/orders/{orderId}/transactions", mapOf("orderId" to "$orderId")) {
      method = HttpMethod.parse("GET")
      if (since != null) url.parameters.append("since", "$since")
      
    
      if (until != null) url.parameters.append("until", "$until")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (contactId != null) url.parameters.append("contact_id", "$contactId")
      
    
    }
    return call.receive()
  }

  /**
    *  Replace an Order Pay Plan
    *  Replaces the order's payment plan with the given values.
    *  * @param orderId orderId (optional)
    *  * @param paymentPlan paymentPlan (optional)
    *  * @return PaymentPlan
    */
  override suspend fun replacePaymentPlan(orderId: Long?, paymentPlan: PaymentPlan?) : PaymentPlan {
    val call = request( "/orders/{orderId}/paymentPlan", mapOf("orderId" to "$orderId")) {
      method = HttpMethod.parse("PUT")
      body = paymentPlan ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Custom Order Model
    *  Get the custom fields for the Order object
    *  * @return ObjectModel
    */
  override suspend fun retrieveOrderModel() : ObjectModel {
    val call = request( "/orders/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Retrieve Subscription Model
    *  Get the custom fields for the Subscription object
    *  * @return ObjectModel
    */
  override suspend fun retrieveSubscriptionModel() : ObjectModel {
    val call = request( "/subscriptions/model", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

}
   

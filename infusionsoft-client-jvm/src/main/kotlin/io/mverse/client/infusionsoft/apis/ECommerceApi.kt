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
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface ECommerceApi {

  /**
    *  Create an Order
    *  Create a one time order with order items.
    *  * @param createOrder createOrder (optional)
    *  * @return Order
    */
  suspend fun createOrder(createOrder: CreateOrder) : Order
  
  /**
    *  Asynchronous implementation of Create an Order
    *  Create a one time order with order items.
    *  * @param createOrder createOrder (optional)
    *  * @return A deferred reference to the final Order  
    */
  fun createOrderAsync(createOrder: CreateOrder) : Deferred<Order>

  /**
    *  Create an Order Item
    *  Creates an order item on an existing order.
    *  * @param createOrderItem createOrderItem (optional)
    *  * @param orderId orderId (optional)
    *  * @return OrderItem
    */
  suspend fun createOrderItemsOnOrder(createOrderItem: CreateOrderItem, orderId: Long) : OrderItem
  
  /**
    *  Asynchronous implementation of Create an Order Item
    *  Creates an order item on an existing order.
    *  * @param createOrderItem createOrderItem (optional)
    *  * @param orderId orderId (optional)
    *  * @return A deferred reference to the final OrderItem  
    */
  fun createOrderItemsOnOrderAsync(createOrderItem: CreateOrderItem, orderId: Long) : Deferred<OrderItem>

  /**
    *  Create a Payment
    *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
    *  * @param orderId orderId (optional)
    *  * @param createPayment createPayment 
    *  * @return PaymentResult
    */
  suspend fun createPaymentOnOrder(orderId: Long, createPayment: CreatePayment? = null) : PaymentResult
  
  /**
    *  Asynchronous implementation of Create a Payment
    *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
    *  * @param orderId orderId (optional)
    *  * @param createPayment createPayment 
    *  * @return A deferred reference to the final PaymentResult  
    */
  fun createPaymentOnOrderAsync(orderId: Long, createPayment: CreatePayment? = null) : Deferred<PaymentResult>

  /**
    *  Delete an Order
    *  Delete an order that does not have a payment
    *  * @param orderId orderId (optional)
    *  * @return void
    */
  suspend fun deleteOrder(orderId: Long)
  
  /**
    *  Asynchronous implementation of Delete an Order
    *  Delete an order that does not have a payment
    *  * @param orderId orderId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteOrderAsync(orderId: Long) : Deferred<Unit>

  /**
    *  Delete an Order Item
    *  Delete an order Item on specified Order
    *  * @param orderId orderId (optional)
    *  * @param orderItemId orderItemId (optional)
    *  * @return void
    */
  suspend fun deleteOrderOrderItem(orderId: Long, orderItemId: Long)
  
  /**
    *  Asynchronous implementation of Delete an Order Item
    *  Delete an order Item on specified Order
    *  * @param orderId orderId (optional)
    *  * @param orderItemId orderItemId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteOrderOrderItemAsync(orderId: Long, orderItemId: Long) : Deferred<Unit>

  /**
    *  Retrieve an Order
    *  Retrieves a single order. The order may or may not have items.
    *  * @param orderId orderId (optional)
    *  * @return Order
    */
  suspend fun getOrder(orderId: Long) : Order
  
  /**
    *  Asynchronous implementation of Retrieve an Order
    *  Retrieves a single order. The order may or may not have items.
    *  * @param orderId orderId (optional)
    *  * @return A deferred reference to the final Order  
    */
  fun getOrderAsync(orderId: Long) : Deferred<Order>

  /**
    *  Retrieve a Transaction
    *  Retrieves a single transaction
    *  * @param transactionId transactionId (optional)
    *  * @return Transaction
    */
  suspend fun getTransaction(transactionId: Long) : Transaction
  
  /**
    *  Asynchronous implementation of Retrieve a Transaction
    *  Retrieves a single transaction
    *  * @param transactionId transactionId (optional)
    *  * @return A deferred reference to the final Transaction  
    */
  fun getTransactionAsync(transactionId: Long) : Deferred<Transaction>

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
  suspend fun listOrders(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, paid: Boolean? = null, order: String? = null, contactId: Long? = null, productId: Long? = null) : OrderList
  
  /**
    *  Asynchronous implementation of List Orders
    *  Retrieves a list of all orders using the specified search criteria. Each order may or may not have items.
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param paid Sets paid status of items to return 
    *  * @param order Attribute to order items by 
    *  * @param contactId Returns orders for the provided contact id 
    *  * @param productId Returns orders containing the provided product id 
    *  * @return A deferred reference to the final OrderList  
    */
  fun listOrdersAsync(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, paid: Boolean? = null, order: String? = null, contactId: Long? = null, productId: Long? = null) : Deferred<OrderList>

  /**
    *  List Subscriptions
    *  Retrieves a list of all subcriptions using the specified search criteria.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns subscriptions for the provided contact id 
    *  * @return SubscriptionList
    */
  suspend fun listSubscriptions(limit: Int? = null, offset: Int? = null, contactId: Long? = null) : SubscriptionList
  
  /**
    *  Asynchronous implementation of List Subscriptions
    *  Retrieves a list of all subcriptions using the specified search criteria.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns subscriptions for the provided contact id 
    *  * @return A deferred reference to the final SubscriptionList  
    */
  fun listSubscriptionsAsync(limit: Int? = null, offset: Int? = null, contactId: Long? = null) : Deferred<SubscriptionList>

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
  suspend fun listTransactions(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : TransactionList
  
  /**
    *  Asynchronous implementation of List Transactions
    *  Retrieves a list transactions for a given contact
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return A deferred reference to the final TransactionList  
    */
  fun listTransactionsAsync(since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : Deferred<TransactionList>

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
  suspend fun listTransactionsForOrder(orderId: Long, since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : TransactionList
  
  /**
    *  Asynchronous implementation of Retrieve Order Transactions
    *  Retrieves a list of all transactions on a given order using the specified search criteria
    *  * @param orderId orderId (optional)
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return A deferred reference to the final TransactionList  
    */
  fun listTransactionsForOrderAsync(orderId: Long, since: String? = null, until: String? = null, limit: Int? = null, offset: Int? = null, contactId: Long? = null) : Deferred<TransactionList>

  /**
    *  Replace an Order Pay Plan
    *  Replaces the order's payment plan with the given values.
    *  * @param orderId orderId (optional)
    *  * @param paymentPlan paymentPlan (optional)
    *  * @return PaymentPlan
    */
  suspend fun replacePaymentPlan(orderId: Long, paymentPlan: PaymentPlan) : PaymentPlan
  
  /**
    *  Asynchronous implementation of Replace an Order Pay Plan
    *  Replaces the order's payment plan with the given values.
    *  * @param orderId orderId (optional)
    *  * @param paymentPlan paymentPlan (optional)
    *  * @return A deferred reference to the final PaymentPlan  
    */
  fun replacePaymentPlanAsync(orderId: Long, paymentPlan: PaymentPlan) : Deferred<PaymentPlan>

  /**
    *  Retrieve Custom Order Model
    *  Get the custom fields for the Order object
    *  * @return ObjectModel
    */
  suspend fun retrieveOrderModel() : ObjectModel
  
  /**
    *  Asynchronous implementation of Retrieve Custom Order Model
    *  Get the custom fields for the Order object
    *  * @return A deferred reference to the final ObjectModel  
    */
  fun retrieveOrderModelAsync() : Deferred<ObjectModel>

  /**
    *  Retrieve Subscription Model
    *  Get the custom fields for the Subscription object
    *  * @return ObjectModel
    */
  suspend fun retrieveSubscriptionModel() : ObjectModel
  
  /**
    *  Asynchronous implementation of Retrieve Subscription Model
    *  Get the custom fields for the Subscription object
    *  * @return A deferred reference to the final ObjectModel  
    */
  fun retrieveSubscriptionModelAsync() : Deferred<ObjectModel>

}

class ECommerceApiImpl(bearerToken:String, basePath: String, gson: Gson) : ECommerceApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create an Order
    *  Create a one time order with order items.
    *  * @param createOrder createOrder (optional)
    *  * @return Order
    */
  override suspend fun createOrder(createOrder: CreateOrder) : Order {
    val uri = uriTemplate("/orders")
      .build()
    val call = post(uri) {
      body = createOrder ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create an Order
    *  Create a one time order with order items.
    *  * @param createOrder createOrder (optional)
    *  * @return A deferred reference to the final Order  
    */
  override fun createOrderAsync(createOrder: CreateOrder)  = 
        client.async { createOrder(createOrder) }

  /**
    *  Create an Order Item
    *  Creates an order item on an existing order.
    *  * @param createOrderItem createOrderItem (optional)
    *  * @param orderId orderId (optional)
    *  * @return OrderItem
    */
  override suspend fun createOrderItemsOnOrder(createOrderItem: CreateOrderItem, orderId: Long) : OrderItem {
    val uri = uriTemplate("/orders/{orderId}/items")
      .parameter("orderId", orderId)
      .build()
    val call = post(uri) {
      body = createOrderItem ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create an Order Item
    *  Creates an order item on an existing order.
    *  * @param createOrderItem createOrderItem (optional)
    *  * @param orderId orderId (optional)
    *  * @return A deferred reference to the final OrderItem  
    */
  override fun createOrderItemsOnOrderAsync(createOrderItem: CreateOrderItem, orderId: Long)  = 
        client.async { createOrderItemsOnOrder(createOrderItem, orderId) }

  /**
    *  Create a Payment
    *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
    *  * @param orderId orderId (optional)
    *  * @param createPayment createPayment 
    *  * @return PaymentResult
    */
  override suspend fun createPaymentOnOrder(orderId: Long, createPayment: CreatePayment?) : PaymentResult {
    val uri = uriTemplate("/orders/{orderId}/payments")
      .parameter("orderId", orderId)
      .build()
    val call = post(uri) {
      body = createPayment ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Payment
    *  Creates a payment record that can charge a credit card. Alternatively, adds a record of historical or external payment of cash or credit card.
    *  * @param orderId orderId (optional)
    *  * @param createPayment createPayment 
    *  * @return A deferred reference to the final PaymentResult  
    */
  override fun createPaymentOnOrderAsync(orderId: Long, createPayment: CreatePayment?)  = 
        client.async { createPaymentOnOrder(orderId, createPayment) }

  /**
    *  Delete an Order
    *  Delete an order that does not have a payment
    *  * @param orderId orderId (optional)
    *  * @return void
    */
  override suspend fun deleteOrder(orderId: Long) {
    val uri = uriTemplate("/orders/{orderId}")
      .parameter("orderId", orderId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete an Order
    *  Delete an order that does not have a payment
    *  * @param orderId orderId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteOrderAsync(orderId: Long)  = 
        client.async { deleteOrder(orderId) }

  /**
    *  Delete an Order Item
    *  Delete an order Item on specified Order
    *  * @param orderId orderId (optional)
    *  * @param orderItemId orderItemId (optional)
    *  * @return void
    */
  override suspend fun deleteOrderOrderItem(orderId: Long, orderItemId: Long) {
    val uri = uriTemplate("/orders/{orderId}/items/{orderItemId}")
      .parameter("orderId", orderId)
      .parameter("orderItemId", orderItemId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete an Order Item
    *  Delete an order Item on specified Order
    *  * @param orderId orderId (optional)
    *  * @param orderItemId orderItemId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteOrderOrderItemAsync(orderId: Long, orderItemId: Long)  = 
        client.async { deleteOrderOrderItem(orderId, orderItemId) }

  /**
    *  Retrieve an Order
    *  Retrieves a single order. The order may or may not have items.
    *  * @param orderId orderId (optional)
    *  * @return Order
    */
  override suspend fun getOrder(orderId: Long) : Order {
    val uri = uriTemplate("/orders/{orderId}")
      .parameter("orderId", orderId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve an Order
    *  Retrieves a single order. The order may or may not have items.
    *  * @param orderId orderId (optional)
    *  * @return A deferred reference to the final Order  
    */
  override fun getOrderAsync(orderId: Long)  = 
        client.async { getOrder(orderId) }

  /**
    *  Retrieve a Transaction
    *  Retrieves a single transaction
    *  * @param transactionId transactionId (optional)
    *  * @return Transaction
    */
  override suspend fun getTransaction(transactionId: Long) : Transaction {
    val uri = uriTemplate("/transactions/{transactionId}")
      .parameter("transactionId", transactionId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Transaction
    *  Retrieves a single transaction
    *  * @param transactionId transactionId (optional)
    *  * @return A deferred reference to the final Transaction  
    */
  override fun getTransactionAsync(transactionId: Long)  = 
        client.async { getTransaction(transactionId) }

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
  override suspend fun listOrders(since: String?, until: String?, limit: Int?, offset: Int?, paid: Boolean?, order: String?, contactId: Long?, productId: Long?) : OrderList {
    val uri = uriTemplate("/orders")
      .build()
    val call = get(uri) {
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("paid",  paid)
      queryParam("order",  order)
      queryParam("contact_id",  contactId)
      queryParam("product_id",  productId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Orders
    *  Retrieves a list of all orders using the specified search criteria. Each order may or may not have items.
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param paid Sets paid status of items to return 
    *  * @param order Attribute to order items by 
    *  * @param contactId Returns orders for the provided contact id 
    *  * @param productId Returns orders containing the provided product id 
    *  * @return A deferred reference to the final OrderList  
    */
  override fun listOrdersAsync(since: String?, until: String?, limit: Int?, offset: Int?, paid: Boolean?, order: String?, contactId: Long?, productId: Long?)  = 
        client.async { listOrders(since, until, limit, offset, paid, order, contactId, productId) }

  /**
    *  List Subscriptions
    *  Retrieves a list of all subcriptions using the specified search criteria.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns subscriptions for the provided contact id 
    *  * @return SubscriptionList
    */
  override suspend fun listSubscriptions(limit: Int?, offset: Int?, contactId: Long?) : SubscriptionList {
    val uri = uriTemplate("/subscriptions")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("contact_id",  contactId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Subscriptions
    *  Retrieves a list of all subcriptions using the specified search criteria.
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns subscriptions for the provided contact id 
    *  * @return A deferred reference to the final SubscriptionList  
    */
  override fun listSubscriptionsAsync(limit: Int?, offset: Int?, contactId: Long?)  = 
        client.async { listSubscriptions(limit, offset, contactId) }

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
  override suspend fun listTransactions(since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?) : TransactionList {
    val uri = uriTemplate("/transactions")
      .build()
    val call = get(uri) {
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("contact_id",  contactId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Transactions
    *  Retrieves a list transactions for a given contact
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return A deferred reference to the final TransactionList  
    */
  override fun listTransactionsAsync(since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?)  = 
        client.async { listTransactions(since, until, limit, offset, contactId) }

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
  override suspend fun listTransactionsForOrder(orderId: Long, since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?) : TransactionList {
    val uri = uriTemplate("/orders/{orderId}/transactions")
      .parameter("orderId", orderId)
      .build()
    val call = get(uri) {
      queryParam("since",  since)
      queryParam("until",  until)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("contact_id",  contactId)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Order Transactions
    *  Retrieves a list of all transactions on a given order using the specified search criteria
    *  * @param orderId orderId (optional)
    *  * @param since Date to start searching from ex. `2017-01-01T22:17:59.039Z` 
    *  * @param until Date to search to ex. `2017-01-01T22:17:59.039Z` 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param contactId Returns transactions for the provided contact id 
    *  * @return A deferred reference to the final TransactionList  
    */
  override fun listTransactionsForOrderAsync(orderId: Long, since: String?, until: String?, limit: Int?, offset: Int?, contactId: Long?)  = 
        client.async { listTransactionsForOrder(orderId, since, until, limit, offset, contactId) }

  /**
    *  Replace an Order Pay Plan
    *  Replaces the order's payment plan with the given values.
    *  * @param orderId orderId (optional)
    *  * @param paymentPlan paymentPlan (optional)
    *  * @return PaymentPlan
    */
  override suspend fun replacePaymentPlan(orderId: Long, paymentPlan: PaymentPlan) : PaymentPlan {
    val uri = uriTemplate("/orders/{orderId}/paymentPlan")
      .parameter("orderId", orderId)
      .build()
    val call = put(uri) {
      body = paymentPlan ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Replace an Order Pay Plan
    *  Replaces the order's payment plan with the given values.
    *  * @param orderId orderId (optional)
    *  * @param paymentPlan paymentPlan (optional)
    *  * @return A deferred reference to the final PaymentPlan  
    */
  override fun replacePaymentPlanAsync(orderId: Long, paymentPlan: PaymentPlan)  = 
        client.async { replacePaymentPlan(orderId, paymentPlan) }

  /**
    *  Retrieve Custom Order Model
    *  Get the custom fields for the Order object
    *  * @return ObjectModel
    */
  override suspend fun retrieveOrderModel() : ObjectModel {
    val uri = uriTemplate("/orders/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Custom Order Model
    *  Get the custom fields for the Order object
    *  * @return A deferred reference to the final ObjectModel  
    */
  override fun retrieveOrderModelAsync()  = 
        client.async { retrieveOrderModel() }

  /**
    *  Retrieve Subscription Model
    *  Get the custom fields for the Subscription object
    *  * @return ObjectModel
    */
  override suspend fun retrieveSubscriptionModel() : ObjectModel {
    val uri = uriTemplate("/subscriptions/model")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Subscription Model
    *  Get the custom fields for the Subscription object
    *  * @return A deferred reference to the final ObjectModel  
    */
  override fun retrieveSubscriptionModelAsync()  = 
        client.async { retrieveSubscriptionModel() }

}
   

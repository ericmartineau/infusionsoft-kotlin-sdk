@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestHook
import io.mverse.client.infusionsoft.models.RestHookRequest


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


interface RESTHooksApi {

  /**
    *  Create a Hook Subscription
    *  To receive hooks, you'll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return RestHook
    */
  suspend fun createAHookSubscription(restHookRequest: RestHookRequest) : RestHook
  
  /**
    *  Asynchronous implementation of Create a Hook Subscription
    *  To receive hooks, you'll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  fun createAHookSubscriptionAsync(restHookRequest: RestHookRequest) : Deferred<RestHook>

  /**
    *  Delete a Hook Subscription
    *  Stop receiving hooks by deleting an existing hook subscription.
    *  * @param key key (optional)
    *  * @return void
    */
  suspend fun deleteAHookSubscription(key: String)
  
  /**
    *  Asynchronous implementation of Delete a Hook Subscription
    *  Stop receiving hooks by deleting an existing hook subscription.
    *  * @param key key (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteAHookSubscriptionAsync(key: String) : Deferred<Unit>

  /**
    *  List Hook Event Types
    *  ### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn't have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: `contact.add` or `invoice.delete`.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you've chosen the events you're interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).
    *  * @return List<String>
    */
  suspend fun listHookEventTypes() : List<String>
  
  /**
    *  Asynchronous implementation of List Hook Event Types
    *  ### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn't have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: `contact.add` or `invoice.delete`.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you've chosen the events you're interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).
    *  * @return A deferred reference to the final List<String>  
    */
  fun listHookEventTypesAsync() : Deferred<List<String>>

  /**
    *  List Stored Hook Subscriptions
    *  Lists your hook subscriptions.
    *  * @return List<RestHook>
    */
  suspend fun listStoredHookSubscriptions() : List<RestHook>
  
  /**
    *  Asynchronous implementation of List Stored Hook Subscriptions
    *  Lists your hook subscriptions.
    *  * @return A deferred reference to the final List<RestHook>  
    */
  fun listStoredHookSubscriptionsAsync() : Deferred<List<RestHook>>

  /**
    *  Retrieve a Hook Subscription
    *  Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).
    *  * @param key key (optional)
    *  * @return RestHook
    */
  suspend fun retrieveAHookSubscription(key: String) : RestHook
  
  /**
    *  Asynchronous implementation of Retrieve a Hook Subscription
    *  Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).
    *  * @param key key (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  fun retrieveAHookSubscriptionAsync(key: String) : Deferred<RestHook>

  /**
    *  Update a Hook Subscription
    *  Modify an existing hook subscription using the provided values.
    *  * @param key key (optional)
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return RestHook
    */
  suspend fun updateAHookSubscription(key: String, restHookRequest: RestHookRequest) : RestHook
  
  /**
    *  Asynchronous implementation of Update a Hook Subscription
    *  Modify an existing hook subscription using the provided values.
    *  * @param key key (optional)
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  fun updateAHookSubscriptionAsync(key: String, restHookRequest: RestHookRequest) : Deferred<RestHook>

  /**
    *  Verify a Hook Subscription
    *  This operation is used to verify or reactivate a hook subscription using RESTHooks.org's [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @return RestHook
    */
  suspend fun verifyAHookSubscription(key: String) : RestHook
  
  /**
    *  Asynchronous implementation of Verify a Hook Subscription
    *  This operation is used to verify or reactivate a hook subscription using RESTHooks.org's [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  fun verifyAHookSubscriptionAsync(key: String) : Deferred<RestHook>

  /**
    *  Verify a Hook Subscription, Delayed
    *  This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org's [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you're not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the `X-Hook-Secret` you received.  NB: **The `X-Hook-Secret` _must_ be passed as a _header_.**  Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @param xHookSecret X-Hook-Secret (optional)
    *  * @return RestHook
    */
  suspend fun verifyAHookSubscriptionDelayed(key: String, xHookSecret: String) : RestHook
  
  /**
    *  Asynchronous implementation of Verify a Hook Subscription, Delayed
    *  This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org's [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you're not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the `X-Hook-Secret` you received.  NB: **The `X-Hook-Secret` _must_ be passed as a _header_.**  Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @param xHookSecret X-Hook-Secret (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  fun verifyAHookSubscriptionDelayedAsync(key: String, xHookSecret: String) : Deferred<RestHook>

}

class RESTHooksApiImpl(bearerToken:String, basePath: String, gson: Gson) : RESTHooksApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Hook Subscription
    *  To receive hooks, you'll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return RestHook
    */
  override suspend fun createAHookSubscription(restHookRequest: RestHookRequest) : RestHook {
    val uri = uriTemplate("/hooks")
      .build()
    val call = post(uri) {
      body = restHookRequest ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Hook Subscription
    *  To receive hooks, you'll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  override fun createAHookSubscriptionAsync(restHookRequest: RestHookRequest)  = 
        client.async { createAHookSubscription(restHookRequest) }

  /**
    *  Delete a Hook Subscription
    *  Stop receiving hooks by deleting an existing hook subscription.
    *  * @param key key (optional)
    *  * @return void
    */
  override suspend fun deleteAHookSubscription(key: String) {
    val uri = uriTemplate("/hooks/{key}")
      .parameter("key", key)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete a Hook Subscription
    *  Stop receiving hooks by deleting an existing hook subscription.
    *  * @param key key (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteAHookSubscriptionAsync(key: String)  = 
        client.async { deleteAHookSubscription(key) }

  /**
    *  List Hook Event Types
    *  ### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn't have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: `contact.add` or `invoice.delete`.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you've chosen the events you're interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).
    *  * @return List<String>
    */
  override suspend fun listHookEventTypes() : List<String> {
    val uri = uriTemplate("/hooks/event_keys")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Hook Event Types
    *  ### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn't have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: `contact.add` or `invoice.delete`.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you've chosen the events you're interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).
    *  * @return A deferred reference to the final List<String>  
    */
  override fun listHookEventTypesAsync()  = 
        client.async { listHookEventTypes() }

  /**
    *  List Stored Hook Subscriptions
    *  Lists your hook subscriptions.
    *  * @return List<RestHook>
    */
  override suspend fun listStoredHookSubscriptions() : List<RestHook> {
    val uri = uriTemplate("/hooks")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Stored Hook Subscriptions
    *  Lists your hook subscriptions.
    *  * @return A deferred reference to the final List<RestHook>  
    */
  override fun listStoredHookSubscriptionsAsync()  = 
        client.async { listStoredHookSubscriptions() }

  /**
    *  Retrieve a Hook Subscription
    *  Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).
    *  * @param key key (optional)
    *  * @return RestHook
    */
  override suspend fun retrieveAHookSubscription(key: String) : RestHook {
    val uri = uriTemplate("/hooks/{key}")
      .parameter("key", key)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Hook Subscription
    *  Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).
    *  * @param key key (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  override fun retrieveAHookSubscriptionAsync(key: String)  = 
        client.async { retrieveAHookSubscription(key) }

  /**
    *  Update a Hook Subscription
    *  Modify an existing hook subscription using the provided values.
    *  * @param key key (optional)
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return RestHook
    */
  override suspend fun updateAHookSubscription(key: String, restHookRequest: RestHookRequest) : RestHook {
    val uri = uriTemplate("/hooks/{key}")
      .parameter("key", key)
      .build()
    val call = put(uri) {
      body = restHookRequest ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Update a Hook Subscription
    *  Modify an existing hook subscription using the provided values.
    *  * @param key key (optional)
    *  * @param restHookRequest restHookRequest (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  override fun updateAHookSubscriptionAsync(key: String, restHookRequest: RestHookRequest)  = 
        client.async { updateAHookSubscription(key, restHookRequest) }

  /**
    *  Verify a Hook Subscription
    *  This operation is used to verify or reactivate a hook subscription using RESTHooks.org's [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @return RestHook
    */
  override suspend fun verifyAHookSubscription(key: String) : RestHook {
    val uri = uriTemplate("/hooks/{key}/verify")
      .parameter("key", key)
      .build()
    val call = post(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Verify a Hook Subscription
    *  This operation is used to verify or reactivate a hook subscription using RESTHooks.org's [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a `POST` request with a temporary secret to the `hookUrl` you provided during creation. The secret is passed as the value of a header named `X-Hook-Secret`. Your response to that `POST` *must* have a status code of `200` and return the same `X-Hook-Secret` header and value pair. Once you've done that, you'll begin receiving hooks. Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  override fun verifyAHookSubscriptionAsync(key: String)  = 
        client.async { verifyAHookSubscription(key) }

  /**
    *  Verify a Hook Subscription, Delayed
    *  This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org's [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you're not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the `X-Hook-Secret` you received.  NB: **The `X-Hook-Secret` _must_ be passed as a _header_.**  Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @param xHookSecret X-Hook-Secret (optional)
    *  * @return RestHook
    */
  override suspend fun verifyAHookSubscriptionDelayed(key: String, xHookSecret: String) : RestHook {
    val uri = uriTemplate("/hooks/{key}/delayedVerify")
      .parameter("key", key)
      .build()
    val call = post(uri) {
      header("X-Hook-Secret", xHookSecret)
    
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Verify a Hook Subscription, Delayed
    *  This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org's [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you're not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the `X-Hook-Secret` you received.  NB: **The `X-Hook-Secret` _must_ be passed as a _header_.**  Don't worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
    *  * @param key key (optional)
    *  * @param xHookSecret X-Hook-Secret (optional)
    *  * @return A deferred reference to the final RestHook  
    */
  override fun verifyAHookSubscriptionDelayedAsync(key: String, xHookSecret: String)  = 
        client.async { verifyAHookSubscriptionDelayed(key, xHookSecret) }

}
   

/**
* Infusionsoft REST API
* No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
*
* OpenAPI spec version: 1.70.0.78606
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.RestHook
import io.mverse.client.infusionsoft.models.RestHookRequest

import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

    interface RESTHooksApi {

        /**
        *  Create a Hook Subscription
        *  To receive hooks, you&#39;ll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a &#x60;POST&#x60; request with a temporary secret to the &#x60;hookUrl&#x60; you provided during creation. The secret is passed as the value of a header named &#x60;X-Hook-Secret&#x60;. Your response to that &#x60;POST&#x60; *must* have a status code of &#x60;200&#x60; and return the same &#x60;X-Hook-Secret&#x60; header and value pair. Once you&#39;ve done that, you&#39;ll begin receiving hooks. Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
        *  * @param restHookRequest restHookRequest 
        *  * @return RestHook
        */
        fun createAHookSubscription(restHookRequest: RestHookRequest) : RestHook
        /**
        *  Delete a Hook Subscription
        *  Stop receiving hooks by deleting an existing hook subscription.
        *  * @param key key 
        *  * @return void
        */
        fun deleteAHookSubscription(key: String) : Unit
        /**
        *  List Hook Event Types
        *  ### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn&#39;t have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: &#x60;contact.add&#x60; or &#x60;invoice.delete&#x60;.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you&#39;ve chosen the events you&#39;re interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).
        *  * @return List<String>
        */
        fun listHookEventTypes() : List<String>
        /**
        *  List Stored Hook Subscriptions
        *  Lists your hook subscriptions.
        *  * @return List<RestHook>
        */
        fun listStoredHookSubscriptions() : List<RestHook>
        /**
        *  Retrieve a Hook Subscription
        *  Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).
        *  * @param key key 
        *  * @return RestHook
        */
        fun retrieveAHookSubscription(key: String) : RestHook
        /**
        *  Update a Hook Subscription
        *  Modify an existing hook subscription using the provided values.
        *  * @param key key 
        *  * @param restHookRequest restHookRequest 
        *  * @return RestHook
        */
        fun updateAHookSubscription(key: String, restHookRequest: RestHookRequest) : RestHook
        /**
        *  Verify a Hook Subscription
        *  This operation is used to verify or reactivate a hook subscription using RESTHooks.org&#39;s [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a &#x60;POST&#x60; request with a temporary secret to the &#x60;hookUrl&#x60; you provided during creation. The secret is passed as the value of a header named &#x60;X-Hook-Secret&#x60;. Your response to that &#x60;POST&#x60; *must* have a status code of &#x60;200&#x60; and return the same &#x60;X-Hook-Secret&#x60; header and value pair. Once you&#39;ve done that, you&#39;ll begin receiving hooks. Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
        *  * @param key key 
        *  * @return RestHook
        */
        fun verifyAHookSubscription(key: String) : RestHook
        /**
        *  Verify a Hook Subscription, Delayed
        *  This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org&#39;s [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you&#39;re not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the &#x60;X-Hook-Secret&#x60; you received.  NB: **The &#x60;X-Hook-Secret&#x60; _must_ be passed as a _header_.**  Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
        *  * @param key key 
        *  * @param xHookSecret X-Hook-Secret 
        *  * @return RestHook
        */
        fun verifyAHookSubscriptionDelayed(key: String, xHookSecret: String) : RestHook
    }

class RESTHooksApiImpl(bearerToken:String, basePath: String, gson: Gson) : RESTHooksApi, ApiClient(basePath, bearerToken, gson) {

  /**
   *  Create a Hook Subscription
   *  To receive hooks, you&#39;ll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a &#x60;POST&#x60; request with a temporary secret to the &#x60;hookUrl&#x60; you provided during creation. The secret is passed as the value of a header named &#x60;X-Hook-Secret&#x60;. Your response to that &#x60;POST&#x60; *must* have a status code of &#x60;200&#x60; and return the same &#x60;X-Hook-Secret&#x60; header and value pair. Once you&#39;ve done that, you&#39;ll begin receiving hooks. Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
   *  * @param restHookRequest restHookRequest 
   *  * @return RestHook
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun createAHookSubscription(restHookRequest: RestHookRequest) : RestHook {
    val requestBody = restHookRequest
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/hooks",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<RestHook>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Delete a Hook Subscription
   *  Stop receiving hooks by deleting an existing hook subscription.
   *  * @param key key 
   *  * @return void
   */ 
  override fun deleteAHookSubscription(key: String) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/hooks/{key}".replace("{"+"key"+"}", "$key"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<Unit>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Hook Event Types
   *  ### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn&#39;t have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: &#x60;contact.add&#x60; or &#x60;invoice.delete&#x60;.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you&#39;ve chosen the events you&#39;re interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).
   *  * @return List<String>
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun listHookEventTypes() : List<String> {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/hooks/event_keys",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<List<String>>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  List Stored Hook Subscriptions
   *  Lists your hook subscriptions.
   *  * @return List<RestHook>
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun listStoredHookSubscriptions() : List<RestHook> {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/hooks",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<List<RestHook>>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve a Hook Subscription
   *  Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).
   *  * @param key key 
   *  * @return RestHook
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun retrieveAHookSubscription(key: String) : RestHook {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/hooks/{key}".replace("{"+"key"+"}", "$key"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<RestHook>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Update a Hook Subscription
   *  Modify an existing hook subscription using the provided values.
   *  * @param key key 
   *  * @param restHookRequest restHookRequest 
   *  * @return RestHook
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun updateAHookSubscription(key: String, restHookRequest: RestHookRequest) : RestHook {
    val requestBody = restHookRequest
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.PUT,
       "/hooks/{key}".replace("{"+"key"+"}", "$key"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<RestHook>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Verify a Hook Subscription
   *  This operation is used to verify or reactivate a hook subscription using RESTHooks.org&#39;s [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a &#x60;POST&#x60; request with a temporary secret to the &#x60;hookUrl&#x60; you provided during creation. The secret is passed as the value of a header named &#x60;X-Hook-Secret&#x60;. Your response to that &#x60;POST&#x60; *must* have a status code of &#x60;200&#x60; and return the same &#x60;X-Hook-Secret&#x60; header and value pair. Once you&#39;ve done that, you&#39;ll begin receiving hooks. Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
   *  * @param key key 
   *  * @return RestHook
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun verifyAHookSubscription(key: String) : RestHook {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/hooks/{key}/verify".replace("{"+"key"+"}", "$key"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<RestHook>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Verify a Hook Subscription, Delayed
   *  This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org&#39;s [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you&#39;re not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the &#x60;X-Hook-Secret&#x60; you received.  NB: **The &#x60;X-Hook-Secret&#x60; _must_ be passed as a _header_.**  Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.
   *  * @param key key 
   *  * @param xHookSecret X-Hook-Secret 
   *  * @return RestHook
   */ 
  @Suppress("UNCHECKED_CAST")
  override fun verifyAHookSubscriptionDelayed(key: String, xHookSecret: String) : RestHook {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf("X-Hook-Secret" to xHookSecret)
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/hooks/{key}/delayedVerify".replace("{"+"key"+"}", "$key"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(localVariableConfig, requestBody)

    return when (response) {
      is Success -> gson.fromJson(response.data, object : TypeToken<RestHook>() {}.type)
      is Informational -> TODO()
      is Redirection -> TODO()
      is ClientError -> throw ClientException(response.body as? String ?: "Client error")
      is ServerError -> throw ServerException(response.message ?: "Server error")
      else -> throw IllegalStateException("Undefined ResponseType.")
    }
  }
}


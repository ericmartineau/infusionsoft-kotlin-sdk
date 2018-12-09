# RESTHooksApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAHookSubscription**](RESTHooksApi.md#createAHookSubscription) | **POST** /hooks | Create a Hook Subscription
[**deleteAHookSubscription**](RESTHooksApi.md#deleteAHookSubscription) | **DELETE** /hooks/{key} | Delete a Hook Subscription
[**listHookEventTypes**](RESTHooksApi.md#listHookEventTypes) | **GET** /hooks/event_keys | List Hook Event Types
[**listStoredHookSubscriptions**](RESTHooksApi.md#listStoredHookSubscriptions) | **GET** /hooks | List Stored Hook Subscriptions
[**retrieveAHookSubscription**](RESTHooksApi.md#retrieveAHookSubscription) | **GET** /hooks/{key} | Retrieve a Hook Subscription
[**updateAHookSubscription**](RESTHooksApi.md#updateAHookSubscription) | **PUT** /hooks/{key} | Update a Hook Subscription
[**verifyAHookSubscription**](RESTHooksApi.md#verifyAHookSubscription) | **POST** /hooks/{key}/verify | Verify a Hook Subscription
[**verifyAHookSubscriptionDelayed**](RESTHooksApi.md#verifyAHookSubscriptionDelayed) | **POST** /hooks/{key}/delayedVerify | Verify a Hook Subscription, Delayed


<a name="createAHookSubscription"></a>
# **createAHookSubscription**
> RestHook createAHookSubscription(restHookRequest)

Create a Hook Subscription

To receive hooks, you&#39;ll first need to subscribe to events one at a time *and* individually verify each subscription.  This operation is used to create hook subscriptions. During this process, Infusionsoft will attempt to verify your subscription. Continue reading to learn how that works.  To verify or reactivate a hook subscription, Infusionsoft will make a &#x60;POST&#x60; request with a temporary secret to the &#x60;hookUrl&#x60; you provided during creation. The secret is passed as the value of a header named &#x60;X-Hook-Secret&#x60;. Your response to that &#x60;POST&#x60; *must* have a status code of &#x60;200&#x60; and return the same &#x60;X-Hook-Secret&#x60; header and value pair. Once you&#39;ve done that, you&#39;ll begin receiving hooks. Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
val restHookRequest : RestHookRequest =  // RestHookRequest | restHookRequest
try {
    val result : RestHook = apiInstance.createAHookSubscription(restHookRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#createAHookSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#createAHookSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **restHookRequest** | [**RestHookRequest**](RestHookRequest.md)| restHookRequest |

### Return type

[**RestHook**](RestHook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAHookSubscription"></a>
# **deleteAHookSubscription**
> deleteAHookSubscription(key)

Delete a Hook Subscription

Stop receiving hooks by deleting an existing hook subscription.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
val key : String = key_example // String | key
try {
    apiInstance.deleteAHookSubscription(key)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#deleteAHookSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#deleteAHookSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| key |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listHookEventTypes"></a>
# **listHookEventTypes**
> List&lt;String&gt; listHookEventTypes()

List Hook Event Types

### _What are REST Hooks?_  _REST Hooks itself is not a specification, it is a collection of patterns that treat webhooks like subscriptions. These subscriptions are manipulated via a REST API just like any other resource._  _With most modern REST APIs, polling is the only way to detect changes. But it doesn&#39;t have to be. On average, 98.5% of polls are wasted. There is a better way. REST Hooks enable real-time communication and eliminate polling._ -- [RESTHooks.org](http://RESTHooks.org)  Infusionsoft offers a growing set of REST Hooks to keep you notified of changes in your data. To get started, use [List Hook Event Types](#!/REST_Hooks/list_hook_event_types) to discover event types. Event types are identified using _noun.verb dot syntax_, e.g.: &#x60;contact.add&#x60; or &#x60;invoice.delete&#x60;.  After you’ve read this documentation, you might be interested in the [REST Hook Event and Retry policies](https://developer.infusionsoft.com/rest-hook-documentation/).  NB: REST Hooks are **not** triggered by legacy action sets.  Once you&#39;ve chosen the events you&#39;re interested in, subscribe to them via [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription).

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
try {
    val result : List<String> = apiInstance.listHookEventTypes()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#listHookEventTypes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#listHookEventTypes")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listStoredHookSubscriptions"></a>
# **listStoredHookSubscriptions**
> List&lt;RestHook&gt; listStoredHookSubscriptions()

List Stored Hook Subscriptions

Lists your hook subscriptions.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
try {
    val result : List<RestHook> = apiInstance.listStoredHookSubscriptions()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#listStoredHookSubscriptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#listStoredHookSubscriptions")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;RestHook&gt;**](RestHook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveAHookSubscription"></a>
# **retrieveAHookSubscription**
> RestHook retrieveAHookSubscription(key)

Retrieve a Hook Subscription

Retrieves an existing hook subscription and its status.  If your hook subscription becomes inactive, you may request an activation attempt via [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription).

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
val key : String = key_example // String | key
try {
    val result : RestHook = apiInstance.retrieveAHookSubscription(key)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#retrieveAHookSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#retrieveAHookSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| key |

### Return type

[**RestHook**](RestHook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAHookSubscription"></a>
# **updateAHookSubscription**
> RestHook updateAHookSubscription(key, restHookRequest)

Update a Hook Subscription

Modify an existing hook subscription using the provided values.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
val key : String = key_example // String | key
val restHookRequest : RestHookRequest =  // RestHookRequest | restHookRequest
try {
    val result : RestHook = apiInstance.updateAHookSubscription(key, restHookRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#updateAHookSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#updateAHookSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| key |
 **restHookRequest** | [**RestHookRequest**](RestHookRequest.md)| restHookRequest |

### Return type

[**RestHook**](RestHook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="verifyAHookSubscription"></a>
# **verifyAHookSubscription**
> RestHook verifyAHookSubscription(key)

Verify a Hook Subscription

This operation is used to verify or reactivate a hook subscription using RESTHooks.org&#39;s [Immediate Confirmation](http://resthooks.org/docs/security/) pattern.  To verify or reactivate a hook subscription, Infusionsoft will make a &#x60;POST&#x60; request with a temporary secret to the &#x60;hookUrl&#x60; you provided during creation. The secret is passed as the value of a header named &#x60;X-Hook-Secret&#x60;. Your response to that &#x60;POST&#x60; *must* have a status code of &#x60;200&#x60; and return the same &#x60;X-Hook-Secret&#x60; header and value pair. Once you&#39;ve done that, you&#39;ll begin receiving hooks. Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
val key : String = key_example // String | key
try {
    val result : RestHook = apiInstance.verifyAHookSubscription(key)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#verifyAHookSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#verifyAHookSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| key |

### Return type

[**RestHook**](RestHook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="verifyAHookSubscriptionDelayed"></a>
# **verifyAHookSubscriptionDelayed**
> RestHook verifyAHookSubscriptionDelayed(key, xHookSecret)

Verify a Hook Subscription, Delayed

This operation is used to verify or reactivate a hook subscription out-of-band using RESTHooks.org&#39;s [Delayed Confirmation](http://resthooks.org/docs/security/) pattern.  Use this verification method if you&#39;re not able to use the Immediate Confirmation provided through [Create a Hook Subscription](#!/REST_Hooks/create_a_hook_subscription) or [Verify a Hook Subscription](#!/REST_Hooks/verify_a_hook_subscription). This operation allows you to confirm a subscription by manually sending us the &#x60;X-Hook-Secret&#x60; you received.  NB: **The &#x60;X-Hook-Secret&#x60; _must_ be passed as a _header_.**  Don&#39;t worry if verification fails; you can always [request another verification attempt](#!/REST_Hooks/verify_a_hook_subscription).  NB: You will not receive events until the subscription is verified.  If the verification process seems confusing, head over to [RESTHooks.org](http://resthooks.org/docs/security/) for more on the concept.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = RESTHooksApi()
val key : String = key_example // String | key
val xHookSecret : String = xHookSecret_example // String | X-Hook-Secret
try {
    val result : RestHook = apiInstance.verifyAHookSubscriptionDelayed(key, xHookSecret)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RESTHooksApi#verifyAHookSubscriptionDelayed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RESTHooksApi#verifyAHookSubscriptionDelayed")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| key |
 **xHookSecret** | **String**| X-Hook-Secret |

### Return type

[**RestHook**](RestHook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


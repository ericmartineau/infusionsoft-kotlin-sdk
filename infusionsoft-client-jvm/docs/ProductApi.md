# ProductApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProduct**](ProductApi.md#createProduct) | **POST** /products | Create a Product
[**createProductImage**](ProductApi.md#createProductImage) | **POST** /products/{productId}/image | Upload a product image
[**createProductSubscription**](ProductApi.md#createProductSubscription) | **POST** /products/{productId}/subscriptions | Create a Product Subscription
[**deleteProduct**](ProductApi.md#deleteProduct) | **DELETE** /products/{productId} | Delete a Product
[**deleteProductImage**](ProductApi.md#deleteProductImage) | **DELETE** /products/{productId}/image | Delete a product image
[**deleteProductSubscription**](ProductApi.md#deleteProductSubscription) | **DELETE** /products/{productId}/subscriptions/{subscriptionId} | Delete a Product Subscription
[**listProducts**](ProductApi.md#listProducts) | **GET** /products | List Products
[**listProductsFromSyncToken**](ProductApi.md#listProductsFromSyncToken) | **GET** /products/sync | Retrieve Synced Products
[**retrieveProduct**](ProductApi.md#retrieveProduct) | **GET** /products/{productId} | Retrieve a Product
[**retrieveProductSubscription**](ProductApi.md#retrieveProductSubscription) | **GET** /products/{productId}/subscriptions/{subscriptionId} | Retrieve a Product Subscription


<a name="createProduct"></a>
# **createProduct**
> Product createProduct(createProduct)

Create a Product

Creates a new product

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val createProduct : CreateProduct =  // CreateProduct | createProduct
try {
    val result : Product = apiInstance.createProduct(createProduct)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#createProduct")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#createProduct")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createProduct** | [**CreateProduct**](CreateProduct.md)| createProduct |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createProductImage"></a>
# **createProductImage**
> createProductImage(productId, restProductImage)

Upload a product image

Max payload 3 megabytes, the &#x60;file_data&#x60; is base64 encoded.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
val restProductImage : CreateProductImage =  // CreateProductImage | restProductImage
try {
    apiInstance.createProductImage(productId, restProductImage)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#createProductImage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#createProductImage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |
 **restProductImage** | [**CreateProductImage**](CreateProductImage.md)| restProductImage |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createProductSubscription"></a>
# **createProductSubscription**
> ProductSubscription createProductSubscription(productId, createProductSubscription)

Create a Product Subscription

Creates a new product subscription

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
val createProductSubscription : CreateProductSubscription =  // CreateProductSubscription | createProductSubscription
try {
    val result : ProductSubscription = apiInstance.createProductSubscription(productId, createProductSubscription)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#createProductSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#createProductSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |
 **createProductSubscription** | [**CreateProductSubscription**](CreateProductSubscription.md)| createProductSubscription |

### Return type

[**ProductSubscription**](ProductSubscription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProduct"></a>
# **deleteProduct**
> deleteProduct(productId)

Delete a Product

Deletes a product and its subscriptions

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
try {
    apiInstance.deleteProduct(productId)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#deleteProduct")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#deleteProduct")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProductImage"></a>
# **deleteProductImage**
> deleteProductImage(productId)

Delete a product image

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
try {
    apiInstance.deleteProductImage(productId)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#deleteProductImage")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#deleteProductImage")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProductSubscription"></a>
# **deleteProductSubscription**
> deleteProductSubscription(productId, subscriptionId)

Delete a Product Subscription

Deletes a product subscription

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
val subscriptionId : Long = 789 // Long | subscriptionId
try {
    apiInstance.deleteProductSubscription(productId, subscriptionId)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#deleteProductSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#deleteProductSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |
 **subscriptionId** | **Long**| subscriptionId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listProducts"></a>
# **listProducts**
> ProductList listProducts(limit, offset, active)

List Products

Retrieves a list of all products

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val active : Boolean = true // Boolean | Sets status of items to return
try {
    val result : ProductList = apiInstance.listProducts(limit, offset, active)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#listProducts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#listProducts")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **active** | **Boolean**| Sets status of items to return | [optional]

### Return type

[**ProductList**](ProductList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listProductsFromSyncToken"></a>
# **listProductsFromSyncToken**
> ProductStatusList listProductsFromSyncToken(syncToken, limit, offset)

Retrieve Synced Products

The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val syncToken : String = syncToken_example // String | sync_token
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
try {
    val result : ProductStatusList = apiInstance.listProductsFromSyncToken(syncToken, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#listProductsFromSyncToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#listProductsFromSyncToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **syncToken** | **String**| sync_token | [optional]
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]

### Return type

[**ProductStatusList**](ProductStatusList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveProduct"></a>
# **retrieveProduct**
> Product retrieveProduct(productId)

Retrieve a Product

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
try {
    val result : Product = apiInstance.retrieveProduct(productId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#retrieveProduct")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#retrieveProduct")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveProductSubscription"></a>
# **retrieveProductSubscription**
> ProductSubscription retrieveProductSubscription(productId, subscriptionId)

Retrieve a Product Subscription

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = ProductApi()
val productId : Long = 789 // Long | productId
val subscriptionId : Long = 789 // Long | subscriptionId
try {
    val result : ProductSubscription = apiInstance.retrieveProductSubscription(productId, subscriptionId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#retrieveProductSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#retrieveProductSubscription")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Long**| productId |
 **subscriptionId** | **Long**| subscriptionId |

### Return type

[**ProductSubscription**](ProductSubscription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


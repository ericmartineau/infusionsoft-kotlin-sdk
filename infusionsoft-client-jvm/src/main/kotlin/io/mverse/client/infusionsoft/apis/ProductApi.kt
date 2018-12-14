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

import io.mverse.client.infusionsoft.models.CreateProduct
import io.mverse.client.infusionsoft.models.CreateProductImage
import io.mverse.client.infusionsoft.models.CreateProductSubscription
import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.Product
import io.mverse.client.infusionsoft.models.ProductList
import io.mverse.client.infusionsoft.models.ProductStatusList
import io.mverse.client.infusionsoft.models.ProductSubscription

import io.mverse.client.infusionsoft.infrastructure.*
import kotlinx.serialization.*


class ProductApi(bearerToken:String, basePath: String = "https://api.infusionsoft.com/crm/rest/v1") : ApiClient(basePath, bearerToken) {

  /**
   *  Create a Product
   *  Creates a new product
   *  * @param createProduct createProduct 
   *  * @return Product
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createProduct(createProduct: CreateProduct) : Product {
    val requestBody = createProduct
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/products",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Product.serializer(),
      Product.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Product
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Upload a product image
   *  Max payload 3 megabytes, the &#x60;file_data&#x60; is base64 encoded.
   *  * @param productId productId 
   *  * @param restProductImage restProductImage 
   *  * @return void
   */ 
  fun createProductImage(productId: Long, restProductImage: CreateProductImage) : Unit {
    val requestBody = restProductImage
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/products/{productId}/image".replace("{"+"productId"+"}", "$productId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      UnitSerializer, 
      
      UnitSerializer)

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
   *  Create a Product Subscription
   *  Creates a new product subscription
   *  * @param productId productId 
   *  * @param createProductSubscription createProductSubscription 
   *  * @return ProductSubscription
   */ 
  @Suppress("UNCHECKED_CAST")
  fun createProductSubscription(productId: Long, createProductSubscription: CreateProductSubscription) : ProductSubscription {
    val requestBody = createProductSubscription
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.POST,
       "/products/{productId}/subscriptions".replace("{"+"productId"+"}", "$productId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ProductSubscription.serializer(),
      ProductSubscription.serializer())

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ProductSubscription
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Delete a Product
   *  Deletes a product and its subscriptions
   *  * @param productId productId 
   *  * @return void
   */ 
  fun deleteProduct(productId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/products/{productId}".replace("{"+"productId"+"}", "$productId"),
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
   *  Delete a product image
   *  
   *  * @param productId productId 
   *  * @return void
   */ 
  fun deleteProductImage(productId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/products/{productId}/image".replace("{"+"productId"+"}", "$productId"),
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
   *  Delete a Product Subscription
   *  Deletes a product subscription
   *  * @param productId productId 
   *  * @param subscriptionId subscriptionId 
   *  * @return void
   */ 
  fun deleteProductSubscription(productId: Long, subscriptionId: Long) : Unit {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.DELETE,
       "/products/{productId}/subscriptions/{subscriptionId}".replace("{"+"productId"+"}", "$productId").replace("{"+"subscriptionId"+"}", "$subscriptionId"),
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
   *  List Products
   *  Retrieves a list of all products
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @param active Sets status of items to return (optional)
   *  * @return ProductList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listProducts(limit: Int? = null, offset: Int? = null, active: Boolean? = null) : ProductList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")
    if (active != null) localVariableQuery["active"] = listOf("$active")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/products",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ProductList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ProductList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve Synced Products
   *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
   *  * @param syncToken sync_token (optional)
   *  * @param limit Sets a total of items to return (optional)
   *  * @param offset Sets a beginning range of items to return (optional)
   *  * @return ProductStatusList
   */ 
  @Suppress("UNCHECKED_CAST")
  fun listProductsFromSyncToken(syncToken: String? = null, limit: Int? = null, offset: Int? = null) : ProductStatusList {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()
    if (syncToken != null) localVariableQuery["sync_token"] = listOf("$syncToken")
    if (limit != null) localVariableQuery["limit"] = listOf("$limit")
    if (offset != null) localVariableQuery["offset"] = listOf("$offset")

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/products/sync",
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ProductStatusList.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ProductStatusList
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve a Product
   *  
   *  * @param productId productId 
   *  * @return Product
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveProduct(productId: Long) : Product {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/products/{productId}".replace("{"+"productId"+"}", "$productId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      Product.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as Product
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
  /**
   *  Retrieve a Product Subscription
   *  
   *  * @param productId productId 
   *  * @param subscriptionId subscriptionId 
   *  * @return ProductSubscription
   */ 
  @Suppress("UNCHECKED_CAST")
  fun retrieveProductSubscription(productId: Long, subscriptionId: Long) : ProductSubscription {
    val requestBody = null
    val localVariableQuery: MultiValueMap = mutableMapOf()

    val contentHeaders: Map<String, String> = mapOf()
    val acceptsHeaders: Map<String, String> = mapOf("Accept" to "application/json")
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders.putAll(contentHeaders)
    localVariableHeaders.putAll(acceptsHeaders)

    val localVariableConfig = RequestConfig(
       RequestMethod.GET,
       "/products/{productId}/subscriptions/{subscriptionId}".replace("{"+"productId"+"}", "$productId").replace("{"+"subscriptionId"+"}", "$subscriptionId"),
       query = localVariableQuery,
       headers = localVariableHeaders
    )
    val response = request(
      localVariableConfig,
      requestBody, 
      ProductSubscription.serializer(),UnitSerializer)

  return when (response.responseType) {
       ResponseType.Success -> (response as Success<*>).data as ProductSubscription
       ResponseType.Informational -> TODO()
       ResponseType.Redirection -> TODO()
       ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
       ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
       else -> throw kotlin.IllegalStateException("Undefined ResponseType.")
    }
  }
}

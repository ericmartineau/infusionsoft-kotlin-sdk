@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
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
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface ProductApi {

  /**
    *  Create a Product
    *  Creates a new product
    *  * @param createProduct createProduct (optional)
    *  * @return Product
    */
  suspend fun createProduct(createProduct: CreateProduct) : Product
  
  /**
    *  Asynchronous implementation of Create a Product
    *  Creates a new product
    *  * @param createProduct createProduct (optional)
    *  * @return A deferred reference to the final Product  
    */
  fun createProductAsync(createProduct: CreateProduct) : Deferred<Product>

  /**
    *  Upload a product image
    *  Max payload 3 megabytes, the `file_data` is base64 encoded.
    *  * @param productId productId (optional)
    *  * @param restProductImage restProductImage (optional)
    *  * @return void
    */
  suspend fun createProductImage(productId: Long, restProductImage: CreateProductImage)
  
  /**
    *  Asynchronous implementation of Upload a product image
    *  Max payload 3 megabytes, the `file_data` is base64 encoded.
    *  * @param productId productId (optional)
    *  * @param restProductImage restProductImage (optional)
    *  * @return A deferred reference to the final void  
    */
  fun createProductImageAsync(productId: Long, restProductImage: CreateProductImage) : Deferred<Unit>

  /**
    *  Create a Product Subscription
    *  Creates a new product subscription
    *  * @param productId productId (optional)
    *  * @param createProductSubscription createProductSubscription (optional)
    *  * @return ProductSubscription
    */
  suspend fun createProductSubscription(productId: Long, createProductSubscription: CreateProductSubscription) : ProductSubscription
  
  /**
    *  Asynchronous implementation of Create a Product Subscription
    *  Creates a new product subscription
    *  * @param productId productId (optional)
    *  * @param createProductSubscription createProductSubscription (optional)
    *  * @return A deferred reference to the final ProductSubscription  
    */
  fun createProductSubscriptionAsync(productId: Long, createProductSubscription: CreateProductSubscription) : Deferred<ProductSubscription>

  /**
    *  Delete a Product
    *  Deletes a product and its subscriptions
    *  * @param productId productId (optional)
    *  * @return void
    */
  suspend fun deleteProduct(productId: Long)
  
  /**
    *  Asynchronous implementation of Delete a Product
    *  Deletes a product and its subscriptions
    *  * @param productId productId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteProductAsync(productId: Long) : Deferred<Unit>

  /**
    *  Delete a product image
    *  
    *  * @param productId productId (optional)
    *  * @return void
    */
  suspend fun deleteProductImage(productId: Long)
  
  /**
    *  Asynchronous implementation of Delete a product image
    *  
    *  * @param productId productId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteProductImageAsync(productId: Long) : Deferred<Unit>

  /**
    *  Delete a Product Subscription
    *  Deletes a product subscription
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return void
    */
  suspend fun deleteProductSubscription(productId: Long, subscriptionId: Long)
  
  /**
    *  Asynchronous implementation of Delete a Product Subscription
    *  Deletes a product subscription
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return A deferred reference to the final void  
    */
  fun deleteProductSubscriptionAsync(productId: Long, subscriptionId: Long) : Deferred<Unit>

  /**
    *  List Products
    *  Retrieves a list of all products
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param active Sets status of items to return 
    *  * @return ProductList
    */
  suspend fun listProducts(limit: Int? = null, offset: Int? = null, active: Boolean? = null) : ProductList
  
  /**
    *  Asynchronous implementation of List Products
    *  Retrieves a list of all products
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param active Sets status of items to return 
    *  * @return A deferred reference to the final ProductList  
    */
  fun listProductsAsync(limit: Int? = null, offset: Int? = null, active: Boolean? = null) : Deferred<ProductList>

  /**
    *  Retrieve Synced Products
    *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
    *  * @param syncToken sync_token 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return ProductStatusList
    */
  suspend fun listProductsFromSyncToken(syncToken: String? = null, limit: Int? = null, offset: Int? = null) : ProductStatusList
  
  /**
    *  Asynchronous implementation of Retrieve Synced Products
    *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
    *  * @param syncToken sync_token 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return A deferred reference to the final ProductStatusList  
    */
  fun listProductsFromSyncTokenAsync(syncToken: String? = null, limit: Int? = null, offset: Int? = null) : Deferred<ProductStatusList>

  /**
    *  Retrieve a Product
    *  
    *  * @param productId productId (optional)
    *  * @return Product
    */
  suspend fun retrieveProduct(productId: Long) : Product
  
  /**
    *  Asynchronous implementation of Retrieve a Product
    *  
    *  * @param productId productId (optional)
    *  * @return A deferred reference to the final Product  
    */
  fun retrieveProductAsync(productId: Long) : Deferred<Product>

  /**
    *  Retrieve a Product Subscription
    *  
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return ProductSubscription
    */
  suspend fun retrieveProductSubscription(productId: Long, subscriptionId: Long) : ProductSubscription
  
  /**
    *  Asynchronous implementation of Retrieve a Product Subscription
    *  
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return A deferred reference to the final ProductSubscription  
    */
  fun retrieveProductSubscriptionAsync(productId: Long, subscriptionId: Long) : Deferred<ProductSubscription>

}

class ProductApiImpl(bearerToken:String, basePath: String, gson: Gson) : ProductApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Product
    *  Creates a new product
    *  * @param createProduct createProduct (optional)
    *  * @return Product
    */
  override suspend fun createProduct(createProduct: CreateProduct) : Product {
    val uri = uriTemplate("/products")
      .build()
    val call = post(uri) {
      body = createProduct ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Product
    *  Creates a new product
    *  * @param createProduct createProduct (optional)
    *  * @return A deferred reference to the final Product  
    */
  override fun createProductAsync(createProduct: CreateProduct)  = 
        client.async { createProduct(createProduct) }

  /**
    *  Upload a product image
    *  Max payload 3 megabytes, the `file_data` is base64 encoded.
    *  * @param productId productId (optional)
    *  * @param restProductImage restProductImage (optional)
    *  * @return void
    */
  override suspend fun createProductImage(productId: Long, restProductImage: CreateProductImage) {
    val uri = uriTemplate("/products/{productId}/image")
      .parameter("productId", productId)
      .build()
    val call = post(uri) {
      body = restProductImage ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Upload a product image
    *  Max payload 3 megabytes, the `file_data` is base64 encoded.
    *  * @param productId productId (optional)
    *  * @param restProductImage restProductImage (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun createProductImageAsync(productId: Long, restProductImage: CreateProductImage)  = 
        client.async { createProductImage(productId, restProductImage) }

  /**
    *  Create a Product Subscription
    *  Creates a new product subscription
    *  * @param productId productId (optional)
    *  * @param createProductSubscription createProductSubscription (optional)
    *  * @return ProductSubscription
    */
  override suspend fun createProductSubscription(productId: Long, createProductSubscription: CreateProductSubscription) : ProductSubscription {
    val uri = uriTemplate("/products/{productId}/subscriptions")
      .parameter("productId", productId)
      .build()
    val call = post(uri) {
      body = createProductSubscription ?: EmptyContent
      contentType(Application.Json)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Create a Product Subscription
    *  Creates a new product subscription
    *  * @param productId productId (optional)
    *  * @param createProductSubscription createProductSubscription (optional)
    *  * @return A deferred reference to the final ProductSubscription  
    */
  override fun createProductSubscriptionAsync(productId: Long, createProductSubscription: CreateProductSubscription)  = 
        client.async { createProductSubscription(productId, createProductSubscription) }

  /**
    *  Delete a Product
    *  Deletes a product and its subscriptions
    *  * @param productId productId (optional)
    *  * @return void
    */
  override suspend fun deleteProduct(productId: Long) {
    val uri = uriTemplate("/products/{productId}")
      .parameter("productId", productId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete a Product
    *  Deletes a product and its subscriptions
    *  * @param productId productId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteProductAsync(productId: Long)  = 
        client.async { deleteProduct(productId) }

  /**
    *  Delete a product image
    *  
    *  * @param productId productId (optional)
    *  * @return void
    */
  override suspend fun deleteProductImage(productId: Long) {
    val uri = uriTemplate("/products/{productId}/image")
      .parameter("productId", productId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete a product image
    *  
    *  * @param productId productId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteProductImageAsync(productId: Long)  = 
        client.async { deleteProductImage(productId) }

  /**
    *  Delete a Product Subscription
    *  Deletes a product subscription
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return void
    */
  override suspend fun deleteProductSubscription(productId: Long, subscriptionId: Long) {
    val uri = uriTemplate("/products/{productId}/subscriptions/{subscriptionId}")
      .parameter("productId", productId)
      .parameter("subscriptionId", subscriptionId)
      .build()
    val call = delete(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Delete a Product Subscription
    *  Deletes a product subscription
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return A deferred reference to the final void  
    */
  override fun deleteProductSubscriptionAsync(productId: Long, subscriptionId: Long)  = 
        client.async { deleteProductSubscription(productId, subscriptionId) }

  /**
    *  List Products
    *  Retrieves a list of all products
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param active Sets status of items to return 
    *  * @return ProductList
    */
  override suspend fun listProducts(limit: Int?, offset: Int?, active: Boolean?) : ProductList {
    val uri = uriTemplate("/products")
      .build()
    val call = get(uri) {
      queryParam("limit",  limit)
      queryParam("offset",  offset)
      queryParam("active",  active)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Products
    *  Retrieves a list of all products
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param active Sets status of items to return 
    *  * @return A deferred reference to the final ProductList  
    */
  override fun listProductsAsync(limit: Int?, offset: Int?, active: Boolean?)  = 
        client.async { listProducts(limit, offset, active) }

  /**
    *  Retrieve Synced Products
    *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
    *  * @param syncToken sync_token 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return ProductStatusList
    */
  override suspend fun listProductsFromSyncToken(syncToken: String?, limit: Int?, offset: Int?) : ProductStatusList {
    val uri = uriTemplate("/products/sync")
      .build()
    val call = get(uri) {
      queryParam("sync_token",  syncToken)
      queryParam("limit",  limit)
      queryParam("offset",  offset)
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve Synced Products
    *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
    *  * @param syncToken sync_token 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return A deferred reference to the final ProductStatusList  
    */
  override fun listProductsFromSyncTokenAsync(syncToken: String?, limit: Int?, offset: Int?)  = 
        client.async { listProductsFromSyncToken(syncToken, limit, offset) }

  /**
    *  Retrieve a Product
    *  
    *  * @param productId productId (optional)
    *  * @return Product
    */
  override suspend fun retrieveProduct(productId: Long) : Product {
    val uri = uriTemplate("/products/{productId}")
      .parameter("productId", productId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Product
    *  
    *  * @param productId productId (optional)
    *  * @return A deferred reference to the final Product  
    */
  override fun retrieveProductAsync(productId: Long)  = 
        client.async { retrieveProduct(productId) }

  /**
    *  Retrieve a Product Subscription
    *  
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return ProductSubscription
    */
  override suspend fun retrieveProductSubscription(productId: Long, subscriptionId: Long) : ProductSubscription {
    val uri = uriTemplate("/products/{productId}/subscriptions/{subscriptionId}")
      .parameter("productId", productId)
      .parameter("subscriptionId", subscriptionId)
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve a Product Subscription
    *  
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return A deferred reference to the final ProductSubscription  
    */
  override fun retrieveProductSubscriptionAsync(productId: Long, subscriptionId: Long)  = 
        client.async { retrieveProductSubscription(productId, subscriptionId) }

}
   

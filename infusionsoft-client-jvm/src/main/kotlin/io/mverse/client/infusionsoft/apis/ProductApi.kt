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
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface ProductApi {

  /**
    *  Create a Product
    *  Creates a new product
    *  * @param createProduct createProduct (optional)
    *  * @return Product
    */
  suspend fun createProduct(createProduct: CreateProduct? = null) : Product
    
  /**
    *  Upload a product image
    *  Max payload 3 megabytes, the `file_data` is base64 encoded.
    *  * @param productId productId (optional)
    *  * @param restProductImage restProductImage (optional)
    *  * @return void
    */
  suspend fun createProductImage(productId: Long? = null, restProductImage: CreateProductImage? = null) : Unit
    
  /**
    *  Create a Product Subscription
    *  Creates a new product subscription
    *  * @param productId productId (optional)
    *  * @param createProductSubscription createProductSubscription (optional)
    *  * @return ProductSubscription
    */
  suspend fun createProductSubscription(productId: Long? = null, createProductSubscription: CreateProductSubscription? = null) : ProductSubscription
    
  /**
    *  Delete a Product
    *  Deletes a product and its subscriptions
    *  * @param productId productId (optional)
    *  * @return void
    */
  suspend fun deleteProduct(productId: Long? = null) : Unit
    
  /**
    *  Delete a product image
    *  
    *  * @param productId productId (optional)
    *  * @return void
    */
  suspend fun deleteProductImage(productId: Long? = null) : Unit
    
  /**
    *  Delete a Product Subscription
    *  Deletes a product subscription
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return void
    */
  suspend fun deleteProductSubscription(productId: Long? = null, subscriptionId: Long? = null) : Unit
    
  /**
    *  List Products
    *  Retrieves a list of all products
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param active Sets status of items to return 
    *  * @return ProductList
    */
  suspend fun listProducts(limit: Int, offset: Int, active: Boolean) : ProductList
    
  /**
    *  Retrieve Synced Products
    *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
    *  * @param syncToken sync_token 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return ProductStatusList
    */
  suspend fun listProductsFromSyncToken(syncToken: String, limit: Int, offset: Int) : ProductStatusList
    
  /**
    *  Retrieve a Product
    *  
    *  * @param productId productId (optional)
    *  * @return Product
    */
  suspend fun retrieveProduct(productId: Long? = null) : Product
    
  /**
    *  Retrieve a Product Subscription
    *  
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return ProductSubscription
    */
  suspend fun retrieveProductSubscription(productId: Long? = null, subscriptionId: Long? = null) : ProductSubscription
    
}

class ProductApiImpl(bearerToken:String, basePath: String, gson: Gson) : ProductApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Create a Product
    *  Creates a new product
    *  * @param createProduct createProduct (optional)
    *  * @return Product
    */
  override suspend fun createProduct(createProduct: CreateProduct?) : Product {
    val call = request( "/products", mapOf()) {
      method = HttpMethod.parse("POST")
      body = createProduct ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Upload a product image
    *  Max payload 3 megabytes, the `file_data` is base64 encoded.
    *  * @param productId productId (optional)
    *  * @param restProductImage restProductImage (optional)
    *  * @return void
    */
  override suspend fun createProductImage(productId: Long?, restProductImage: CreateProductImage?) : Unit {
    val call = request( "/products/{productId}/image", mapOf("productId" to "$productId")) {
      method = HttpMethod.parse("POST")
      body = restProductImage ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Create a Product Subscription
    *  Creates a new product subscription
    *  * @param productId productId (optional)
    *  * @param createProductSubscription createProductSubscription (optional)
    *  * @return ProductSubscription
    */
  override suspend fun createProductSubscription(productId: Long?, createProductSubscription: CreateProductSubscription?) : ProductSubscription {
    val call = request( "/products/{productId}/subscriptions", mapOf("productId" to "$productId")) {
      method = HttpMethod.parse("POST")
      body = createProductSubscription ?: EmptyContent
    
    }
    return call.receive()
  }

  /**
    *  Delete a Product
    *  Deletes a product and its subscriptions
    *  * @param productId productId (optional)
    *  * @return void
    */
  override suspend fun deleteProduct(productId: Long?) : Unit {
    val call = request( "/products/{productId}", mapOf("productId" to "$productId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Delete a product image
    *  
    *  * @param productId productId (optional)
    *  * @return void
    */
  override suspend fun deleteProductImage(productId: Long?) : Unit {
    val call = request( "/products/{productId}/image", mapOf("productId" to "$productId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  Delete a Product Subscription
    *  Deletes a product subscription
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return void
    */
  override suspend fun deleteProductSubscription(productId: Long?, subscriptionId: Long?) : Unit {
    val call = request( "/products/{productId}/subscriptions/{subscriptionId}", mapOf("productId" to "$productId", "subscriptionId" to "$subscriptionId")) {
      method = HttpMethod.parse("DELETE")
    }
    return call.receive()
  }

  /**
    *  List Products
    *  Retrieves a list of all products
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @param active Sets status of items to return 
    *  * @return ProductList
    */
  override suspend fun listProducts(limit: Int, offset: Int, active: Boolean) : ProductList {
    val call = request( "/products", mapOf()) {
      method = HttpMethod.parse("GET")
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
      if (active != null) url.parameters.append("active", "$active")
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve Synced Products
    *  The Sync endpoint returns a set of products that have been updated or created since the last result set was retrieved, minus any products that have been deleted.
    *  * @param syncToken sync_token 
    *  * @param limit Sets a total of items to return 
    *  * @param offset Sets a beginning range of items to return 
    *  * @return ProductStatusList
    */
  override suspend fun listProductsFromSyncToken(syncToken: String, limit: Int, offset: Int) : ProductStatusList {
    val call = request( "/products/sync", mapOf()) {
      method = HttpMethod.parse("GET")
      if (syncToken != null) url.parameters.append("sync_token", "$syncToken")
      
    
      if (limit != null) url.parameters.append("limit", "$limit")
      
    
      if (offset != null) url.parameters.append("offset", "$offset")
      
    
    }
    return call.receive()
  }

  /**
    *  Retrieve a Product
    *  
    *  * @param productId productId (optional)
    *  * @return Product
    */
  override suspend fun retrieveProduct(productId: Long?) : Product {
    val call = request( "/products/{productId}", mapOf("productId" to "$productId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  Retrieve a Product Subscription
    *  
    *  * @param productId productId (optional)
    *  * @param subscriptionId subscriptionId (optional)
    *  * @return ProductSubscription
    */
  override suspend fun retrieveProductSubscription(productId: Long?, subscriptionId: Long?) : ProductSubscription {
    val call = request( "/products/{productId}/subscriptions/{subscriptionId}", mapOf("productId" to "$productId", "subscriptionId" to "$subscriptionId")) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

}
   

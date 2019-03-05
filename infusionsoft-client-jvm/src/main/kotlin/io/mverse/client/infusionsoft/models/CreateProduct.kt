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
package io.mverse.client.infusionsoft.models


import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param active 
 * @param product_desc 
 * @param product_name 
 * @param product_price 
 * @param product_short_desc 
 * @param sku 
 * @param subscription_only 
 */
@Serializable
data class CreateProduct (
    @SerialName("product_name") val productName: String,
    @SerialName("active") @Optional val active: Boolean? = null,
    @SerialName("product_desc") @Optional val productDesc: String? = null,
    @SerialName("product_price") @Optional val productPrice: Double? = null,
    @SerialName("product_short_desc") @Optional val productShortDesc: String? = null,
    @SerialName("sku") @Optional val sku: String? = null,
    @SerialName("subscription_only") @Optional val subscriptionOnly: Boolean? = null
) {

}


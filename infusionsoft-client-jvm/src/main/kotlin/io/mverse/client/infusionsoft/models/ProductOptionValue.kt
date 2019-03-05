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
 * @param id 
 * @param index 
 * @param is_default 
 * @param label 
 * @param price_adjustment 
 * @param sku 
 */
@Serializable
data class ProductOptionValue (
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("index") @Optional val index: Long? = null,
    @SerialName("is_default") @Optional val isDefault: Boolean? = null,
    @SerialName("label") @Optional val label: String? = null,
    @SerialName("price_adjustment") @Optional val priceAdjustment: Double? = null,
    @SerialName("sku") @Optional val sku: String? = null
) {

}


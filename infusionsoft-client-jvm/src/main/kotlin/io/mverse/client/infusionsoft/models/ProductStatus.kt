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

import io.mverse.client.infusionsoft.models.Product_

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


import io.mverse.client.infusionsoft.infrastructure.EnumStringSerializer
/**
 * 
 * @param product 
 * @param status 
 */
@Serializable
data class ProductStatus (
    @SerialName("product") @Optional val product: Product_? = null,
    @SerialName("status") @Optional val status: ProductStatus.Status? = null
) {

    /**
    * 
    * Values: CREATED,UPDATED,DELETED
    */
    @Serializable(with = Status.Serializer::class)
    enum class Status(val value: String){
    
        CREATED("CREATED"),
    
        UPDATED("UPDATED"),
    
        DELETED("DELETED");
    

      class Serializer: EnumStringSerializer<Status>(Status::class)

      override fun toString(): String = value.toString()
    }

}


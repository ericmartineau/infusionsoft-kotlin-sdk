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
 * @param category 
 * @param id 
 * @param name 
 */
//@Serializable Not using right now
data class SimpleTag (
    @SerialName("category") @Optional val category: String? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("name") @Optional val name: String? = null
) {

}


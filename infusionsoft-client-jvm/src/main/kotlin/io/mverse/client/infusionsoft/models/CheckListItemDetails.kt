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
 * @param description 
 * @param done_date 
 * @param id 
 * @param instance_id 
 * @param item_order 
 * @param required 
 */
@Serializable
data class CheckListItemDetails (
    @SerialName("description") @Optional val description: String? = null,
    @SerialName("done_date") @Optional val doneDate: java.time.LocalDateTime? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("instance_id") @Optional val instanceId: Long? = null,
    @SerialName("item_order") @Optional val itemOrder: Int? = null,
    @SerialName("required") @Optional val required: Boolean? = null
) {

}


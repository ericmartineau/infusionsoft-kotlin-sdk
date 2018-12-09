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
package io.mverse.client.infusionsoft.models


import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param end_stage 
 * @param is_default 
 * @param stage_count 
 * @param stage_id 
 * @param stage_name 
 * @param stage_order 
 */
@Serializable
data class SalesPipeline (
    @SerialName("end_stage") @Optional val endStage: Boolean? = null,
    @SerialName("is_default") @Optional val isDefault: Boolean? = null,
    @SerialName("stage_count") @Optional val stageCount: Int? = null,
    @SerialName("stage_id") @Optional val stageId: Long? = null,
    @SerialName("stage_name") @Optional val stageName: String? = null,
    @SerialName("stage_order") @Optional val stageOrder: Int? = null
) {

}


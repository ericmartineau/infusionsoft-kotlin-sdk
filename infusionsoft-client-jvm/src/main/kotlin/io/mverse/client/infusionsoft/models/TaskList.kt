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

import io.mverse.client.infusionsoft.models.Task

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param count 
 * @param next 
 * @param previous 
 * @param sync_token 
 * @param tasks 
 */
//@Serializable Not using right now
data class TaskList (
    @SerialName("count") @Optional val count: Int? = null,
    @SerialName("next") @Optional val next: String? = null,
    @SerialName("previous") @Optional val previous: String? = null,
    @SerialName("sync_token") @Optional val syncToken: String? = null,
    @SerialName("tasks") @Optional val tasks: List<Task>? = null
) {

}


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

import io.mverse.client.infusionsoft.models.NoteUser

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param body 
 * @param contact_id 
 * @param date_created 
 * @param id 
 * @param last_updated 
 * @param last_updated_by 
 * @param title 
 * @param user_id 
 */
@Serializable
data class Note (
    @SerialName("body") @Optional val body: String? = null,
    @SerialName("contact_id") @Optional val contactId: Long? = null,
    @SerialName("date_created") @Optional val dateCreated: java.time.LocalDateTime? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("last_updated") @Optional val lastUpdated: java.time.LocalDateTime? = null,
    @SerialName("last_updated_by") @Optional val lastUpdatedBy: NoteUser? = null,
    @SerialName("title") @Optional val title: String? = null,
    @SerialName("user_id") @Optional val userId: Long? = null
) {

}


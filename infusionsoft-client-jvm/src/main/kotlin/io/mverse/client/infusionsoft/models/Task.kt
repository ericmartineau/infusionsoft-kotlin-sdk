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

import io.mverse.client.infusionsoft.models.BasicContact

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param completed 
 * @param completion_date 
 * @param contact 
 * @param creation_date 
 * @param description 
 * @param due_date 
 * @param modification_date 
 * @param priority 
 * @param remind_time Value in minutes before start_date to show pop-up reminder.  Acceptable values are [5,10,15,30,60,120,240,480,1440,2880]
 * @param title 
 * @param type 
 * @param url 
 * @param user_id 
 */
@Serializable
data class Task (
    @SerialName("completed") @Optional val completed: Boolean? = null,
    @SerialName("completion_date") @Optional val completionDate: String? = null,
    @SerialName("contact") @Optional val contact: BasicContact? = null,
    @SerialName("creation_date") @Optional val creationDate: String? = null,
    @SerialName("description") @Optional val description: String? = null,
    @SerialName("due_date") @Optional val dueDate: String? = null,
    @SerialName("modification_date") @Optional val modificationDate: String? = null,
    @SerialName("priority") @Optional val priority: Int? = null,
    /* Value in minutes before start_date to show pop-up reminder.  Acceptable values are [5,10,15,30,60,120,240,480,1440,2880] */
    @SerialName("remind_time") @Optional val remindTime: Int? = null,
    @SerialName("title") @Optional val title: String? = null,
    @SerialName("type") @Optional val type: String? = null,
    @SerialName("url") @Optional val url: String? = null,
    @SerialName("user_id") @Optional val userId: Long? = null
) {

}


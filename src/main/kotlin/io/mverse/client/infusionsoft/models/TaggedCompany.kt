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

import io.mverse.client.infusionsoft.models.BasicCompany

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param company 
 * @param date_applied 
 */
@Serializable
data class TaggedCompany (
    @SerialName("company") @Optional val company: BasicCompany? = null,
    @SerialName("date_applied") @Optional val dateApplied: java.time.LocalDateTime? = null
) {

}


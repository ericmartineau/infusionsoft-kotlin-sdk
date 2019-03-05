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

import io.mverse.client.infusionsoft.models.CreateRestCustomFieldOption

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param label 
 * @param options 
 */
@Serializable
data class CreateRestCustomFieldOption (
    @SerialName("label") @Optional val label: String? = null,
    @SerialName("options") @Optional val options: List<CreateRestCustomFieldOption>? = null
) {

}


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

import io.mverse.client.infusionsoft.models.StackTraceElement
import io.mverse.client.infusionsoft.models.Throwable

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param cause 
 * @param localizedMessage 
 * @param message 
 * @param stackTrace 
 * @param suppressed 
 */
@Serializable
data class Throwable (
    @SerialName("cause") @Optional val cause: Throwable? = null,
    @SerialName("localizedMessage") @Optional val localizedMessage: String? = null,
    @SerialName("message") @Optional val message: String? = null,
    @SerialName("stackTrace") @Optional val stackTrace: List<StackTraceElement>? = null,
    @SerialName("suppressed") @Optional val suppressed: List<Throwable>? = null
) {

}

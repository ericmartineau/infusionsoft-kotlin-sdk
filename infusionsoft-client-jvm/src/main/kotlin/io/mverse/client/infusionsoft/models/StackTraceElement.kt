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
 * @param className 
 * @param fileName 
 * @param lineNumber 
 * @param methodName 
 * @param nativeMethod 
 */
//@Serializable Not using right now
data class StackTraceElement (
    @SerialName("className") @Optional val className: String? = null,
    @SerialName("fileName") @Optional val fileName: String? = null,
    @SerialName("lineNumber") @Optional val lineNumber: Int? = null,
    @SerialName("methodName") @Optional val methodName: String? = null,
    @SerialName("nativeMethod") @Optional val nativeMethod: Boolean? = null
) {

}


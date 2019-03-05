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
 * @param email 
 * @param family_name 
 * @param given_name 
 * @param global_user_id 
 * @param infusionsoft_id 
 * @param middle_name 
 * @param preferred_name 
 * @param sub 
 */
@Serializable
data class UserInfoDTO (
    @SerialName("email") val email: String,
    @SerialName("family_name") val familyName: String,
    @SerialName("given_name") val givenName: String,
    @SerialName("global_user_id") val globalUserId: Long,
    @SerialName("infusionsoft_id") val infusionsoftId: String,
    @SerialName("sub") val sub: String,
    @SerialName("middle_name") @Optional val middleName: String? = null,
    @SerialName("preferred_name") @Optional val preferredName: String? = null
) {

}


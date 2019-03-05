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
 * @param account_name 
 * @param id 
 * @param is_test 
 * @param type 
 */
//@Serializable Not using right now
data class Merchant (
    @SerialName("account_name") @Optional val accountName: String? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("is_test") @Optional val isTest: Boolean? = null,
    @SerialName("type") @Optional val type: String? = null
) {

}


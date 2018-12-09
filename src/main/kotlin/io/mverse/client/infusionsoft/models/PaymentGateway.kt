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
 * @param merchant_account_id 
 * @param use_default 
 */
@Serializable
data class PaymentGateway (
    @SerialName("merchant_account_id") @Optional val merchantAccountId: Long? = null,
    @SerialName("use_default") @Optional val useDefault: Boolean? = null
) {

}


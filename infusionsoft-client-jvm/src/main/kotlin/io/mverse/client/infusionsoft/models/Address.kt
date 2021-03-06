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
 * @param country_code 
 * @param line1 
 * @param line2 
 * @param locality 
 * @param region 
 * @param zip_code 
 * @param zip_four 
 */
//@Serializable Not using right now
data class Address (
    @SerialName("country_code") @Optional val countryCode: String? = null,
    @SerialName("line1") @Optional val line1: String? = null,
    @SerialName("line2") @Optional val line2: String? = null,
    @SerialName("locality") @Optional val locality: String? = null,
    @SerialName("region") @Optional val region: String? = null,
    @SerialName("zip_code") @Optional val zipCode: String? = null,
    @SerialName("zip_four") @Optional val zipFour: String? = null
) {

}


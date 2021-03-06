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
 * @param 24_hours 
 * @param 30_days 
 */
//@Serializable Not using right now
data class HistoricalCounts (
    @SerialName("24_hours") @Optional val safe24Hours: Int? = null,
    @SerialName("30_days") @Optional val safe30Days: Int? = null
) {

}


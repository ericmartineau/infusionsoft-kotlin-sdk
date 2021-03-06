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
 * @param company_name 
 * @param email 
 * @param first_name 
 * @param id 
 * @param job_title 
 * @param last_name 
 */
//@Serializable Not using right now
data class OrderContactDetails (
    @SerialName("company_name") @Optional val companyName: String? = null,
    @SerialName("email") @Optional val email: String? = null,
    @SerialName("first_name") @Optional val firstName: String? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("job_title") @Optional val jobTitle: String? = null,
    @SerialName("last_name") @Optional val lastName: String? = null
) {

}


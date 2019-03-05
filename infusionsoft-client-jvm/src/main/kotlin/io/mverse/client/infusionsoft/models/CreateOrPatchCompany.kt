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

import io.mverse.client.infusionsoft.models.CompanyAddress
import io.mverse.client.infusionsoft.models.CompanyFaxNumber
import io.mverse.client.infusionsoft.models.CompanyPhoneNumber
import io.mverse.client.infusionsoft.models.CustomFieldValue

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param address 
 * @param company_name 
 * @param custom_fields 
 * @param email_address 
 * @param fax_number 
 * @param notes 
 * @param opt_in_reason 
 * @param phone_number 
 * @param website 
 */
@Serializable
data class CreateOrPatchCompany (
    @SerialName("company_name") val companyName: String,
    @SerialName("address") @Optional val address: CompanyAddress? = null,
    @SerialName("custom_fields") @Optional val customFields: List<CustomFieldValue>? = null,
    @SerialName("email_address") @Optional val emailAddress: String? = null,
    @SerialName("fax_number") @Optional val faxNumber: CompanyFaxNumber? = null,
    @SerialName("notes") @Optional val notes: String? = null,
    @SerialName("opt_in_reason") @Optional val optInReason: String? = null,
    @SerialName("phone_number") @Optional val phoneNumber: CompanyPhoneNumber? = null,
    @SerialName("website") @Optional val website: String? = null
) {

}


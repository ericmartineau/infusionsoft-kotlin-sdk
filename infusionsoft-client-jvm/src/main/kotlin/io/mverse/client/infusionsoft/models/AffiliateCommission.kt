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
 * @param amount_earned 
 * @param contact_first_name 
 * @param contact_id 
 * @param contact_last_name 
 * @param date_earned 
 * @param description 
 * @param invoice_id 
 * @param product_name 
 * @param sales_affiliate_id 
 * @param sold_by_first_name 
 * @param sold_by_last_name 
 */
@Serializable
data class AffiliateCommission (
    @SerialName("amount_earned") @Optional val amountEarned: Float? = null,
    @SerialName("contact_first_name") @Optional val contactFirstName: String? = null,
    @SerialName("contact_id") @Optional val contactId: Long? = null,
    @SerialName("contact_last_name") @Optional val contactLastName: String? = null,
    @SerialName("date_earned") @Optional val dateEarned: java.time.LocalDateTime? = null,
    @SerialName("description") @Optional val description: String? = null,
    @SerialName("invoice_id") @Optional val invoiceId: Long? = null,
    @SerialName("product_name") @Optional val productName: String? = null,
    @SerialName("sales_affiliate_id") @Optional val salesAffiliateId: Long? = null,
    @SerialName("sold_by_first_name") @Optional val soldByFirstName: String? = null,
    @SerialName("sold_by_last_name") @Optional val soldByLastName: String? = null
) {

}


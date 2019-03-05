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
 * @param id 
 * @param invoice_id 
 * @param payment_amount 
 * @param payment_status 
 * @param transaction_id 
 */
//@Serializable Not using right now
data class PaymentResult (
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("invoice_id") @Optional val invoiceId: Long? = null,
    @SerialName("payment_amount") @Optional val paymentAmount: Double? = null,
    @SerialName("payment_status") @Optional val paymentStatus: String? = null,
    @SerialName("transaction_id") @Optional val transactionId: Long? = null
) {

}


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

import io.mverse.client.infusionsoft.models.AddressInformation
import io.mverse.client.infusionsoft.models.OrderContactDetails
import io.mverse.client.infusionsoft.models.OrderItem
import io.mverse.client.infusionsoft.models.PaymentPlan

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param contact 
 * @param creation_date 
 * @param id 
 * @param lead_affiliate_id 
 * @param modification_date 
 * @param notes 
 * @param order_date 
 * @param order_items 
 * @param payment_plan 
 * @param recurring 
 * @param refund_total 
 * @param sales_affiliate_id 
 * @param shipping_information 
 * @param status 
 * @param terms 
 * @param title 
 * @param total 
 * @param total_due 
 * @param total_paid 
 */
//@Serializable Not using right now
data class Order (
    @SerialName("contact") @Optional val contact: OrderContactDetails? = null,
    @SerialName("creation_date") @Optional val creationDate: String? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("lead_affiliate_id") @Optional val leadAffiliateId: Long? = null,
    @SerialName("modification_date") @Optional val modificationDate: String? = null,
    @SerialName("notes") @Optional val notes: String? = null,
    @SerialName("order_date") @Optional val orderDate: String? = null,
    @SerialName("order_items") @Optional val orderItems: List<OrderItem>? = null,
    @SerialName("payment_plan") @Optional val paymentPlan: PaymentPlan? = null,
    @SerialName("recurring") @Optional val recurring: Boolean? = null,
    @SerialName("refund_total") @Optional val refundTotal: Double? = null,
    @SerialName("sales_affiliate_id") @Optional val salesAffiliateId: Long? = null,
    @SerialName("shipping_information") @Optional val shippingInformation: AddressInformation? = null,
    @SerialName("status") @Optional val status: String? = null,
    @SerialName("terms") @Optional val terms: String? = null,
    @SerialName("title") @Optional val title: String? = null,
    @SerialName("total") @Optional val total: Double? = null,
    @SerialName("total_due") @Optional val totalDue: Double? = null,
    @SerialName("total_paid") @Optional val totalPaid: Double? = null
) {

}


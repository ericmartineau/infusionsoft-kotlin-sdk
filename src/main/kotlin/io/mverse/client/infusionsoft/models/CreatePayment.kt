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


import io.mverse.client.infusionsoft.infrastructure.EnumStringSerializer
/**
 * 
 * @param apply_to_commissions 
 * @param charge_now 
 * @param credit_card_id 
 * @param date Used when charge_now:false or inserting historical data. ex `2017-01-01T22:17:59.039Z`
 * @param notes 
 * @param payment_amount 
 * @param payment_gateway_id 
 * @param payment_method_type 
 */
@Serializable
data class CreatePayment (
    @SerialName("apply_to_commissions") @Optional val applyToCommissions: Boolean? = null,
    @SerialName("charge_now") @Optional val chargeNow: Boolean? = null,
    @SerialName("credit_card_id") @Optional val creditCardId: Long? = null,
    /* Used when charge_now:false or inserting historical data. ex `2017-01-01T22:17:59.039Z` */
    @SerialName("date") @Optional val date: java.time.LocalDateTime? = null,
    @SerialName("notes") @Optional val notes: String? = null,
    @SerialName("payment_amount") @Optional val paymentAmount: Double? = null,
    @SerialName("payment_gateway_id") @Optional val paymentGatewayId: String? = null,
    @SerialName("payment_method_type") @Optional val paymentMethodType: CreatePayment.PaymentMethodType? = null
) {

    /**
    * 
    * Values: CREDIT_CARD,CASH,CHECK
    */
    @Serializable(with = PaymentMethodType.Serializer::class)
    enum class PaymentMethodType(val value: String){
    
        CREDIT_CARD("CREDIT_CARD"),
    
        CASH("CASH"),
    
        CHECK("CHECK");
    

      class Serializer: EnumStringSerializer<PaymentMethodType>(PaymentMethodType::class)

      override fun toString(): String = value.toString()
    }

}


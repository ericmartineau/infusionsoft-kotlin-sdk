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
 * @param active 
 * @param cycle 
 * @param frequency 
 * @param id 
 * @param number_of_cycles 
 * @param plan_price 
 * @param subscription_plan_index 
 * @param subscription_plan_name 
 * @param url 
 */
//@Serializable Not using right now
data class SubscriptionPlan_ (
    @SerialName("active") @Optional val active: Boolean? = null,
    @SerialName("cycle") @Optional val cycle: Int? = null,
    @SerialName("frequency") @Optional val frequency: Int? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("number_of_cycles") @Optional val numberOfCycles: Int? = null,
    @SerialName("plan_price") @Optional val planPrice: Double? = null,
    @SerialName("subscription_plan_index") @Optional val subscriptionPlanIndex: Int? = null,
    @SerialName("subscription_plan_name") @Optional val subscriptionPlanName: String? = null,
    @SerialName("url") @Optional val url: String? = null
) {

}


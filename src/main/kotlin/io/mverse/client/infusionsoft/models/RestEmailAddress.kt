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
 * @param email 
 * @param opted_in 
 * @param status 
 */
@Serializable
data class RestEmailAddress (
    @SerialName("email") val email: String,
    @SerialName("opted_in") val optedIn: Boolean,
    @SerialName("status") val status: RestEmailAddress.Status
) {

    /**
    * 
    * Values: UNENGAGED_MARKETABLE,UNCONFIRMED,CONFIRMED_LEFT_PARENTHESISLEGACYRIGHT_PARENTHESIS,CONFIRMED,UNENGAGED_NONMARKETABLE,NONMINUSMARKETABLE,LOCKDOWN,SOFT_BOUNCE,HARD_BOUNCE,OPTMINUSOUT,OPTMINUSOUTCOLON_ADMIN,OPTMINUSOUTCOLON_SYSTEM,LIST_UNSUBSCRIBE,PROVIDED_FEEDBACK,REPORTED_SPAM,INVALID_EMAIL
    */
    @Serializable(with = Status.Serializer::class)
    enum class Status(val value: String){
    
        UNENGAGED_MARKETABLE("Unengaged Marketable"),
    
        UNCONFIRMED("Unconfirmed"),
    
        CONFIRMED_LEFT_PARENTHESISLEGACYRIGHT_PARENTHESIS("Confirmed (Legacy)"),
    
        CONFIRMED("Confirmed"),
    
        UNENGAGED_NONMARKETABLE("Unengaged NonMarketable"),
    
        NONMINUSMARKETABLE("Non-marketable"),
    
        LOCKDOWN("Lockdown"),
    
        SOFT_BOUNCE("Soft Bounce"),
    
        HARD_BOUNCE("Hard Bounce"),
    
        OPTMINUSOUT("Opt-Out"),
    
        OPTMINUSOUTCOLON_ADMIN("Opt-Out: Admin"),
    
        OPTMINUSOUTCOLON_SYSTEM("Opt-Out: System"),
    
        LIST_UNSUBSCRIBE("List Unsubscribe"),
    
        PROVIDED_FEEDBACK("Provided Feedback"),
    
        REPORTED_SPAM("Reported Spam"),
    
        INVALID_EMAIL("Invalid Email");
    

      class Serializer: EnumStringSerializer<Status>(Status::class)

      override fun toString(): String = value.toString()
    }

}


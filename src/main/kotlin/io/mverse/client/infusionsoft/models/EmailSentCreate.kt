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
 * @param clicked_date 
 * @param contact_id 
 * @param headers 
 * @param html_content Base64 encoded HTML
 * @param id 
 * @param opened_date 
 * @param original_provider Provider that sent the email case insensitive, must be in list [GOOGLE, INFUSIONSOFT].  If omitted gets mapped to UNKNOWN.
 * @param original_provider_id Provider id that sent the email, must be unique when combined with provider.  If omitted a UUID without dashes is autogenerated for the record.
 * @param plain_content Base64 encoded text
 * @param received_date 
 * @param sent_date 
 * @param sent_from_address 
 * @param sent_from_reply_address 
 * @param sent_to_address 
 * @param sent_to_bcc_addresses 
 * @param sent_to_cc_addresses 
 * @param subject 
 */
@Serializable
data class EmailSentCreate (
    @SerialName("sent_to_address") val sentToAddress: String,
    @SerialName("clicked_date") @Optional val clickedDate: java.time.LocalDateTime? = null,
    @SerialName("contact_id") @Optional val contactId: Long? = null,
    @SerialName("headers") @Optional val headers: String? = null,
    /* Base64 encoded HTML */
    @SerialName("html_content") @Optional val htmlContent: String? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("opened_date") @Optional val openedDate: java.time.LocalDateTime? = null,
    /* Provider that sent the email case insensitive, must be in list [GOOGLE, INFUSIONSOFT].  If omitted gets mapped to UNKNOWN. */
    @SerialName("original_provider") @Optional val originalProvider: EmailSentCreate.OriginalProvider? = null,
    /* Provider id that sent the email, must be unique when combined with provider.  If omitted a UUID without dashes is autogenerated for the record. */
    @SerialName("original_provider_id") @Optional val originalProviderId: String? = null,
    /* Base64 encoded text */
    @SerialName("plain_content") @Optional val plainContent: String? = null,
    @SerialName("received_date") @Optional val receivedDate: java.time.LocalDateTime? = null,
    @SerialName("sent_date") @Optional val sentDate: java.time.LocalDateTime? = null,
    @SerialName("sent_from_address") @Optional val sentFromAddress: String? = null,
    @SerialName("sent_from_reply_address") @Optional val sentFromReplyAddress: String? = null,
    @SerialName("sent_to_bcc_addresses") @Optional val sentToBccAddresses: String? = null,
    @SerialName("sent_to_cc_addresses") @Optional val sentToCcAddresses: String? = null,
    @SerialName("subject") @Optional val subject: String? = null
) {

    /**
    * Provider that sent the email case insensitive, must be in list [GOOGLE, INFUSIONSOFT].  If omitted gets mapped to UNKNOWN.
    * Values: UNKNOWN,INFUSIONSOFT,MICROSOFT,GOOGLE
    */
    @Serializable(with = OriginalProvider.Serializer::class)
    enum class OriginalProvider(val value: String){
    
        UNKNOWN("UNKNOWN"),
    
        INFUSIONSOFT("INFUSIONSOFT"),
    
        MICROSOFT("MICROSOFT"),
    
        GOOGLE("GOOGLE");
    

      class Serializer: EnumStringSerializer<OriginalProvider>(OriginalProvider::class)

      override fun toString(): String = value.toString()
    }

}

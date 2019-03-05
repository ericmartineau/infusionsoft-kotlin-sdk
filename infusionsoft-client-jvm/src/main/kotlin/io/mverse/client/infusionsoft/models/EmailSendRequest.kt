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

import io.mverse.client.infusionsoft.models.EmailSendRequestAttachment

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 
 * @param address_field Email field of each Contact record to address the email to, such as 'Email', 'EmailAddress2', 'EmailAddress3' or '_CustomFieldName', defaulting to the contact's primary email
 * @param attachments Attachments to be sent with each copy of the email, maximum of 10 with size of 1MB each
 * @param contacts An array of Contact Ids to receive the email
 * @param html_content The HTML-formatted content of the email, encoded in Base64
 * @param plain_content The plain-text content of the email, encoded in Base64
 * @param subject The subject line of the email
 * @param user_id The infusionsoft user to send the email on behalf of
 */
//@Serializable Not using right now
data class EmailSendRequest (
    /* An array of Contact Ids to receive the email */
    @SerialName("contacts") val contacts: List<Long>,
    /* The subject line of the email */
    @SerialName("subject") val subject: String,
    /* The infusionsoft user to send the email on behalf of */
    @SerialName("user_id") val userId: Long,
    /* Email field of each Contact record to address the email to, such as 'Email', 'EmailAddress2', 'EmailAddress3' or '_CustomFieldName', defaulting to the contact's primary email */
    @SerialName("address_field") @Optional val addressField: String? = null,
    /* Attachments to be sent with each copy of the email, maximum of 10 with size of 1MB each */
    @SerialName("attachments") @Optional val attachments: List<EmailSendRequestAttachment>? = null,
    /* The HTML-formatted content of the email, encoded in Base64 */
    @SerialName("html_content") @Optional val htmlContent: String? = null,
    /* The plain-text content of the email, encoded in Base64 */
    @SerialName("plain_content") @Optional val plainContent: String? = null
) {

}


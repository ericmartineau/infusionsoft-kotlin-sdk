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

import io.mverse.client.infusionsoft.models.CompanyReference
import io.mverse.client.infusionsoft.models.ContactAddress
import io.mverse.client.infusionsoft.models.ContactOrigin
import io.mverse.client.infusionsoft.models.CustomFieldValue
import io.mverse.client.infusionsoft.models.EmailAddress
import io.mverse.client.infusionsoft.models.FaxNumber
import io.mverse.client.infusionsoft.models.PhoneNumber
import io.mverse.client.infusionsoft.models.Relationship
import io.mverse.client.infusionsoft.models.SocialAccount

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


import io.mverse.client.infusionsoft.infrastructure.EnumStringSerializer
/**
 * 
 * @param addresses 
 * @param anniversary 
 * @param birthday 
 * @param company 
 * @param contact_type 
 * @param custom_fields 
 * @param date_created 
 * @param email_addresses 
 * @param email_opted_in 
 * @param email_status 
 * @param family_name 
 * @param fax_numbers 
 * @param given_name 
 * @param id 
 * @param job_title 
 * @param last_updated 
 * @param lead_source_id 
 * @param middle_name 
 * @param notes 
 * @param opt_in_reason 
 * @param origin 
 * @param owner_id 
 * @param phone_numbers 
 * @param preferred_locale 
 * @param preferred_name 
 * @param prefix 
 * @param relationships 
 * @param social_accounts 
 * @param source_type 
 * @param spouse_name 
 * @param suffix 
 * @param tag_ids 
 * @param time_zone 
 * @param website 
 */
@Serializable
data class FullContact (
    @SerialName("addresses") @Optional val addresses: List<ContactAddress>? = null,
    @SerialName("anniversary") @Optional val anniversary: java.time.LocalDateTime? = null,
    @SerialName("birthday") @Optional val birthday: java.time.LocalDateTime? = null,
    @SerialName("company") @Optional val company: CompanyReference? = null,
    @SerialName("contact_type") @Optional val contactType: String? = null,
    @SerialName("custom_fields") @Optional val customFields: List<CustomFieldValue>? = null,
    @SerialName("date_created") @Optional val dateCreated: java.time.LocalDateTime? = null,
    @SerialName("email_addresses") @Optional val emailAddresses: List<EmailAddress>? = null,
    @SerialName("email_opted_in") @Optional val emailOptedIn: Boolean? = null,
    @SerialName("email_status") @Optional val emailStatus: FullContact.EmailStatus? = null,
    @SerialName("family_name") @Optional val familyName: String? = null,
    @SerialName("fax_numbers") @Optional val faxNumbers: List<FaxNumber>? = null,
    @SerialName("given_name") @Optional val givenName: String? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("job_title") @Optional val jobTitle: String? = null,
    @SerialName("last_updated") @Optional val lastUpdated: java.time.LocalDateTime? = null,
    @SerialName("lead_source_id") @Optional val leadSourceId: Long? = null,
    @SerialName("middle_name") @Optional val middleName: String? = null,
    @SerialName("notes") @Optional val notes: String? = null,
    @SerialName("opt_in_reason") @Optional val optInReason: String? = null,
    @SerialName("origin") @Optional val origin: ContactOrigin? = null,
    @SerialName("owner_id") @Optional val ownerId: Long? = null,
    @SerialName("phone_numbers") @Optional val phoneNumbers: List<PhoneNumber>? = null,
    @SerialName("preferred_locale") @Optional val preferredLocale: String? = null,
    @SerialName("preferred_name") @Optional val preferredName: String? = null,
    @SerialName("prefix") @Optional val prefix: String? = null,
    @SerialName("relationships") @Optional val relationships: List<Relationship>? = null,
    @SerialName("social_accounts") @Optional val socialAccounts: List<SocialAccount>? = null,
    @SerialName("source_type") @Optional val sourceType: FullContact.SourceType? = null,
    @SerialName("spouse_name") @Optional val spouseName: String? = null,
    @SerialName("suffix") @Optional val suffix: String? = null,
    @SerialName("tag_ids") @Optional val tagIds: List<Long>? = null,
    @SerialName("time_zone") @Optional val timeZone: String? = null,
    @SerialName("website") @Optional val website: String? = null
) {

    /**
    * 
    * Values: UNENGAGEDMARKETABLE,SINGLEOPTIN,DOUBLEOPTIN,CONFIRMED,UNENGAGEDNONMARKETABLE,NONMARKETABLE,LOCKDOWN,BOUNCE,HARDBOUNCE,MANUAL,ADMIN,SYSTEM,LISTUNSUBSCRIBE,FEEDBACK,SPAM,INVALID
    */
    @Serializable(with = EmailStatus.Serializer::class)
    enum class EmailStatus(val value: String){
    
        UNENGAGEDMARKETABLE("UnengagedMarketable"),
    
        SINGLEOPTIN("SingleOptIn"),
    
        DOUBLEOPTIN("DoubleOptin"),
    
        CONFIRMED("Confirmed"),
    
        UNENGAGEDNONMARKETABLE("UnengagedNonMarketable"),
    
        NONMARKETABLE("NonMarketable"),
    
        LOCKDOWN("Lockdown"),
    
        BOUNCE("Bounce"),
    
        HARDBOUNCE("HardBounce"),
    
        MANUAL("Manual"),
    
        ADMIN("Admin"),
    
        SYSTEM("System"),
    
        LISTUNSUBSCRIBE("ListUnsubscribe"),
    
        FEEDBACK("Feedback"),
    
        SPAM("Spam"),
    
        INVALID("Invalid");
    

      class Serializer: EnumStringSerializer<EmailStatus>(EmailStatus::class)

      override fun toString(): String = value.toString()
    }

    /**
    * 
    * Values: WEBFORM,LANDINGPAGE,IMPORT,MANUAL,API,OTHER,UNKNOWN
    */
    @Serializable(with = SourceType.Serializer::class)
    enum class SourceType(val value: String){
    
        WEBFORM("WEBFORM"),
    
        LANDINGPAGE("LANDINGPAGE"),
    
        IMPORT("IMPORT"),
    
        MANUAL("MANUAL"),
    
        API("API"),
    
        OTHER("OTHER"),
    
        UNKNOWN("UNKNOWN");
    

      class Serializer: EnumStringSerializer<SourceType>(SourceType::class)

      override fun toString(): String = value.toString()
    }

}


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

import io.mverse.client.infusionsoft.models.CustomFieldOption

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


import io.mverse.client.infusionsoft.infrastructure.EnumStringSerializer
/**
 * 
 * @param field_type 
 * @param id 
 * @param label 
 * @param options 
 * @param record_type 
 */
//@Serializable Not using right now
data class CustomFieldMetaData (
    @SerialName("field_type") @Optional val fieldType: CustomFieldMetaData.FieldType? = null,
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("label") @Optional val label: String? = null,
    @SerialName("options") @Optional val options: List<CustomFieldOption>? = null,
    @SerialName("record_type") @Optional val recordType: CustomFieldMetaData.RecordType? = null
) {

    /**
    * 
    * Values: CURRENCY,DATE,DATETIME,DAYOFWEEK,DRILLDOWN,EMAIL,MONTH,LISTBOX,NAME,WHOLENUMBER,DECIMALNUMBER,PERCENT,PHONENUMBER,RADIO,DROPDOWN,SOCIALSECURITYNUMBER,STATE,TEXT,TEXTAREA,USER,USERLISTBOX,WEBSITE,YEAR,YESNO
    */
    @Serializable(with = FieldType.Serializer::class)
    enum class FieldType(val value: String){
    
        CURRENCY("Currency"),
    
        DATE("Date"),
    
        DATETIME("DateTime"),
    
        DAYOFWEEK("DayOfWeek"),
    
        DRILLDOWN("Drilldown"),
    
        EMAIL("Email"),
    
        MONTH("Month"),
    
        LISTBOX("ListBox"),
    
        NAME("Name"),
    
        WHOLENUMBER("WholeNumber"),
    
        DECIMALNUMBER("DecimalNumber"),
    
        PERCENT("Percent"),
    
        PHONENUMBER("PhoneNumber"),
    
        RADIO("Radio"),
    
        DROPDOWN("Dropdown"),
    
        SOCIALSECURITYNUMBER("SocialSecurityNumber"),
    
        STATE("State"),
    
        TEXT("Text"),
    
        TEXTAREA("TextArea"),
    
        USER("User"),
    
        USERLISTBOX("UserListBox"),
    
        WEBSITE("Website"),
    
        YEAR("Year"),
    
        YESNO("YesNo");
    

      class Serializer: EnumStringSerializer<FieldType>(FieldType::class)

      override fun toString(): String = value.toString()
    }

    /**
    * 
    * Values: CONTACT,REFERRAL_PARTNER,OPPORTUNITY,TASK_APPOINTMENT,COMPANY,ORDER,SUBSCRIPTION
    */
    @Serializable(with = RecordType.Serializer::class)
    enum class RecordType(val value: String){
    
        CONTACT("CONTACT"),
    
        REFERRAL_PARTNER("REFERRAL_PARTNER"),
    
        OPPORTUNITY("OPPORTUNITY"),
    
        TASK_APPOINTMENT("TASK_APPOINTMENT"),
    
        COMPANY("COMPANY"),
    
        ORDER("ORDER"),
    
        SUBSCRIPTION("SUBSCRIPTION");
    

      class Serializer: EnumStringSerializer<RecordType>(RecordType::class)

      override fun toString(): String = value.toString()
    }

}


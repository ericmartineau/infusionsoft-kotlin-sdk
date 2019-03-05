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

import io.mverse.client.infusionsoft.models.CreateRestCustomFieldOption

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


import io.mverse.client.infusionsoft.infrastructure.EnumStringSerializer
/**
 * 
 * @param field_type 
 * @param group_id An optional tab group to place the field under in the interface.  If not specified, will default to the 'Custom Fields' tab.
 * @param label 
 * @param options 
 * @param user_group_id An optional user group to choose from when selecting values for User or UserListBox fields.
 */
@Serializable
data class CreateRestCustomField (
    @SerialName("field_type") val fieldType: CreateRestCustomField.FieldType,
    @SerialName("label") val label: String,
    /* An optional tab group to place the field under in the interface.  If not specified, will default to the 'Custom Fields' tab. */
    @SerialName("group_id") @Optional val groupId: Long? = null,
    @SerialName("options") @Optional val options: List<CreateRestCustomFieldOption>? = null,
    /* An optional user group to choose from when selecting values for User or UserListBox fields. */
    @SerialName("user_group_id") @Optional val userGroupId: Long? = null
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

}


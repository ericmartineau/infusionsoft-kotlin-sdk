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
 * @param id 
 * @param name 
 * @param next_item_id 
 * @param previous_item_id 
 * @param type 
 */
@Serializable
data class Item (
    @SerialName("id") @Optional val id: Long? = null,
    @SerialName("name") @Optional val name: String? = null,
    @SerialName("next_item_id") @Optional val nextItemId: Long? = null,
    @SerialName("previous_item_id") @Optional val previousItemId: Long? = null,
    @SerialName("type") @Optional val type: Item.Type? = null
) {

    /**
    * 
    * Values: NULL,START,WAIT,DELAYTIMER,CONTACTTIMER,DATETIMER,EMAIL,BARDEMAIL,EMAILCONFIRM,VOICE,FAX,LETTER,TAG,OPPORTUNITY,NOTE,TASK,COMPLETETASKS,APPOINTMENT,ASSIGNOWNER,FIELDVALUE,FULFILLMENT,CREATEORDER,HTTP,CUSTOMERHUB,ACTIONSET
    */
    @Serializable(with = Type.Serializer::class)
    enum class Type(val value: String){
    
        NULL("NULL"),
    
        START("Start"),
    
        WAIT("Wait"),
    
        DELAYTIMER("DelayTimer"),
    
        CONTACTTIMER("ContactTimer"),
    
        DATETIMER("DateTimer"),
    
        EMAIL("Email"),
    
        BARDEMAIL("BardEmail"),
    
        EMAILCONFIRM("EmailConfirm"),
    
        VOICE("Voice"),
    
        FAX("Fax"),
    
        LETTER("Letter"),
    
        TAG("Tag"),
    
        OPPORTUNITY("Opportunity"),
    
        NOTE("Note"),
    
        TASK("Task"),
    
        COMPLETETASKS("CompleteTasks"),
    
        APPOINTMENT("Appointment"),
    
        ASSIGNOWNER("AssignOwner"),
    
        FIELDVALUE("FieldValue"),
    
        FULFILLMENT("Fulfillment"),
    
        CREATEORDER("CreateOrder"),
    
        HTTP("Http"),
    
        CUSTOMERHUB("CustomerHub"),
    
        ACTIONSET("ActionSet");
    

      class Serializer: EnumStringSerializer<Type>(Type::class)

      override fun toString(): String = value.toString()
    }

}

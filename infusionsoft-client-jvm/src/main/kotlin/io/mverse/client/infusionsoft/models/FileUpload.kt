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


import io.mverse.client.infusionsoft.infrastructure.EnumStringSerializer
/**
 * 
 * @param file_name 
 * @param file_data 
 * @param contact_id 
 * @param is_public 
 * @param file_association 
 */
@Serializable
data class FileUpload (
    @SerialName("file_name") val fileName: String,
    @SerialName("file_data") val fileData: String,
    @SerialName("contact_id") val contactId: Long,
    @SerialName("is_public") val isPublic: Boolean,
    @SerialName("file_association") val fileAssociation: FileUpload.FileAssociation
) {

    /**
    * 
    * Values: CONTACT,USER,COMPANY
    */
    @Serializable(with = FileAssociation.Serializer::class)
    enum class FileAssociation(val value: String){
    
        CONTACT("CONTACT"),
    
        USER("USER"),
    
        COMPANY("COMPANY");
    

      class Serializer: EnumStringSerializer<FileAssociation>(FileAssociation::class)

      override fun toString(): String = value.toString()
    }

}


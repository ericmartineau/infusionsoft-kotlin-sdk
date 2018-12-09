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
 * @param name 
 * @param type 
 */
@Serializable
data class SocialAccount (
    @SerialName("name") @Optional val name: String? = null,
    @SerialName("type") @Optional val type: SocialAccount.Type? = null
) {

    /**
    * 
    * Values: FACEBOOK,TWITTER,LINKEDIN
    */
    @Serializable(with = Type.Serializer::class)
    enum class Type(val value: String){
    
        FACEBOOK("Facebook"),
    
        TWITTER("Twitter"),
    
        LINKEDIN("LinkedIn");
    

      class Serializer: EnumStringSerializer<Type>(Type::class)

      override fun toString(): String = value.toString()
    }

}

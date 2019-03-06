@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.Setting


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.client.request.header

interface SettingApi {

  /**
    *  Retrieve application status
    *  Retrieves whether the application is enabled
    *  * @return Setting
    */
  suspend fun getApplicationEnabled() : Setting
    
  /**
    *  List Contact types
    *  Lists the Contact types in a comma-separated list
    *  * @return Setting
    */
  suspend fun getContactOptionTypes() : Setting
    
}

class SettingApiImpl(bearerToken:String, basePath: String, gson: Gson) : SettingApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve application status
    *  Retrieves whether the application is enabled
    *  * @return Setting
    */
  override suspend fun getApplicationEnabled() : Setting {
    val call = request( "/setting/application/enabled", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

  /**
    *  List Contact types
    *  Lists the Contact types in a comma-separated list
    *  * @return Setting
    */
  override suspend fun getContactOptionTypes() : Setting {
    val call = request( "/setting/contact/optionTypes", mapOf()) {
      method = HttpMethod.parse("GET")
    }
    return call.receive()
  }

}
   

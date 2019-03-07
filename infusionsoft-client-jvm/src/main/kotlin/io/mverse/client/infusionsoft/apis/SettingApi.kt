@file:Suppress("USELESS_ELVIS", "SENSELESS_COMPARISON")
package io.mverse.client.infusionsoft.apis

import io.mverse.client.infusionsoft.models.Error
import io.mverse.client.infusionsoft.models.Setting


import io.mverse.client.infusionsoft.infrastructure.*
import com.google.gson.Gson
import io.ktor.client.call.receive
import io.ktor.client.utils.EmptyContent
import io.ktor.http.contentType
import io.ktor.http.ContentType.*
import io.ktor.http.HttpMethod
import io.ktor.client.request.header
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async


interface SettingApi {

  /**
    *  Retrieve application status
    *  Retrieves whether the application is enabled
    *  * @return Setting
    */
  suspend fun getApplicationEnabled() : Setting
  
  /**
    *  Asynchronous implementation of Retrieve application status
    *  Retrieves whether the application is enabled
    *  * @return A deferred reference to the final Setting  
    */
  fun getApplicationEnabledAsync() : Deferred<Setting>

  /**
    *  List Contact types
    *  Lists the Contact types in a comma-separated list
    *  * @return Setting
    */
  suspend fun getContactOptionTypes() : Setting
  
  /**
    *  Asynchronous implementation of List Contact types
    *  Lists the Contact types in a comma-separated list
    *  * @return A deferred reference to the final Setting  
    */
  fun getContactOptionTypesAsync() : Deferred<Setting>

}

class SettingApiImpl(bearerToken:String, basePath: String, gson: Gson) : SettingApi, KtorApiTransport(basePath, bearerToken, gson) {

  /**
    *  Retrieve application status
    *  Retrieves whether the application is enabled
    *  * @return Setting
    */
  override suspend fun getApplicationEnabled() : Setting {
    val uri = uriTemplate("/setting/application/enabled")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of Retrieve application status
    *  Retrieves whether the application is enabled
    *  * @return A deferred reference to the final Setting  
    */
  override fun getApplicationEnabledAsync()  = 
        client.async { getApplicationEnabled() }

  /**
    *  List Contact types
    *  Lists the Contact types in a comma-separated list
    *  * @return Setting
    */
  override suspend fun getContactOptionTypes() : Setting {
    val uri = uriTemplate("/setting/contact/optionTypes")
      .build()
    val call = get(uri) {
    }
    return call.receive()
  }
  
  /**
    *  Asynchronous implementation of List Contact types
    *  Lists the Contact types in a comma-separated list
    *  * @return A deferred reference to the final Setting  
    */
  override fun getContactOptionTypesAsync()  = 
        client.async { getContactOptionTypes() }

}
   

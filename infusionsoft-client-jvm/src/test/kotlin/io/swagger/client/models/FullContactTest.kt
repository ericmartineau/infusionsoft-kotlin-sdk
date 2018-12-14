package io.swagger.client.models

import io.mverse.client.infusionsoft.infrastructure.AccessTokenGenerator
import io.mverse.client.infusionsoft.infrastructure.InfusionsoftClient
import io.mverse.client.infusionsoft.infrastructure.OAuthToken
import io.mverse.client.infusionsoft.infrastructure.json
import io.mverse.client.infusionsoft.models.ContactList
import kotlinx.serialization.ImplicitReflectionSerializer
import org.junit.Test
import java.time.OffsetDateTime

internal class FullContactTest {
  @ImplicitReflectionSerializer
  @Test
  fun testSerialization() {
    val contactsAsString = "{\"contacts\":[{\"email_addresses\":[{\"email\":\"paul_grover@gmail.com\",\"field\":\"EMAIL1\"}],\"email_opted_in\":true,\"addresses\":[],\"last_updated\":\"2018-12-08T22:49:29.000+0000\",\"tag_ids\":[],\"owner_id\":null,\"date_created\":\"2018-12-08T22:49:29.000+0000\",\"middle_name\":null,\"given_name\":\"Paul\",\"email_status\":\"SingleOptIn\",\"phone_numbers\":[{\"number\":\"(480) 227-4399\",\"extension\":\"\",\"field\":\"PHONE1\",\"type\":\"MOBILE\"}],\"company\":null,\"id\":5,\"family_name\":\"Grover\"}],\"count\":1,\"next\":\"https://api.infusionsoft.com/crm/rest/v1/contacts/?limit=1&offset=20&order=date_created&email=paul_grover@gmail.com\",\"previous\":\"https://api.infusionsoft.com/crm/rest/v1/contacts/?limit=20&offset=0&order=date_created&email=paul_grover@gmail.com\"}"

//    val sourceType:SourceType = json.parse(SourceType::class.serializer(), "WEBrFORM")

    val list: ContactList = json.parse(ContactList.serializer(), contactsAsString)

  }
  @ImplicitReflectionSerializer
  @Test
  fun testAPICall() {
    val token = OAuthToken("cskmpyahsqtbs6je657723pb", "cskmpyahsqtbs6je657723pb", OffsetDateTime.now().plusDays(10))
    val infusionsoft = InfusionsoftClient(token, object: AccessTokenGenerator {
      override fun accessToken(auth: OAuthToken, baseUrl: String): String {
        return auth.accessToken
      }
    })
    val userInfo = infusionsoft.userInfoApi.getUserInfo()
    val found = infusionsoft.contactApi.listContacts(limit = 30, offset = 0, order = "id",
        orderDirection = "descending",
        email = "paul_grover@gmail.com")
    found.contacts!!.size
  }
}

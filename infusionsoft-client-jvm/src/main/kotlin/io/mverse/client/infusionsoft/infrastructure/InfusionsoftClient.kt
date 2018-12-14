package io.mverse.client.infusionsoft.infrastructure

import io.mverse.client.infusionsoft.apis.*
import java.time.OffsetDateTime


class InfusionsoftClient(private val auth: OAuthToken,
                         private val tokenGenerator: AccessTokenGenerator,
                         private val baseUrl: String = "https://api.infusionsoft.com/crm/rest/v1") {

  val accountInfoApi: AccountInfoApi get() = AccountInfoApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val affiliateApi: AffiliateApi get() = AffiliateApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val appointmentApi: AppointmentApi get() = AppointmentApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val campaignApi: CampaignApi get() = CampaignApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val companyApi: CompanyApi get() = CompanyApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val contactApi: ContactApi get() = ContactApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val eCommerceApi: ECommerceApi get() = ECommerceApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val emailApi: EmailApi get() = EmailApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val emailAddressApi: EmailAddressApi get() = EmailAddressApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val fileApi: FileApi get() = FileApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val localeApi: LocaleApi get() = LocaleApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val merchantApi: MerchantApi get() = MerchantApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val noteApi: NoteApi get() = NoteApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val opportunityApi: OpportunityApi get() = OpportunityApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val productApi: ProductApi get() = ProductApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val rESTHooksApi: RESTHooksApi get() = RESTHooksApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val settingApi: SettingApi get() = SettingApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val tagsApi: TagsApi get() = TagsApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val taskApi: TaskApi get() = TaskApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val userInfoApi: UserInfoApi get() = UserInfoApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))
  val usersApi: UsersApi get() = UsersApi(bearerToken=tokenGenerator.accessToken(auth, baseUrl))

}

data class OAuthToken(val accessToken:String, val refreshToken: String, val expiry: OffsetDateTime)

interface AccessTokenGenerator {
  fun accessToken(auth:OAuthToken, baseUrl: String): String
}
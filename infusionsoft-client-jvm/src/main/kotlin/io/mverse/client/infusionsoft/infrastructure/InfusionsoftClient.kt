package io.mverse.client.infusionsoft.infrastructure

import io.mverse.client.infusionsoft.apis.*
import com.google.gson.FieldNamingPolicy.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder


data class InfusionsoftClient(private val auth: OAuthToken,
                         private val tokenGenerator: AccessTokenGenerator,
                         private val basePath: String = "https://api.infusionsoft.com/crm/rest/v1",
                         private val gson: Gson = defaultGson()) {

  val accountInfoApi: AccountInfoApi get() = AccountInfoApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val affiliateApi: AffiliateApi get() = AffiliateApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val appointmentApi: AppointmentApi get() = AppointmentApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val campaignApi: CampaignApi get() = CampaignApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val companyApi: CompanyApi get() = CompanyApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val contactApi: ContactApi get() = ContactApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val eCommerceApi: ECommerceApi get() = ECommerceApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val emailApi: EmailApi get() = EmailApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val emailAddressApi: EmailAddressApi get() = EmailAddressApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val fileApi: FileApi get() = FileApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val localeApi: LocaleApi get() = LocaleApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val merchantApi: MerchantApi get() = MerchantApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val noteApi: NoteApi get() = NoteApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val opportunityApi: OpportunityApi get() = OpportunityApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val productApi: ProductApi get() = ProductApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val rESTHooksApi: RESTHooksApi get() = RESTHooksApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val settingApi: SettingApi get() = SettingApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val tagsApi: TagsApi get() = TagsApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val taskApi: TaskApi get() = TaskApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val userInfoApi: UserInfoApi get() = UserInfoApi(bearerToken=bearerToken, basePath=basePath, gson=gson)
  val usersApi: UsersApi get() = UsersApi(bearerToken=bearerToken, basePath=basePath, gson=gson)

  private val bearerToken: String get() = tokenGenerator.accessToken(auth, basePath)

  companion object {
    fun defaultGson():Gson = GsonBuilder()
      .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
      .create()
  }

}
package io.mverse.client.infusionsoft.infrastructure

import io.mverse.client.infusionsoft.apis.*
import com.google.gson.FieldNamingPolicy.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder

interface InfusionsoftClient {
  val accountInfoApi: AccountInfoApi
  val affiliateApi: AffiliateApi
  val appointmentApi: AppointmentApi
  val campaignApi: CampaignApi
  val companyApi: CompanyApi
  val contactApi: ContactApi
  val eCommerceApi: ECommerceApi
  val emailApi: EmailApi
  val emailAddressApi: EmailAddressApi
  val fileApi: FileApi
  val localeApi: LocaleApi
  val merchantApi: MerchantApi
  val noteApi: NoteApi
  val opportunityApi: OpportunityApi
  val productApi: ProductApi
  val rESTHooksApi: RESTHooksApi
  val settingApi: SettingApi
  val tagsApi: TagsApi
  val taskApi: TaskApi
  val userInfoApi: UserInfoApi
  val usersApi: UsersApi
}

data class InfusionsoftClientImpl(private val auth: OAuthToken,
                         private val tokenGenerator: AccessTokenGenerator,
                         private val basePath: String = "https://api.infusionsoft.com/crm/rest/v1",
                         private val gson: Gson = defaultGson()): InfusionsoftClient {

  override val accountInfoApi: AccountInfoApi get() = AccountInfoApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val affiliateApi: AffiliateApi get() = AffiliateApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val appointmentApi: AppointmentApi get() = AppointmentApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val campaignApi: CampaignApi get() = CampaignApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val companyApi: CompanyApi get() = CompanyApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val contactApi: ContactApi get() = ContactApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val eCommerceApi: ECommerceApi get() = ECommerceApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val emailApi: EmailApi get() = EmailApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val emailAddressApi: EmailAddressApi get() = EmailAddressApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val fileApi: FileApi get() = FileApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val localeApi: LocaleApi get() = LocaleApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val merchantApi: MerchantApi get() = MerchantApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val noteApi: NoteApi get() = NoteApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val opportunityApi: OpportunityApi get() = OpportunityApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val productApi: ProductApi get() = ProductApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val rESTHooksApi: RESTHooksApi get() = RESTHooksApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val settingApi: SettingApi get() = SettingApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val tagsApi: TagsApi get() = TagsApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val taskApi: TaskApi get() = TaskApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val userInfoApi: UserInfoApi get() = UserInfoApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)
  override val usersApi: UsersApi get() = UsersApiImpl(bearerToken=bearerToken, basePath=basePath, gson=gson)

  private val bearerToken: String get() = tokenGenerator.accessToken(auth, basePath)

  companion object {
    fun defaultGson():Gson = GsonBuilder()
      .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
      .create()
  }
}

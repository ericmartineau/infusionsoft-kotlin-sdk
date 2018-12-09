
# FullContact

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addresses** | [**List&lt;ContactAddress&gt;**](ContactAddress.md) |  |  [optional]
**anniversary** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**birthday** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**company** | [**CompanyReference**](CompanyReference.md) |  |  [optional]
**contact_type** | **String** |  |  [optional]
**custom_fields** | [**List&lt;CustomFieldValue&gt;**](CustomFieldValue.md) |  |  [optional]
**date_created** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**email_addresses** | [**List&lt;EmailAddress&gt;**](EmailAddress.md) |  |  [optional]
**email_opted_in** | **Boolean** |  |  [optional]
**email_status** | [**inline**](#Email_statusEnum) |  |  [optional]
**family_name** | **String** |  |  [optional]
**fax_numbers** | [**List&lt;FaxNumber&gt;**](FaxNumber.md) |  |  [optional]
**given_name** | **String** |  |  [optional]
**id** | **Long** |  |  [optional]
**job_title** | **String** |  |  [optional]
**last_updated** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**lead_source_id** | **Long** |  |  [optional]
**middle_name** | **String** |  |  [optional]
**notes** | **String** |  |  [optional]
**opt_in_reason** | **String** |  |  [optional]
**origin** | [**ContactOrigin**](ContactOrigin.md) |  |  [optional]
**owner_id** | **Long** |  |  [optional]
**phone_numbers** | [**List&lt;PhoneNumber&gt;**](PhoneNumber.md) |  |  [optional]
**preferred_locale** | **String** |  |  [optional]
**preferred_name** | **String** |  |  [optional]
**prefix** | **String** |  |  [optional]
**relationships** | [**List&lt;Relationship&gt;**](Relationship.md) |  |  [optional]
**social_accounts** | [**List&lt;SocialAccount&gt;**](SocialAccount.md) |  |  [optional]
**source_type** | [**inline**](#Source_typeEnum) |  |  [optional]
**spouse_name** | **String** |  |  [optional]
**suffix** | **String** |  |  [optional]
**tag_ids** | **List&lt;Long&gt;** |  |  [optional]
**time_zone** | **String** |  |  [optional]
**website** | **String** |  |  [optional]


<a name="Email_statusEnum"></a>
## Enum: email_status
Name | Value
---- | -----
email_status | UnengagedMarketable, SingleOptIn, DoubleOptin, Confirmed, UnengagedNonMarketable, NonMarketable, Lockdown, Bounce, HardBounce, Manual, Admin, System, ListUnsubscribe, Feedback, Spam, Invalid


<a name="Source_typeEnum"></a>
## Enum: source_type
Name | Value
---- | -----
source_type | WEBFORM, LANDINGPAGE, IMPORT, MANUAL, API, OTHER, UNKNOWN




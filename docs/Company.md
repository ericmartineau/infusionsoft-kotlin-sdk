
# Company

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | [**CompanyAddress**](CompanyAddress.md) |  |  [optional]
**company_name** | **String** |  |  [optional]
**custom_fields** | [**List&lt;CustomFieldValue&gt;**](CustomFieldValue.md) |  |  [optional]
**email_address** | **String** |  |  [optional]
**email_opted_in** | **Boolean** |  |  [optional]
**email_status** | [**inline**](#Email_statusEnum) |  |  [optional]
**fax_number** | [**CompanyFaxNumber**](CompanyFaxNumber.md) |  |  [optional]
**id** | **Long** |  |  [optional]
**notes** | **String** |  |  [optional]
**phone_number** | [**CompanyPhoneNumber**](CompanyPhoneNumber.md) |  |  [optional]
**website** | **String** |  |  [optional]


<a name="Email_statusEnum"></a>
## Enum: email_status
Name | Value
---- | -----
email_status | UnengagedMarketable, SingleOptIn, DoubleOptin, Confirmed, UnengagedNonMarketable, NonMarketable, Lockdown, Bounce, HardBounce, Manual, Admin, System, ListUnsubscribe, Feedback, Spam, Invalid




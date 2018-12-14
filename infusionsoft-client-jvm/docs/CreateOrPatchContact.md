
# CreateOrPatchContact

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addresses** | [**List&lt;ContactAddress&gt;**](ContactAddress.md) |  |  [optional]
**anniversary** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**birthday** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**company** | [**RequestCompanyReference**](RequestCompanyReference.md) |  |  [optional]
**contact_type** | **String** |  |  [optional]
**custom_fields** | [**List&lt;CustomFieldValue&gt;**](CustomFieldValue.md) |  |  [optional]
**email_addresses** | [**List&lt;EmailAddress&gt;**](EmailAddress.md) |  |  [optional]
**family_name** | **String** |  |  [optional]
**fax_numbers** | [**List&lt;FaxNumber&gt;**](FaxNumber.md) |  |  [optional]
**given_name** | **String** |  |  [optional]
**job_title** | **String** |  |  [optional]
**lead_source_id** | **Long** |  |  [optional]
**middle_name** | **String** |  |  [optional]
**notes** | **String** |  |  [optional]
**opt_in_reason** | **String** |  |  [optional]
**origin** | [**CreateContactOrigin**](CreateContactOrigin.md) |  |  [optional]
**owner_id** | **Long** |  |  [optional]
**phone_numbers** | [**List&lt;PhoneNumber&gt;**](PhoneNumber.md) |  |  [optional]
**preferred_locale** | **String** |  |  [optional]
**preferred_name** | **String** |  |  [optional]
**prefix** | **String** |  |  [optional]
**social_accounts** | [**List&lt;SocialAccount&gt;**](SocialAccount.md) |  |  [optional]
**source_type** | [**inline**](#Source_typeEnum) |  |  [optional]
**spouse_name** | **String** |  |  [optional]
**suffix** | **String** |  |  [optional]
**time_zone** | **String** |  |  [optional]
**website** | **String** |  |  [optional]


<a name="Source_typeEnum"></a>
## Enum: source_type
Name | Value
---- | -----
source_type | WEBFORM, LANDINGPAGE, IMPORT, MANUAL, API, OTHER, UNKNOWN




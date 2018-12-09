
# EmailSentQueryResult

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clicked_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**contact_id** | **Long** |  |  [optional]
**headers** | **String** |  |  [optional]
**id** | **Long** |  |  [optional]
**opened_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**original_provider** | [**inline**](#Original_providerEnum) |  |  [optional]
**original_provider_id** | **String** |  |  [optional]
**received_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**sent_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**sent_from_address** | **String** |  |  [optional]
**sent_from_reply_address** | **String** |  |  [optional]
**sent_to_address** | **String** |  |  [optional]
**sent_to_bcc_addresses** | **String** |  |  [optional]
**sent_to_cc_addresses** | **String** |  |  [optional]
**subject** | **String** |  |  [optional]


<a name="Original_providerEnum"></a>
## Enum: original_provider
Name | Value
---- | -----
original_provider | UNKNOWN, INFUSIONSOFT, MICROSOFT, GOOGLE




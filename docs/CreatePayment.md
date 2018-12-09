
# CreatePayment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**apply_to_commissions** | **Boolean** |  |  [optional]
**charge_now** | **Boolean** |  |  [optional]
**credit_card_id** | **Long** |  |  [optional]
**date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) | Used when charge_now:false or inserting historical data. ex &#x60;2017-01-01T22:17:59.039Z&#x60; |  [optional]
**notes** | **String** |  |  [optional]
**payment_amount** | **Double** |  |  [optional]
**payment_gateway_id** | **String** |  |  [optional]
**payment_method_type** | [**inline**](#Payment_method_typeEnum) |  |  [optional]


<a name="Payment_method_typeEnum"></a>
## Enum: payment_method_type
Name | Value
---- | -----
payment_method_type | CREDIT_CARD, CASH, CHECK




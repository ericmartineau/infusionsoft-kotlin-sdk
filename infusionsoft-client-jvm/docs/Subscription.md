
# Subscription

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** |  |  [optional]
**auto_charge** | **Boolean** |  |  [optional]
**billing_amount** | **Double** |  |  [optional]
**billing_cycle** | [**inline**](#Billing_cycleEnum) |  |  [optional]
**billing_frequency** | **Int** |  |  [optional]
**contact_id** | **Long** |  |  [optional]
**credit_card_id** | **Long** |  |  [optional]
**end_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**id** | **Long** |  |  [optional]
**next_bill_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**payment_gateway_id** | **Long** |  |  [optional]
**product_id** | **Long** |  |  [optional]
**quantity** | **Long** |  |  [optional]
**start_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**subscription_plan_id** | **Long** |  |  [optional]
**use_default_payment_gateway** | **Boolean** |  |  [optional]


<a name="Billing_cycleEnum"></a>
## Enum: billing_cycle
Name | Value
---- | -----
billing_cycle | YEAR, MONTH, WEEK, DAY




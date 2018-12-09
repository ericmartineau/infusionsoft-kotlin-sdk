
# CreateOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contact_id** | **Long** |  | 
**lead_affiliate_id** | **Long** |  |  [optional]
**order_date** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  | 
**order_items** | [**List&lt;CreateOrderItem&gt;**](CreateOrderItem.md) |  | 
**order_title** | **String** |  | 
**order_type** | [**inline**](#Order_typeEnum) |  | 
**promo_codes** | **List&lt;String&gt;** | Uses multiple strings as promo codes. The corresponding discount will be applied to the order. |  [optional]
**sales_affiliate_id** | **Long** |  |  [optional]
**shipping_address** | [**AddressInformation**](AddressInformation.md) |  |  [optional]


<a name="Order_typeEnum"></a>
## Enum: order_type
Name | Value
---- | -----
order_type | Offline, Online





# CreateRestCustomField

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**field_type** | [**inline**](#Field_typeEnum) |  | 
**group_id** | **Long** | An optional tab group to place the field under in the interface.  If not specified, will default to the &#39;Custom Fields&#39; tab. |  [optional]
**label** | **String** |  | 
**options** | [**List&lt;CreateRestCustomFieldOption&gt;**](CreateRestCustomFieldOption.md) |  |  [optional]
**user_group_id** | **Long** | An optional user group to choose from when selecting values for User or UserListBox fields. |  [optional]


<a name="Field_typeEnum"></a>
## Enum: field_type
Name | Value
---- | -----
field_type | Currency, Date, DateTime, DayOfWeek, Drilldown, Email, Month, ListBox, Name, WholeNumber, DecimalNumber, Percent, PhoneNumber, Radio, Dropdown, SocialSecurityNumber, State, Text, TextArea, User, UserListBox, Website, Year, YesNo




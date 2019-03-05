
# ContactAddress

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**country_code** | **String** |  |  [optional]
**field** | [**inline**](#FieldEnum) |  | 
**line1** | **String** |  |  [optional]
**line2** | **String** |  |  [optional]
**locality** | **String** |  |  [optional]
**postal_code** | **String** | Field used to store postal codes containing a combination of letters and numbers ex. &#39;EC1A&#39;, &#39;S1 2HE&#39;, &#39;75000&#39; |  [optional]
**region** | **String** |  |  [optional]
**zip_code** | **String** | Mainly used in the United States, this is typically numeric. ex. &#39;85001&#39;, &#39;90002&#39; Note: this is to be used instead of &#39;postal_code&#39;, not in addition to. |  [optional]
**zip_four** | **String** | Last four of a full zip code ex. &#39;8244&#39;, &#39;4320&#39;. This field is supplemental to the zip_code field, otherwise will be ignored. |  [optional]


<a name="FieldEnum"></a>
## Enum: field
Name | Value
---- | -----
field | BILLING, SHIPPING, OTHER




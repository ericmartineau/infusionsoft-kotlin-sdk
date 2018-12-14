
# EmailSendRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address_field** | **String** | Email field of each Contact record to address the email to, such as &#39;Email&#39;, &#39;EmailAddress2&#39;, &#39;EmailAddress3&#39; or &#39;_CustomFieldName&#39;, defaulting to the contact&#39;s primary email |  [optional]
**attachments** | [**List&lt;EmailSendRequestAttachment&gt;**](EmailSendRequestAttachment.md) | Attachments to be sent with each copy of the email, maximum of 10 with size of 1MB each |  [optional]
**contacts** | **List&lt;Long&gt;** | An array of Contact Ids to receive the email | 
**html_content** | **String** | The HTML-formatted content of the email, encoded in Base64 |  [optional]
**plain_content** | **String** | The plain-text content of the email, encoded in Base64 |  [optional]
**subject** | **String** | The subject line of the email | 
**user_id** | **Long** | The infusionsoft user to send the email on behalf of | 




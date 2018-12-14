# CompanyApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCompany**](CompanyApi.md#createCompany) | **POST** /companies | Create a Company
[**listCompanies**](CompanyApi.md#listCompanies) | **GET** /companies | List Companies
[**retrieveCompanyModel**](CompanyApi.md#retrieveCompanyModel) | **GET** /companies/model | Retrieve Company Model
[**updatePropertiesOnContact**](CompanyApi.md#updatePropertiesOnContact) | **PATCH** /company/{companyId} | Update a Company


<a name="createCompany"></a>
# **createCompany**
> Company createCompany(company)

Create a Company

Creates a new company as the authenticated user. NB: Company must contain at least the company name. The &#x60;country_code&#x60; is required if &#x60;region&#x60; is specified.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Company gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CompanyApi()
val company : CreateOrPatchCompany =  // CreateOrPatchCompany | company
try {
    val result : Company = apiInstance.createCompany(company)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyApi#createCompany")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyApi#createCompany")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **company** | [**CreateOrPatchCompany**](CreateOrPatchCompany.md)| company | [optional]

### Return type

[**Company**](Company.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listCompanies"></a>
# **listCompanies**
> CompanyList listCompanies(limit, offset, companyName, order, orderDirection, optionalProperties)

List Companies

Retrieves a list of all companies

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CompanyApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val companyName : String = companyName_example // String | Optional company name to query on
val order : String = order_example // String | Attribute to order items by
val orderDirection : String = orderDirection_example // String | How to order the data i.e. ascending (A-Z) or descending (Z-A)
val optionalProperties : List<String> =  // List<String> | Comma-delimited list of Company properties to include in the response. (Fields such as `notes`, `fax_number` and `custom_fields` aren't included, by default.)
try {
    val result : CompanyList = apiInstance.listCompanies(limit, offset, companyName, order, orderDirection, optionalProperties)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyApi#listCompanies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyApi#listCompanies")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **companyName** | **String**| Optional company name to query on | [optional]
 **order** | **String**| Attribute to order items by | [optional] [enum: id, date_created, name]
 **orderDirection** | **String**| How to order the data i.e. ascending (A-Z) or descending (Z-A) | [optional] [enum: ascending, descending]
 **optionalProperties** | [**List&lt;String&gt;**](String.md)| Comma-delimited list of Company properties to include in the response. (Fields such as &#x60;notes&#x60;, &#x60;fax_number&#x60; and &#x60;custom_fields&#x60; aren&#39;t included, by default.) | [optional]

### Return type

[**CompanyList**](CompanyList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveCompanyModel"></a>
# **retrieveCompanyModel**
> ObjectModel retrieveCompanyModel()

Retrieve Company Model

Get the custom fields and optional properties for the Company object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CompanyApi()
try {
    val result : ObjectModel = apiInstance.retrieveCompanyModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyApi#retrieveCompanyModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyApi#retrieveCompanyModel")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ObjectModel**](ObjectModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePropertiesOnContact"></a>
# **updatePropertiesOnContact**
> Company updatePropertiesOnContact(companyId, company)

Update a Company

Updates a company with only the values provided in the request.  You may opt-in or mark a Company as _Marketable_ by including the following field in the request JSON with an opt-in reason. (This field is also shown in the complete request body sample.) The reason you provide here will help with compliance. Example reasons: \&quot;Customer opted-in through webform\&quot;, \&quot;Company gave explicit permission.\&quot;  &#x60;&#x60;&#x60;json \&quot;opt_in_reason\&quot;: \&quot;your reason for opt-in\&quot; &#x60;&#x60;&#x60;

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = CompanyApi()
val companyId : Long = 789 // Long | companyId
val company : CreateOrPatchCompany =  // CreateOrPatchCompany | company
try {
    val result : Company = apiInstance.updatePropertiesOnContact(companyId, company)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CompanyApi#updatePropertiesOnContact")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CompanyApi#updatePropertiesOnContact")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **companyId** | **Long**| companyId |
 **company** | [**CreateOrPatchCompany**](CreateOrPatchCompany.md)| company | [optional]

### Return type

[**Company**](Company.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# OpportunityApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createOpportunity**](OpportunityApi.md#createOpportunity) | **POST** /opportunities | Create an Opportunity
[**getOpportunity**](OpportunityApi.md#getOpportunity) | **GET** /opportunities/{opportunityId} | Retrieve an Opportunity
[**listOpportunities**](OpportunityApi.md#listOpportunities) | **GET** /opportunities | List Opportunities
[**listOpportunityStagePipelines**](OpportunityApi.md#listOpportunityStagePipelines) | **GET** /opportunity/stage_pipeline | List Opportunity Stage Pipeline
[**retrieveOpportunityModel**](OpportunityApi.md#retrieveOpportunityModel) | **GET** /opportunities/model | Retrieve Opportunity Model
[**updateOpportunity**](OpportunityApi.md#updateOpportunity) | **PUT** /opportunities | Replace an Opportunity
[**updatePropertiesOnOpportunity**](OpportunityApi.md#updatePropertiesOnOpportunity) | **PATCH** /opportunities/{opportunityId} | Update an Opportunity


<a name="createOpportunity"></a>
# **createOpportunity**
> Opportunity createOpportunity(opportunity)

Create an Opportunity

Creates a new opportunity as the authenticated user. NB: Opportunity must contain values for &#x60;opportunity_title&#x60;, &#x60;contact&#x60;, and &#x60;stage&#x60;.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
val opportunity : Opportunity =  // Opportunity | opportunity
try {
    val result : Opportunity = apiInstance.createOpportunity(opportunity)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#createOpportunity")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#createOpportunity")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **opportunity** | [**Opportunity**](Opportunity.md)| opportunity | [optional]

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOpportunity"></a>
# **getOpportunity**
> Opportunity getOpportunity(opportunityId, optionalProperties)

Retrieve an Opportunity

Retrives a single opportunity

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
val opportunityId : Long = 789 // Long | opportunityId
val optionalProperties : List<String> =  // List<String> | Comma-delimited list of Opportunity properties to include in the response. (Some fields such as `custom_fields` aren't included, by default.)
try {
    val result : Opportunity = apiInstance.getOpportunity(opportunityId, optionalProperties)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#getOpportunity")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#getOpportunity")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **opportunityId** | **Long**| opportunityId |
 **optionalProperties** | [**List&lt;String&gt;**](String.md)| Comma-delimited list of Opportunity properties to include in the response. (Some fields such as &#x60;custom_fields&#x60; aren&#39;t included, by default.) | [optional]

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listOpportunities"></a>
# **listOpportunities**
> OpportunityList listOpportunities(limit, offset, userId, stageId, searchTerm, order)

List Opportunities

Retrieves a list of all opportunities.  Please note: the sample response erroneously shows properties, such as _stage reasons_, that are unavailable through the list endpoint. Such properties are only available through the retrieve operation. Future versions of the Opportunity resource will correct the oversight.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
val limit : Int = 56 // Int | Sets a total of items to return
val offset : Int = 56 // Int | Sets a beginning range of items to return
val userId : Long = 789 // Long | Returns opportunities for the provided user id
val stageId : Long = 789 // Long | Returns opportunities for the provided stage id
val searchTerm : String = searchTerm_example // String | Returns opportunities that match any of the contact's `given_name`, `family_name`, `company_name`, and `email_addresses` (searches `EMAIL1` only) fields as well as `opportunity_title`
val order : String = order_example // String | Attribute to order items by
try {
    val result : OpportunityList = apiInstance.listOpportunities(limit, offset, userId, stageId, searchTerm, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#listOpportunities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#listOpportunities")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Int**| Sets a total of items to return | [optional]
 **offset** | **Int**| Sets a beginning range of items to return | [optional]
 **userId** | **Long**| Returns opportunities for the provided user id | [optional]
 **stageId** | **Long**| Returns opportunities for the provided stage id | [optional]
 **searchTerm** | **String**| Returns opportunities that match any of the contact&#39;s &#x60;given_name&#x60;, &#x60;family_name&#x60;, &#x60;company_name&#x60;, and &#x60;email_addresses&#x60; (searches &#x60;EMAIL1&#x60; only) fields as well as &#x60;opportunity_title&#x60; | [optional]
 **order** | **String**| Attribute to order items by | [optional] [enum: next_action, opportunity_name, contact_name, date_created]

### Return type

[**OpportunityList**](OpportunityList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listOpportunityStagePipelines"></a>
# **listOpportunityStagePipelines**
> List&lt;SalesPipeline&gt; listOpportunityStagePipelines()

List Opportunity Stage Pipeline

Retrieves a list of all opportunity stages with pipeline details

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
try {
    val result : List<SalesPipeline> = apiInstance.listOpportunityStagePipelines()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#listOpportunityStagePipelines")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#listOpportunityStagePipelines")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;SalesPipeline&gt;**](SalesPipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveOpportunityModel"></a>
# **retrieveOpportunityModel**
> ObjectModel retrieveOpportunityModel()

Retrieve Opportunity Model

Get the custom fields for the Opportunity object

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
try {
    val result : ObjectModel = apiInstance.retrieveOpportunityModel()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#retrieveOpportunityModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#retrieveOpportunityModel")
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

<a name="updateOpportunity"></a>
# **updateOpportunity**
> Opportunity updateOpportunity(opportunity)

Replace an Opportunity

Replaces all values of a given opportunity

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
val opportunity : Opportunity =  // Opportunity | opportunity
try {
    val result : Opportunity = apiInstance.updateOpportunity(opportunity)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#updateOpportunity")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#updateOpportunity")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **opportunity** | [**Opportunity**](Opportunity.md)| opportunity | [optional]

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePropertiesOnOpportunity"></a>
# **updatePropertiesOnOpportunity**
> Opportunity updatePropertiesOnOpportunity(opportunityId, opportunity)

Update an Opportunity

Updates an opportunity with only the values provided in the request.

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = OpportunityApi()
val opportunityId : Long = 789 // Long | opportunityId
val opportunity : Opportunity =  // Opportunity | opportunity
try {
    val result : Opportunity = apiInstance.updatePropertiesOnOpportunity(opportunityId, opportunity)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OpportunityApi#updatePropertiesOnOpportunity")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OpportunityApi#updatePropertiesOnOpportunity")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **opportunityId** | **Long**| opportunityId |
 **opportunity** | [**Opportunity**](Opportunity.md)| opportunity | [optional]

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


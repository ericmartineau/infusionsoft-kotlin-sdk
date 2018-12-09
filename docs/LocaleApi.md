# LocaleApi

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listCountries**](LocaleApi.md#listCountries) | **GET** /locales/countries | List Countries
[**listCountries1**](LocaleApi.md#listCountries1) | **GET** /locales/countries/{countryCode}/provinces | List a Country&#39;s Provinces


<a name="listCountries"></a>
# **listCountries**
> CountriesByCode listCountries()

List Countries

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = LocaleApi()
try {
    val result : CountriesByCode = apiInstance.listCountries()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling LocaleApi#listCountries")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling LocaleApi#listCountries")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CountriesByCode**](CountriesByCode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listCountries1"></a>
# **listCountries1**
> ProvincesByCode listCountries1(countryCode)

List a Country&#39;s Provinces

### Example
```kotlin
// Import classes:
//import io.mverse.client.infusionsoft.infrastructure.*
//import io.mverse.client.infusionsoft.models.*

val apiInstance = LocaleApi()
val countryCode : String = countryCode_example // String | countryCode
try {
    val result : ProvincesByCode = apiInstance.listCountries1(countryCode)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling LocaleApi#listCountries1")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling LocaleApi#listCountries1")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **countryCode** | **String**| countryCode |

### Return type

[**ProvincesByCode**](ProvincesByCode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# io.mverse.client.infusionsoft - Kotlin client library for Infusionsoft REST API

## Requires

* Kotlin 1.1.2
* Gradle 3.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in Swagger definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.infusionsoft.com/crm/rest/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountInfoApi* | [**getAccountProfile**](docs/AccountInfoApi.md#getaccountprofile) | **GET** /account/profile | Retrieve account profile
*AccountInfoApi* | [**updateAccountInfo**](docs/AccountInfoApi.md#updateaccountinfo) | **PUT** /account/profile | Updates an account profile
*AffiliateApi* | [**retrieveAffiliateModel**](docs/AffiliateApi.md#retrieveaffiliatemodel) | **GET** /affiliates/model | Retrieve Affiliate Model
*AffiliateApi* | [**searchCommissions**](docs/AffiliateApi.md#searchcommissions) | **GET** /affiliates/commissions | Retrieve Commissions
*AppointmentApi* | [**createAppointment**](docs/AppointmentApi.md#createappointment) | **POST** /appointments | Create an Appointment
*AppointmentApi* | [**deleteAppointment**](docs/AppointmentApi.md#deleteappointment) | **DELETE** /appointments/{appointmentId} | Delete an Appointment
*AppointmentApi* | [**getAppointment**](docs/AppointmentApi.md#getappointment) | **GET** /appointments/{appointmentId} | Retrieve an Appointment
*AppointmentApi* | [**listAppointments**](docs/AppointmentApi.md#listappointments) | **GET** /appointments | List Appointments
*AppointmentApi* | [**retrieveAppointmentModel**](docs/AppointmentApi.md#retrieveappointmentmodel) | **GET** /appointments/model | Retrieve Appointment Model
*AppointmentApi* | [**updateAppointment**](docs/AppointmentApi.md#updateappointment) | **PUT** /appointments/{appointmentId} | Replace an Appointment
*AppointmentApi* | [**updatePropertiesOnAppointment**](docs/AppointmentApi.md#updatepropertiesonappointment) | **PATCH** /appointments/{appointmentId} | Update an Appointment
*CampaignApi* | [**addContactToCampaignSequence**](docs/CampaignApi.md#addcontacttocampaignsequence) | **POST** /campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId} | Add to Campaign Sequence
*CampaignApi* | [**addContactsToCampaignSequence**](docs/CampaignApi.md#addcontactstocampaignsequence) | **POST** /campaigns/{campaignId}/sequences/{sequenceId}/contacts | Add Multiple to Campaign Sequence
*CampaignApi* | [**createAchieveApiGoalEvent**](docs/CampaignApi.md#createachieveapigoalevent) | **POST** /campaigns/goals/{integration}/{callName} | Achieve API Goal
*CampaignApi* | [**getCampaign**](docs/CampaignApi.md#getcampaign) | **GET** /campaigns/{campaignId} | Retrieve a Campaign
*CampaignApi* | [**listCampaigns**](docs/CampaignApi.md#listcampaigns) | **GET** /campaigns | List Campaigns
*CampaignApi* | [**removeContactFromCampaignSequence**](docs/CampaignApi.md#removecontactfromcampaignsequence) | **DELETE** /campaigns/{campaignId}/sequences/{sequenceId}/contacts/{contactId} | Remove from Campaign Sequence
*CampaignApi* | [**removeContactsFromCampaignSequence**](docs/CampaignApi.md#removecontactsfromcampaignsequence) | **DELETE** /campaigns/{campaignId}/sequences/{sequenceId}/contacts | Remove Multiple from Campaign Sequence
*CompanyApi* | [**createCompany**](docs/CompanyApi.md#createcompany) | **POST** /companies | Create a Company
*CompanyApi* | [**listCompanies**](docs/CompanyApi.md#listcompanies) | **GET** /companies | List Companies
*CompanyApi* | [**retrieveCompanyModel**](docs/CompanyApi.md#retrievecompanymodel) | **GET** /companies/model | Retrieve Company Model
*CompanyApi* | [**updatePropertiesOnContact**](docs/CompanyApi.md#updatepropertiesoncontact) | **PATCH** /company/{companyId} | Update a Company
*ContactApi* | [**applyTagsToContactId**](docs/ContactApi.md#applytagstocontactid) | **POST** /contacts/{contactId}/tags | Apply Tags
*ContactApi* | [**createContact**](docs/ContactApi.md#createcontact) | **POST** /contacts | Create a Contact
*ContactApi* | [**createCreditCard**](docs/ContactApi.md#createcreditcard) | **POST** /contacts/{contactId}/creditCards | Create a Credit Card
*ContactApi* | [**createCustomField**](docs/ContactApi.md#createcustomfield) | **POST** /contacts/model/customFields | Create a Custom Field
*ContactApi* | [**createEmailForContact**](docs/ContactApi.md#createemailforcontact) | **POST** /contacts/{contactId}/emails | Create an Email Record
*ContactApi* | [**createOrUpdateContact**](docs/ContactApi.md#createorupdatecontact) | **PUT** /contacts | Create or Update a Contact
*ContactApi* | [**deleteContact**](docs/ContactApi.md#deletecontact) | **DELETE** /contacts/{contactId} | Delete a Contact
*ContactApi* | [**getContact**](docs/ContactApi.md#getcontact) | **GET** /contacts/{id} | Retrieve a Contact
*ContactApi* | [**listAppliedTags**](docs/ContactApi.md#listappliedtags) | **GET** /contacts/{contactId}/tags | List Applied Tags
*ContactApi* | [**listContacts**](docs/ContactApi.md#listcontacts) | **GET** /contacts | List Contacts
*ContactApi* | [**listCreditCards**](docs/ContactApi.md#listcreditcards) | **GET** /contacts/{contactId}/creditCards | Retrieve Credit Cards
*ContactApi* | [**listEmailsForContact**](docs/ContactApi.md#listemailsforcontact) | **GET** /contacts/{contactId}/emails | List Emails
*ContactApi* | [**removeTagsFromContact**](docs/ContactApi.md#removetagsfromcontact) | **DELETE** /contacts/{contactId}/tags | Remove Applied Tags
*ContactApi* | [**removeTagsFromContact1**](docs/ContactApi.md#removetagsfromcontact1) | **DELETE** /contacts/{contactId}/tags/{tagId} | Remove Applied Tag
*ContactApi* | [**retrieveContactModel**](docs/ContactApi.md#retrievecontactmodel) | **GET** /contacts/model | Retrieve Contact Model
*ContactApi* | [**updatePropertiesOnContact1**](docs/ContactApi.md#updatepropertiesoncontact1) | **PATCH** /contacts/{contactId} | Update a Contact
*ECommerceApi* | [**createOrder**](docs/ECommerceApi.md#createorder) | **POST** /orders | Create an Order
*ECommerceApi* | [**createOrderItemsOnOrder**](docs/ECommerceApi.md#createorderitemsonorder) | **POST** /orders/{orderId}/items | Create an Order Item
*ECommerceApi* | [**createPaymentOnOrder**](docs/ECommerceApi.md#createpaymentonorder) | **POST** /orders/{orderId}/payments | Create a Payment
*ECommerceApi* | [**deleteOrder**](docs/ECommerceApi.md#deleteorder) | **DELETE** /orders/{orderId} | Delete an Order
*ECommerceApi* | [**deleteOrderOrderItem**](docs/ECommerceApi.md#deleteorderorderitem) | **DELETE** /orders/{orderId}/items/{orderItemId} | Delete an Order Item
*ECommerceApi* | [**getOrder**](docs/ECommerceApi.md#getorder) | **GET** /orders/{orderId} | Retrieve an Order
*ECommerceApi* | [**getTransaction**](docs/ECommerceApi.md#gettransaction) | **GET** /transactions/{transactionId} | Retrieve a Transaction
*ECommerceApi* | [**listOrders**](docs/ECommerceApi.md#listorders) | **GET** /orders | List Orders
*ECommerceApi* | [**listSubscriptions**](docs/ECommerceApi.md#listsubscriptions) | **GET** /subscriptions | List Subscriptions
*ECommerceApi* | [**listTransactions**](docs/ECommerceApi.md#listtransactions) | **GET** /transactions | List Transactions
*ECommerceApi* | [**listTransactionsForOrder**](docs/ECommerceApi.md#listtransactionsfororder) | **GET** /orders/{orderId}/transactions | Retrieve Order Transactions
*ECommerceApi* | [**replacePaymentPlan**](docs/ECommerceApi.md#replacepaymentplan) | **PUT** /orders/{orderId}/paymentPlan | Replace an Order Pay Plan
*ECommerceApi* | [**retrieveOrderModel**](docs/ECommerceApi.md#retrieveordermodel) | **GET** /orders/model | Retrieve Custom Order Model
*ECommerceApi* | [**retrieveSubscriptionModel**](docs/ECommerceApi.md#retrievesubscriptionmodel) | **GET** /subscriptions/model | Retrieve Subscription Model
*EmailApi* | [**createEmail**](docs/EmailApi.md#createemail) | **POST** /emails | Create an Email Record
*EmailApi* | [**createEmails**](docs/EmailApi.md#createemails) | **POST** /emails/sync | Create a set of Email Records
*EmailApi* | [**deleteEmail**](docs/EmailApi.md#deleteemail) | **DELETE** /emails/{id} | Delete an Email Record
*EmailApi* | [**deleteEmails**](docs/EmailApi.md#deleteemails) | **POST** /emails/unsync | Un-sync a batch of Email Records
*EmailApi* | [**getEmail**](docs/EmailApi.md#getemail) | **GET** /emails/{id} | Retrieve an Email
*EmailApi* | [**listEmails**](docs/EmailApi.md#listemails) | **GET** /emails | List Emails
*EmailApi* | [**sendEmail**](docs/EmailApi.md#sendemail) | **POST** /emails/queue | Send an Email
*EmailApi* | [**updateEmail**](docs/EmailApi.md#updateemail) | **PUT** /emails/{id} | Update an Email Record
*EmailAddressApi* | [**replaceEmailAddress**](docs/EmailAddressApi.md#replaceemailaddress) | **PUT** /emailAddresses/{email} | Replace an Email Address
*FileApi* | [**createFile**](docs/FileApi.md#createfile) | **POST** /files | Upload File
*FileApi* | [**deleteFile**](docs/FileApi.md#deletefile) | **DELETE** /files/{fileId} | Delete File
*FileApi* | [**getFile**](docs/FileApi.md#getfile) | **GET** /files/{fileId} | Retrieve File
*FileApi* | [**listFiles**](docs/FileApi.md#listfiles) | **GET** /files | List Files
*FileApi* | [**updateFile**](docs/FileApi.md#updatefile) | **PUT** /files/{fileId} | Replace File
*LocaleApi* | [**listCountries**](docs/LocaleApi.md#listcountries) | **GET** /locales/countries | List Countries
*LocaleApi* | [**listCountries1**](docs/LocaleApi.md#listcountries1) | **GET** /locales/countries/{countryCode}/provinces | List a Country's Provinces
*MerchantApi* | [**getMerchantAccounts**](docs/MerchantApi.md#getmerchantaccounts) | **GET** /merchants | List Merchants
*NoteApi* | [**createNote**](docs/NoteApi.md#createnote) | **POST** /notes | Create a Note
*NoteApi* | [**deleteNote**](docs/NoteApi.md#deletenote) | **DELETE** /notes/{noteId} | Delete a Note
*NoteApi* | [**getNote**](docs/NoteApi.md#getnote) | **GET** /notes/{noteId} | Retrieve a Note
*NoteApi* | [**listNotes**](docs/NoteApi.md#listnotes) | **GET** /notes | List Notes
*NoteApi* | [**updateNote**](docs/NoteApi.md#updatenote) | **PUT** /notes/{noteId} | Replace a Note
*NoteApi* | [**updatePropertiesOnNote**](docs/NoteApi.md#updatepropertiesonnote) | **PATCH** /notes/{noteId} | Update a Note
*OpportunityApi* | [**createOpportunity**](docs/OpportunityApi.md#createopportunity) | **POST** /opportunities | Create an Opportunity
*OpportunityApi* | [**getOpportunity**](docs/OpportunityApi.md#getopportunity) | **GET** /opportunities/{opportunityId} | Retrieve an Opportunity
*OpportunityApi* | [**listOpportunities**](docs/OpportunityApi.md#listopportunities) | **GET** /opportunities | List Opportunities
*OpportunityApi* | [**listOpportunityStagePipelines**](docs/OpportunityApi.md#listopportunitystagepipelines) | **GET** /opportunity/stage_pipeline | List Opportunity Stage Pipeline
*OpportunityApi* | [**retrieveOpportunityModel**](docs/OpportunityApi.md#retrieveopportunitymodel) | **GET** /opportunities/model | Retrieve Opportunity Model
*OpportunityApi* | [**updateOpportunity**](docs/OpportunityApi.md#updateopportunity) | **PUT** /opportunities | Replace an Opportunity
*OpportunityApi* | [**updatePropertiesOnOpportunity**](docs/OpportunityApi.md#updatepropertiesonopportunity) | **PATCH** /opportunities/{opportunityId} | Update an Opportunity
*ProductApi* | [**createProduct**](docs/ProductApi.md#createproduct) | **POST** /products | Create a Product
*ProductApi* | [**createProductImage**](docs/ProductApi.md#createproductimage) | **POST** /products/{productId}/image | Upload a product image
*ProductApi* | [**createProductSubscription**](docs/ProductApi.md#createproductsubscription) | **POST** /products/{productId}/subscriptions | Create a Product Subscription
*ProductApi* | [**deleteProduct**](docs/ProductApi.md#deleteproduct) | **DELETE** /products/{productId} | Delete a Product
*ProductApi* | [**deleteProductImage**](docs/ProductApi.md#deleteproductimage) | **DELETE** /products/{productId}/image | Delete a product image
*ProductApi* | [**deleteProductSubscription**](docs/ProductApi.md#deleteproductsubscription) | **DELETE** /products/{productId}/subscriptions/{subscriptionId} | Delete a Product Subscription
*ProductApi* | [**listProducts**](docs/ProductApi.md#listproducts) | **GET** /products | List Products
*ProductApi* | [**listProductsFromSyncToken**](docs/ProductApi.md#listproductsfromsynctoken) | **GET** /products/sync | Retrieve Synced Products
*ProductApi* | [**retrieveProduct**](docs/ProductApi.md#retrieveproduct) | **GET** /products/{productId} | Retrieve a Product
*ProductApi* | [**retrieveProductSubscription**](docs/ProductApi.md#retrieveproductsubscription) | **GET** /products/{productId}/subscriptions/{subscriptionId} | Retrieve a Product Subscription
*RESTHooksApi* | [**createAHookSubscription**](docs/RESTHooksApi.md#createahooksubscription) | **POST** /hooks | Create a Hook Subscription
*RESTHooksApi* | [**deleteAHookSubscription**](docs/RESTHooksApi.md#deleteahooksubscription) | **DELETE** /hooks/{key} | Delete a Hook Subscription
*RESTHooksApi* | [**listHookEventTypes**](docs/RESTHooksApi.md#listhookeventtypes) | **GET** /hooks/event_keys | List Hook Event Types
*RESTHooksApi* | [**listStoredHookSubscriptions**](docs/RESTHooksApi.md#liststoredhooksubscriptions) | **GET** /hooks | List Stored Hook Subscriptions
*RESTHooksApi* | [**retrieveAHookSubscription**](docs/RESTHooksApi.md#retrieveahooksubscription) | **GET** /hooks/{key} | Retrieve a Hook Subscription
*RESTHooksApi* | [**updateAHookSubscription**](docs/RESTHooksApi.md#updateahooksubscription) | **PUT** /hooks/{key} | Update a Hook Subscription
*RESTHooksApi* | [**verifyAHookSubscription**](docs/RESTHooksApi.md#verifyahooksubscription) | **POST** /hooks/{key}/verify | Verify a Hook Subscription
*RESTHooksApi* | [**verifyAHookSubscriptionDelayed**](docs/RESTHooksApi.md#verifyahooksubscriptiondelayed) | **POST** /hooks/{key}/delayedVerify | Verify a Hook Subscription, Delayed
*SettingApi* | [**getApplicationEnabled**](docs/SettingApi.md#getapplicationenabled) | **GET** /setting/application/enabled | Retrieve application status
*SettingApi* | [**getContactOptionTypes**](docs/SettingApi.md#getcontactoptiontypes) | **GET** /setting/contact/optionTypes | List Contact types
*TagsApi* | [**applyTagToContactIds**](docs/TagsApi.md#applytagtocontactids) | **POST** /tags/{tagId}/contacts | Apply Tag to Contacts
*TagsApi* | [**createTag**](docs/TagsApi.md#createtag) | **POST** /tags | Create Tag
*TagsApi* | [**createTagCategory**](docs/TagsApi.md#createtagcategory) | **POST** /tags/categories | Create Tag Category
*TagsApi* | [**getTag**](docs/TagsApi.md#gettag) | **GET** /tags/{id} | Retrieve a Tag
*TagsApi* | [**listCompaniesForTagId**](docs/TagsApi.md#listcompaniesfortagid) | **GET** /tags/{tagId}/companies | List Tagged Companies
*TagsApi* | [**listContactsForTagId**](docs/TagsApi.md#listcontactsfortagid) | **GET** /tags/{tagId}/contacts | List Tagged Contacts
*TagsApi* | [**listTags**](docs/TagsApi.md#listtags) | **GET** /tags | List Tags
*TagsApi* | [**removeTagFromContactId**](docs/TagsApi.md#removetagfromcontactid) | **DELETE** /tags/{tagId}/contacts/{contactId} | Remove Tag from Contact
*TagsApi* | [**removeTagFromContactIds**](docs/TagsApi.md#removetagfromcontactids) | **DELETE** /tags/{tagId}/contacts | Remove Tag from Contacts
*TaskApi* | [**createTask**](docs/TaskApi.md#createtask) | **POST** /tasks | Create a Task
*TaskApi* | [**deleteTask**](docs/TaskApi.md#deletetask) | **DELETE** /tasks/{taskId} | Delete a Task
*TaskApi* | [**getTask**](docs/TaskApi.md#gettask) | **GET** /tasks/{taskId} | Retrieve a Task
*TaskApi* | [**listTasks**](docs/TaskApi.md#listtasks) | **GET** /tasks | List Tasks
*TaskApi* | [**listTasksForCurrentUser**](docs/TaskApi.md#listtasksforcurrentuser) | **GET** /tasks/search | Search Tasks
*TaskApi* | [**retrieveTaskModel**](docs/TaskApi.md#retrievetaskmodel) | **GET** /tasks/model | Retrieve Task Model
*TaskApi* | [**updatePropertiesOnTask**](docs/TaskApi.md#updatepropertiesontask) | **PATCH** /tasks/{taskId} | Update a Task
*TaskApi* | [**updateTask**](docs/TaskApi.md#updatetask) | **PUT** /tasks/{taskId} | Replace a Task
*UserInfoApi* | [**getUserInfo**](docs/UserInfoApi.md#getuserinfo) | **GET** /oauth/connect/userinfo | Retrieve User Info
*UsersApi* | [**createUser**](docs/UsersApi.md#createuser) | **POST** /users | Create a User
*UsersApi* | [**listUsers**](docs/UsersApi.md#listusers) | **GET** /users | List Users


<a name="documentation-for-models"></a>
## Documentation for Models

 - [io.mverse.client.infusionsoft.models.AccountProfile](docs/AccountProfile.md)
 - [io.mverse.client.infusionsoft.models.AchieveApiGoalEvent](docs/AchieveApiGoalEvent.md)
 - [io.mverse.client.infusionsoft.models.Address](docs/Address.md)
 - [io.mverse.client.infusionsoft.models.AddressInformation](docs/AddressInformation.md)
 - [io.mverse.client.infusionsoft.models.AffiliateCommission](docs/AffiliateCommission.md)
 - [io.mverse.client.infusionsoft.models.AffiliateCommissionList](docs/AffiliateCommissionList.md)
 - [io.mverse.client.infusionsoft.models.Appointment](docs/Appointment.md)
 - [io.mverse.client.infusionsoft.models.AppointmentList](docs/AppointmentList.md)
 - [io.mverse.client.infusionsoft.models.BasicCompany](docs/BasicCompany.md)
 - [io.mverse.client.infusionsoft.models.BasicContact](docs/BasicContact.md)
 - [io.mverse.client.infusionsoft.models.Campaign](docs/Campaign.md)
 - [io.mverse.client.infusionsoft.models.CampaignLandingPageNodeDTO](docs/CampaignLandingPageNodeDTO.md)
 - [io.mverse.client.infusionsoft.models.CampaignList](docs/CampaignList.md)
 - [io.mverse.client.infusionsoft.models.CampaignNodeDTO](docs/CampaignNodeDTO.md)
 - [io.mverse.client.infusionsoft.models.CategoryReference](docs/CategoryReference.md)
 - [io.mverse.client.infusionsoft.models.CheckListItemDetails](docs/CheckListItemDetails.md)
 - [io.mverse.client.infusionsoft.models.Company](docs/Company.md)
 - [io.mverse.client.infusionsoft.models.CompanyAddress](docs/CompanyAddress.md)
 - [io.mverse.client.infusionsoft.models.CompanyFaxNumber](docs/CompanyFaxNumber.md)
 - [io.mverse.client.infusionsoft.models.CompanyList](docs/CompanyList.md)
 - [io.mverse.client.infusionsoft.models.CompanyPhoneNumber](docs/CompanyPhoneNumber.md)
 - [io.mverse.client.infusionsoft.models.CompanyReference](docs/CompanyReference.md)
 - [io.mverse.client.infusionsoft.models.ContactAddress](docs/ContactAddress.md)
 - [io.mverse.client.infusionsoft.models.ContactCreditCard](docs/ContactCreditCard.md)
 - [io.mverse.client.infusionsoft.models.ContactList](docs/ContactList.md)
 - [io.mverse.client.infusionsoft.models.ContactOrigin](docs/ContactOrigin.md)
 - [io.mverse.client.infusionsoft.models.ContactTag](docs/ContactTag.md)
 - [io.mverse.client.infusionsoft.models.ContactTagList](docs/ContactTagList.md)
 - [io.mverse.client.infusionsoft.models.CountriesByCode](docs/CountriesByCode.md)
 - [io.mverse.client.infusionsoft.models.CreateContactOrigin](docs/CreateContactOrigin.md)
 - [io.mverse.client.infusionsoft.models.CreateOrPatchCompany](docs/CreateOrPatchCompany.md)
 - [io.mverse.client.infusionsoft.models.CreateOrPatchContact](docs/CreateOrPatchContact.md)
 - [io.mverse.client.infusionsoft.models.CreateOrder](docs/CreateOrder.md)
 - [io.mverse.client.infusionsoft.models.CreateOrderItem](docs/CreateOrderItem.md)
 - [io.mverse.client.infusionsoft.models.CreatePayment](docs/CreatePayment.md)
 - [io.mverse.client.infusionsoft.models.CreateProduct](docs/CreateProduct.md)
 - [io.mverse.client.infusionsoft.models.CreateProductImage](docs/CreateProductImage.md)
 - [io.mverse.client.infusionsoft.models.CreateProductSubscription](docs/CreateProductSubscription.md)
 - [io.mverse.client.infusionsoft.models.CreateRestCustomField](docs/CreateRestCustomField.md)
 - [io.mverse.client.infusionsoft.models.CreateRestCustomFieldOption](docs/CreateRestCustomFieldOption.md)
 - [io.mverse.client.infusionsoft.models.CreateTag](docs/CreateTag.md)
 - [io.mverse.client.infusionsoft.models.CreateTagCategory](docs/CreateTagCategory.md)
 - [io.mverse.client.infusionsoft.models.CreateUser](docs/CreateUser.md)
 - [io.mverse.client.infusionsoft.models.CreditCard](docs/CreditCard.md)
 - [io.mverse.client.infusionsoft.models.CreditCardAdded](docs/CreditCardAdded.md)
 - [io.mverse.client.infusionsoft.models.CustomFieldMetaData](docs/CustomFieldMetaData.md)
 - [io.mverse.client.infusionsoft.models.CustomFieldOption](docs/CustomFieldOption.md)
 - [io.mverse.client.infusionsoft.models.CustomFieldValue](docs/CustomFieldValue.md)
 - [io.mverse.client.infusionsoft.models.EmailAddress](docs/EmailAddress.md)
 - [io.mverse.client.infusionsoft.models.EmailSendRequest](docs/EmailSendRequest.md)
 - [io.mverse.client.infusionsoft.models.EmailSendRequestAttachment](docs/EmailSendRequestAttachment.md)
 - [io.mverse.client.infusionsoft.models.EmailSentCreate](docs/EmailSentCreate.md)
 - [io.mverse.client.infusionsoft.models.EmailSentCreateError](docs/EmailSentCreateError.md)
 - [io.mverse.client.infusionsoft.models.EmailSentCreateList](docs/EmailSentCreateList.md)
 - [io.mverse.client.infusionsoft.models.EmailSentQueryResult](docs/EmailSentQueryResult.md)
 - [io.mverse.client.infusionsoft.models.EmailSentQueryResultList](docs/EmailSentQueryResultList.md)
 - [io.mverse.client.infusionsoft.models.EmailSentQueryResultWithContent](docs/EmailSentQueryResultWithContent.md)
 - [io.mverse.client.infusionsoft.models.EntryLongCommastring_](docs/EntryLongCommastring_.md)
 - [io.mverse.client.infusionsoft.models.Error](docs/Error.md)
 - [io.mverse.client.infusionsoft.models.FaxNumber](docs/FaxNumber.md)
 - [io.mverse.client.infusionsoft.models.FileDescriptor](docs/FileDescriptor.md)
 - [io.mverse.client.infusionsoft.models.FileInformation](docs/FileInformation.md)
 - [io.mverse.client.infusionsoft.models.FileList](docs/FileList.md)
 - [io.mverse.client.infusionsoft.models.FileUpload](docs/FileUpload.md)
 - [io.mverse.client.infusionsoft.models.FullContact](docs/FullContact.md)
 - [io.mverse.client.infusionsoft.models.Goal](docs/Goal.md)
 - [io.mverse.client.infusionsoft.models.GoalEventResultDTO](docs/GoalEventResultDTO.md)
 - [io.mverse.client.infusionsoft.models.HistoricalCounts](docs/HistoricalCounts.md)
 - [io.mverse.client.infusionsoft.models.Item](docs/Item.md)
 - [io.mverse.client.infusionsoft.models.Merchant](docs/Merchant.md)
 - [io.mverse.client.infusionsoft.models.Note](docs/Note.md)
 - [io.mverse.client.infusionsoft.models.NoteList](docs/NoteList.md)
 - [io.mverse.client.infusionsoft.models.NoteUser](docs/NoteUser.md)
 - [io.mverse.client.infusionsoft.models.ObjectModel](docs/ObjectModel.md)
 - [io.mverse.client.infusionsoft.models.Opportunity](docs/Opportunity.md)
 - [io.mverse.client.infusionsoft.models.OpportunityContact](docs/OpportunityContact.md)
 - [io.mverse.client.infusionsoft.models.OpportunityList](docs/OpportunityList.md)
 - [io.mverse.client.infusionsoft.models.Order](docs/Order.md)
 - [io.mverse.client.infusionsoft.models.OrderContactDetails](docs/OrderContactDetails.md)
 - [io.mverse.client.infusionsoft.models.OrderItem](docs/OrderItem.md)
 - [io.mverse.client.infusionsoft.models.OrderList](docs/OrderList.md)
 - [io.mverse.client.infusionsoft.models.PaymentGateway](docs/PaymentGateway.md)
 - [io.mverse.client.infusionsoft.models.PaymentPlan](docs/PaymentPlan.md)
 - [io.mverse.client.infusionsoft.models.PaymentResult](docs/PaymentResult.md)
 - [io.mverse.client.infusionsoft.models.PhoneNumber](docs/PhoneNumber.md)
 - [io.mverse.client.infusionsoft.models.Product](docs/Product.md)
 - [io.mverse.client.infusionsoft.models.ProductList](docs/ProductList.md)
 - [io.mverse.client.infusionsoft.models.ProductOption](docs/ProductOption.md)
 - [io.mverse.client.infusionsoft.models.ProductOptionValue](docs/ProductOptionValue.md)
 - [io.mverse.client.infusionsoft.models.ProductStatus](docs/ProductStatus.md)
 - [io.mverse.client.infusionsoft.models.ProductStatusList](docs/ProductStatusList.md)
 - [io.mverse.client.infusionsoft.models.ProductSubscription](docs/ProductSubscription.md)
 - [io.mverse.client.infusionsoft.models.Product_](docs/Product_.md)
 - [io.mverse.client.infusionsoft.models.ProvincesByCode](docs/ProvincesByCode.md)
 - [io.mverse.client.infusionsoft.models.Relationship](docs/Relationship.md)
 - [io.mverse.client.infusionsoft.models.RequestCompanyReference](docs/RequestCompanyReference.md)
 - [io.mverse.client.infusionsoft.models.RequestNote](docs/RequestNote.md)
 - [io.mverse.client.infusionsoft.models.RestEmailAddress](docs/RestEmailAddress.md)
 - [io.mverse.client.infusionsoft.models.RestHook](docs/RestHook.md)
 - [io.mverse.client.infusionsoft.models.RestHookRequest](docs/RestHookRequest.md)
 - [io.mverse.client.infusionsoft.models.RestMerchantAccountResponse](docs/RestMerchantAccountResponse.md)
 - [io.mverse.client.infusionsoft.models.RestPartialContact](docs/RestPartialContact.md)
 - [io.mverse.client.infusionsoft.models.RestUser](docs/RestUser.md)
 - [io.mverse.client.infusionsoft.models.SalesPipeline](docs/SalesPipeline.md)
 - [io.mverse.client.infusionsoft.models.Sequence](docs/Sequence.md)
 - [io.mverse.client.infusionsoft.models.SequencePath](docs/SequencePath.md)
 - [io.mverse.client.infusionsoft.models.SetOfIds](docs/SetOfIds.md)
 - [io.mverse.client.infusionsoft.models.Setting](docs/Setting.md)
 - [io.mverse.client.infusionsoft.models.ShippingInformation](docs/ShippingInformation.md)
 - [io.mverse.client.infusionsoft.models.SimpleOpportunityStage](docs/SimpleOpportunityStage.md)
 - [io.mverse.client.infusionsoft.models.SimpleProduct](docs/SimpleProduct.md)
 - [io.mverse.client.infusionsoft.models.SimpleTag](docs/SimpleTag.md)
 - [io.mverse.client.infusionsoft.models.SimpleUser](docs/SimpleUser.md)
 - [io.mverse.client.infusionsoft.models.SocialAccount](docs/SocialAccount.md)
 - [io.mverse.client.infusionsoft.models.StackTraceElement](docs/StackTraceElement.md)
 - [io.mverse.client.infusionsoft.models.StageDetails](docs/StageDetails.md)
 - [io.mverse.client.infusionsoft.models.Subscription](docs/Subscription.md)
 - [io.mverse.client.infusionsoft.models.SubscriptionList](docs/SubscriptionList.md)
 - [io.mverse.client.infusionsoft.models.SubscriptionPlan_](docs/SubscriptionPlan_.md)
 - [io.mverse.client.infusionsoft.models.Tag](docs/Tag.md)
 - [io.mverse.client.infusionsoft.models.TagCategory](docs/TagCategory.md)
 - [io.mverse.client.infusionsoft.models.TagId](docs/TagId.md)
 - [io.mverse.client.infusionsoft.models.TaggedCompany](docs/TaggedCompany.md)
 - [io.mverse.client.infusionsoft.models.TaggedCompanyList](docs/TaggedCompanyList.md)
 - [io.mverse.client.infusionsoft.models.TaggedContact](docs/TaggedContact.md)
 - [io.mverse.client.infusionsoft.models.TaggedContactList](docs/TaggedContactList.md)
 - [io.mverse.client.infusionsoft.models.Tags](docs/Tags.md)
 - [io.mverse.client.infusionsoft.models.Task](docs/Task.md)
 - [io.mverse.client.infusionsoft.models.TaskList](docs/TaskList.md)
 - [io.mverse.client.infusionsoft.models.Throwable](docs/Throwable.md)
 - [io.mverse.client.infusionsoft.models.Transaction](docs/Transaction.md)
 - [io.mverse.client.infusionsoft.models.TransactionList](docs/TransactionList.md)
 - [io.mverse.client.infusionsoft.models.UpdateEmailAddress](docs/UpdateEmailAddress.md)
 - [io.mverse.client.infusionsoft.models.UpdateNote](docs/UpdateNote.md)
 - [io.mverse.client.infusionsoft.models.UpsertContact](docs/UpsertContact.md)
 - [io.mverse.client.infusionsoft.models.UserInfoDTO](docs/UserInfoDTO.md)
 - [io.mverse.client.infusionsoft.models.Users](docs/Users.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="oauth2"></a>
### oauth2

- **Type**: OAuth
- **Flow**: accessCode
- **Authorization URL**: https://accounts.infusionsoft.com/app/oauth/authorize
- **Scopes**: N/A


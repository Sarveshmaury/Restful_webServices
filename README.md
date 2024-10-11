# Restful_webServices
Crud with ArrayList | CustomizedResponseEntityExceptionHandler | pathVariable | requestBody | versioning | Validation


Versioning in Spring Boot, particularly for RESTful APIs, is a way to manage changes and updates to your API without disrupting existing clients. Here are some common methods to implement versioning in Spring Boot:

URI Versioning: This involves including the version number in the URL path. For example, /api/v1/resource and /api/v2/resource. This method is straightforward and makes it clear which version of the API is being used1.
Request Parameter Versioning: You can specify the version as a request parameter, such as /api/resource?version=1. This keeps the URL clean but requires clients to include the version parameter in their requests2.
Header Versioning: This method uses custom headers to specify the version. For example, clients can send a header like Accept: application/vnd.company.app-v1+json. This approach keeps the URL clean and leverages HTTP headers for versioning3.
Media Type Versioning: Similar to header versioning, this method uses the Accept header but specifies the version within the media type. For example, Accept: application/vnd.company.app-v1+json4.

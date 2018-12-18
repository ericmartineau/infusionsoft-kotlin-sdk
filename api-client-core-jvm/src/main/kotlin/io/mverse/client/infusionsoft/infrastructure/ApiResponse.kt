package io.mverse.client.infusionsoft.infrastructure

enum class ResponseType {
    Success, Informational, Redirection, ClientError, ServerError
}

sealed class ApiResponse(val responseType: ResponseType) {
    abstract val statusCode: Int
    abstract val headers: Map<String, List<String>>
}

class Success(
        val data: String?,
        override val statusCode: Int = -1,
        override val headers: Map<String, List<String>> = mapOf()
): ApiResponse(ResponseType.Success)

class Informational(
        val statusText: String,
        override val statusCode: Int = -1,
        override val headers: Map<String, List<String>> = mapOf()
) : ApiResponse(ResponseType.Informational)

class Redirection(
        override val statusCode: Int = -1,
        override val headers: Map<String, List<String>> = mapOf()
) : ApiResponse(ResponseType.Redirection)

class ClientError(
        val body: Any? = null,
        override val statusCode: Int = -1,
        override val headers: Map<String, List<String>> = mapOf()
) : ApiResponse(ResponseType.ClientError)

class ServerError(
        val message: String? = null,
        val body: Any? = null,
        override val statusCode: Int = -1,
        override val headers: Map<String, List<String>>
): ApiResponse(ResponseType.ServerError)
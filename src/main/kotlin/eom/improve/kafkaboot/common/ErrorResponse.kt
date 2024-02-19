package eom.improve.kafkaboot.common

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

data class ErrorResponse(
    @get:JsonProperty("path") val path: String,
    @get:JsonProperty("status") val status: HttpStatus,
    @get:JsonProperty("message") val message: String,
    @get:JsonProperty("error") val error: String = status.reasonPhrase,
    @get:JsonProperty("request_id") val requestId: String = path.substringAfterLast("/"),
    @get:JsonProperty("timestamp") val timestamp: ZonedDateTime= ZonedDateTime.now()
) {
    constructor() : this(
        path = "",
        status = HttpStatus.INTERNAL_SERVER_ERROR,
        message = HttpStatus.INTERNAL_SERVER_ERROR.name,
        timestamp = ZonedDateTime.now()
    )
}

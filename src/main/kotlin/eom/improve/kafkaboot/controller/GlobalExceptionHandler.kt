package eom.improve.kafkaboot.controller

import eom.improve.kafkaboot.common.ErrorResponse
import eom.improve.kafkaboot.exception.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.util.stream.Collectors

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException::class)
    @ResponseBody
    fun handleBadRequestException(exchange: ServerWebExchange, ex: WebExchangeBindException): Mono<ErrorResponse> {
        var defaultMsg: String = ex.bindingResult.fieldErrors.stream()
            .map { fieldError -> fieldError.defaultMessage }
            .collect(Collectors.joining(", "))

        return ErrorResponse(
            path = exchange.request.path.toString(),
            status = HttpStatus.BAD_REQUEST,
            message = defaultMsg,
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            requestId = exchange.request.id
        ).toMono()
    }
    // need to implement error logging publish to kafka
}

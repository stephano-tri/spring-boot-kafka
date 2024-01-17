package eom.improve.kafkaboot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
class MainController {

    @GetMapping("/hello")
    fun hello(): Mono<String> {
        return "Hello, Inspien!".toMono()
    }
}
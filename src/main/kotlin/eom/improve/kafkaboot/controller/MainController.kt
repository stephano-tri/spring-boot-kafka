package eom.improve.kafkaboot.controller

import eom.improve.kafkaboot.model.FilmEntity
import eom.improve.kafkaboot.service.FilmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
class MainController(
    private val filmService: FilmService
) {

    @GetMapping("/hello")
    fun hello(): Mono<String> {
        return "Hello, Inspien!".toMono()
    }

    @GetMapping("/get/film/list")
    fun getFilmList(): Mono<List<FilmEntity>> {
        return filmService.findAll().collectList();
    }
}

package eom.improve.kafkaboot.controller

import eom.improve.kafkaboot.dto.Film
import eom.improve.kafkaboot.model.FilmEntity
import eom.improve.kafkaboot.service.FilmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/film")
@RestController
class FilmController (
    private val filmService: FilmService
){
    @GetMapping("/list")
    fun getFilmList(): Mono<List<Film>> {
        return filmService.findAll().map { it.convert2Pojo() }.collectList()
    }
}

package eom.improve.kafkaboot.controller

import eom.improve.kafkaboot.dto.Film
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/film")
interface FilmController {

    @GetMapping("/list/all")
    fun getAllFilms() : Mono<List<Film>>

    @PutMapping("/modify")
    fun modifyFilm(@RequestBody updatedFilm : Film) : Mono<Film>
}
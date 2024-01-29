package eom.improve.kafkaboot.service

import eom.improve.kafkaboot.controller.FilmController
import eom.improve.kafkaboot.dto.Film
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class FilmControllerImpl(
    private val filmService: FilmService
) : FilmController{

    override fun getAllFilms(): Mono<List<Film>> {
        return filmService.findAll().map { it.convert2Pojo() }
            .collectSortedList((Comparator<Film> { o1, o2 -> o1.filmId.compareTo(o2.filmId) }))
    }

    override fun modifyFilm(updatedFilm : Film) : Mono<Film> {
        return filmService.updateFilm(updatedFilm.convert2Entity())
            .flatMap { it.convert2Pojo().toMono() }
    }

    override fun saveFilm(toBeSavedFilm: Film): Mono<Film> {
        return filmService.saveFilm(toBeSavedFilm.convert2Entity())
            .flatMap { toBeSavedFilm.toMono() }
    }

}

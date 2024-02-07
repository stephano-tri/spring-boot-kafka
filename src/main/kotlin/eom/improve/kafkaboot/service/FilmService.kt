package eom.improve.kafkaboot.service

import eom.improve.kafkaboot.model.FilmEntity
import eom.improve.kafkaboot.repository.FilmRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class FilmService(
    private val filmRepository : FilmRepository
) {
    fun findAll() : Flux<FilmEntity> = filmRepository.findAllBy()

    fun updateFilm(updatedFilm : FilmEntity) : Mono<FilmEntity> {
        return filmRepository.findById(updatedFilm.filmId)
            .switchIfEmpty(Mono.error(RuntimeException("Not registered film")))
            .flatMap { filmRepository.save(updatedFilm) }
    }

    fun saveFilm(toBeSavedFilm : FilmEntity) : Mono<FilmEntity> {
        return filmRepository.save(toBeSavedFilm);
    }

    fun deleteFilm(filmId : Int) : Mono<Void> {
        // need to implement cascade delete for table data that set foreign key

        // payment -> rental -> inventory
        // film_actor
        // film_category



        return filmRepository.findById(filmId)
            .switchIfEmpty(Mono.error(RuntimeException("Not registered film")))
            .flatMap { filmRepository.deleteById(filmId) }
            .then()
    }
}

package eom.improve.kafkaboot.repository

import eom.improve.kafkaboot.model.FilmActor
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FilmActorRepository : R2dbcRepository<FilmActor, Int> {
    fun findAllByFilmId(filmId: Int) : Flux<FilmActor>
    fun deleteByFilmId(filmId: Int) : Mono<Void>
}

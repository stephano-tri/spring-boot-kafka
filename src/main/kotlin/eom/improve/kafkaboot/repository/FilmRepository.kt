package eom.improve.kafkaboot.repository

import eom.improve.kafkaboot.model.FilmEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface FilmRepository : R2dbcRepository<FilmEntity, Int> {
    fun findAllBy() : Flux<FilmEntity>
    fun deleteByFilmId(filmId: Int) : Mono<Void>
}

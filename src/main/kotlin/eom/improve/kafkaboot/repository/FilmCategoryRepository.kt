package eom.improve.kafkaboot.repository

import eom.improve.kafkaboot.model.FilmCategory
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FilmCategoryRepository : R2dbcRepository<FilmCategory, Int> {
    fun findAllByFilmId(filmId: Int) : Flux<FilmCategory>
    fun deleteByFilmId(filmId: Int) : Mono<Void>
}

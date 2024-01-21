package eom.improve.kafkaboot.service

import eom.improve.kafkaboot.model.FilmEntity
import eom.improve.kafkaboot.repository.FilmRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
class FilmService(
    private val filmRepository : FilmRepository
) {
    fun findAll() : Flux<FilmEntity> = filmRepository.findAllBy()
}

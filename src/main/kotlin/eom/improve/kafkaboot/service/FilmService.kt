package eom.improve.kafkaboot.service

import eom.improve.kafkaboot.model.FilmEntity
import eom.improve.kafkaboot.repository.FilmRepository
import eom.improve.kafkaboot.repository.InventoryRepository
import eom.improve.kafkaboot.repository.PaymentRepository
import eom.improve.kafkaboot.repository.RentalRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@Service
class FilmService(
    private val filmRepository : FilmRepository,
    private val paymentRepository : PaymentRepository,
    private val inventoryRepository : InventoryRepository,
    private val rentalRepository : RentalRepository
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

    @Transactional
    fun deleteFilm(filmId : Int) : Mono<Void> {
        // need to implement cascade delete(maybe soft) for table data that set foreign key
        return filmRepository.findById(filmId)
            .switchIfEmpty(Mono.error(RuntimeException("Not registered film")))
            .flatMap { filmEn ->
                inventoryRepository.findAllByFilmId(filmId)
                    .switchIfEmpty { filmRepository.delete(filmEn).then() }
                    .flatMap { inventoryEn ->
                        rentalRepository.findAllByInventoryId(inventoryEn.inventoryId)
                            .flatMap { rentalEn ->
                                paymentRepository.findAllByRentalId(rentalEn.rentalId)
                                    .flatMap { paymentRepository.delete(it) }
                                    .then(rentalEn.toMono())
                            }
                            .flatMap {
                                rentalRepository.delete(it)
                                    .then(inventoryEn.toMono())
                            }
                    }
                    .flatMap {
                        inventoryRepository.delete(it)
                            .then(filmEn.toMono())
                    }
                    .flatMap { filmRepository.delete(it).then() }
                    .then()
            }
    }
}

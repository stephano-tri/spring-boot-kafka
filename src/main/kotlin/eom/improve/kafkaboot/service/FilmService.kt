package eom.improve.kafkaboot.service

import eom.improve.kafkaboot.model.FilmEntity
import eom.improve.kafkaboot.repository.*
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@Service
class FilmService(
    private val filmRepository : FilmRepository,
    private val paymentRepository : PaymentRepository,
    private val inventoryRepository : InventoryRepository,
    private val rentalRepository : RentalRepository,
    private val filmActorRepository: FilmActorRepository,
    private val filmCategoryRepository: FilmCategoryRepository
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
        // need to implement cascade delete(maybe soft) for table data that set foreign key
        return filmRepository.findById(filmId)
            .switchIfEmpty(RuntimeException("Not registered film").toMono())
            .flatMap { filmEn ->
                 inventoryRepository.findAllByFilmId(filmEn.filmId)
                     .flatMap { inventoryEn ->
                         rentalRepository.findAllByInventoryId(inventoryEn.inventoryId)
                             .flatMap { rentalEn ->
                                 paymentRepository.findAllByRentalId(rentalEn.rentalId)
                                     .flatMap { paymentEn ->
                                            paymentRepository.deleteByPaymentId(paymentEn.paymentId)
                                     }
                                     .then(rentalEn.toMono())
                             }
                             .flatMap { rentalEn ->
                                rentalRepository.deleteByRentalId(rentalEn.rentalId)
                             }.then(inventoryEn.toMono())
                     }
                     .flatMap { inventoryEn ->
                         inventoryRepository.deleteByInventoryId(inventoryEn.inventoryId)
                     }
                     .then(filmEn.toMono())
            }
            .flatMap { filmEn ->
                Mono.zip(
                    filmActorRepository.findAllByFilmId(filmEn.filmId)
                        .flatMap { filmActorRepository.deleteByFilmId(it.filmId) }
                        .then()
                        ,
                    filmCategoryRepository.findAllByFilmId(filmEn.filmId)
                        .flatMap { filmCategoryRepository.deleteByFilmId(it.filmId) }
                        .then()
                )
                    .then(filmEn.toMono())
            }
            .flatMap {
                filmRepository.deleteByFilmId(it.filmId)
            }
    }
}

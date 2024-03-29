package eom.improve.kafkaboot.repository

import eom.improve.kafkaboot.model.RentalEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface RentalRepository : R2dbcRepository<RentalEntity, Int> {
    fun findAllByInventoryId(inventoryId: Int) : Flux<RentalEntity>
    fun deleteByRentalId(rentalId: Int) : Mono<Void>
}

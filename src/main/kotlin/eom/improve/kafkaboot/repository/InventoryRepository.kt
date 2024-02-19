package eom.improve.kafkaboot.repository

import eom.improve.kafkaboot.model.InventoryEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface InventoryRepository : R2dbcRepository<InventoryEntity, Int> {
    fun findAllByFilmId(filmId: Int) : Flux<InventoryEntity>
    fun deleteByInventoryId(inventoryId: Int) : Mono<Void>
}

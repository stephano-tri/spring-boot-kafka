package eom.improve.kafkaboot.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("inventory")
data class InventoryEntity(
    @Id
    val inventoryId: Int,
    val filmId: Int,
    val storeId: Int,
    val lastUpdate: LocalDateTime
)

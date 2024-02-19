package eom.improve.kafkaboot.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("rental")
data class RentalEntity(
    @Id
    val rentalId: Int,
    val rentalDate: LocalDateTime,
    val inventoryId: Int,
    val customerId: Int,
    val returnDate: LocalDateTime? = null,
    val staffId: Int? = null,
    val lastUpdate: LocalDateTime? = null
)

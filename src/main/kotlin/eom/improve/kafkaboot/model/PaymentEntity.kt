package eom.improve.kafkaboot.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("payment")
data class PaymentEntity(
    @Id
    val paymentId: Int,
    val customerId: String,
    val staffId: Int,
    val rentalId: Int,
    val amount: BigDecimal,
    val paymentDate: LocalDateTime
)

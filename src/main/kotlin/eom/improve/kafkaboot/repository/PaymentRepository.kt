package eom.improve.kafkaboot.repository

import eom.improve.kafkaboot.model.PaymentEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface PaymentRepository : R2dbcRepository<PaymentEntity, Int> {
    fun findAllByRentalId(rentalId: Int) : Flux<PaymentEntity>
    fun deleteByPaymentId(paymentId: Int) : Mono<Void>
}

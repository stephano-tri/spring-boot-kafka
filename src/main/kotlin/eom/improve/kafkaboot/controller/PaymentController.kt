package eom.improve.kafkaboot.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment")
interface PaymentController {

    @DeleteMapping("/delete/{paymentId}")
    fun deletePayment()
}
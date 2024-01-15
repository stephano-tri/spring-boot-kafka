package eom.improve.kafkaboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaBootApplication

fun main(args : Array<String>) {
    runApplication<KafkaBootApplication>(*args)
}

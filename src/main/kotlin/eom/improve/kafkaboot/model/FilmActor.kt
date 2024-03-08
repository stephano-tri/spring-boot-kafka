package eom.improve.kafkaboot.model

import java.io.Serializable
import java.time.LocalDateTime

data class FilmActor(
    val actorId: Int,
    val filmId: Int,
    val lastUpdate: LocalDateTime
) : Serializable
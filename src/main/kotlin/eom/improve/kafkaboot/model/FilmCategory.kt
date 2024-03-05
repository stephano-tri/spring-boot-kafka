package eom.improve.kafkaboot.model

import java.io.Serializable
import java.time.LocalDateTime

data class FilmCategory(
    val filmId: Int,
    val categoryId: Int,
    val lastUpdate: LocalDateTime
) : Serializable
package eom.improve.kafkaboot.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("film")
data class FilmEntity(
    @Id
    val filmId: Int,
    val title: String,
    val description: String,
    val releaseYear: String,
    val languageId: Int,
    val rentalDuration: Int,
    val rentalRate: BigDecimal,
    val length: Int,
    val replacementCost : Int,
    val rating : String,
    val lastUpdate: LocalDateTime,
    val specialFeatures: MutableList<String>,
)

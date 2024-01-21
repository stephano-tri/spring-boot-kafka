package eom.improve.kafkaboot.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 * make a dto for FilmEntity
 */
data class Film (
    val title: String,
    val description: String,
    @field:JsonProperty("release_year") val releaseYear: String,
    @field:JsonProperty("language_id") val languageId: Int,
    val rentalDuration: Int,
    val rentalRate: BigDecimal,
    val length: Int,
    val replacementCost : Int,
    val rating : String,
    val lastUpdate: LocalDateTime,
    val specialFeatures: MutableList<String>,
)

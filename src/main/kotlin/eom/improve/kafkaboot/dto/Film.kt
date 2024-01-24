package eom.improve.kafkaboot.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import eom.improve.kafkaboot.enum.MpaaRating
import eom.improve.kafkaboot.model.FilmEntity
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 * make a dto for FilmEntity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Film (
    @field:JsonProperty("film_id") val filmId: Int,
    val title: String,
    val description: String,
    @field:JsonProperty("release_year") val releaseYear: Int,
    @field:JsonProperty("language_id") val languageId: Int,
    @field:JsonProperty("rental_duration")val rentalDuration: Int,
    @field:JsonProperty("rental_date") val rentalRate: BigDecimal,
    val length: Int,
    @field:JsonProperty("replacement_cost") val replacementCost : Int,
//    val rating : MpaaRating,
    @field:JsonProperty("last_update") val lastUpdate: LocalDateTime,
    @field:JsonProperty("special_features") val specialFeatures: MutableList<String>,
) {
    fun convert2Entity() : FilmEntity {
        return FilmEntity(
            filmId = this.filmId,
            title = this.title,
            description = this.description,
            releaseYear = this.releaseYear,
            languageId = this.languageId,
            rentalDuration = this.rentalDuration,
            rentalRate = this.rentalRate,
            length = this.length,
            replacementCost = this.replacementCost,
//            rating = this.rating,
            lastUpdate = this.lastUpdate,
            specialFeatures = this.specialFeatures
        )
    }
}

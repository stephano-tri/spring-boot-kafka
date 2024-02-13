package eom.improve.kafkaboot.model

import eom.improve.kafkaboot.dto.Film
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
    val releaseYear: Int,
    val languageId: Int,
    val rentalDuration: Int,
    val rentalRate: BigDecimal,
    val length: Int,
    val replacementCost : Int,
//    val rating : MpaaRating,
    val lastUpdate: LocalDateTime,
    val specialFeatures: MutableList<String>,
) {
    fun convert2Pojo() : Film {
        return Film(
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

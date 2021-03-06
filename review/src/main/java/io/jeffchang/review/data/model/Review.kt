package io.jeffchang.review.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Review(
	@Json(name="date_updated")
	val dateUpdated: String? = null,

	@Json(name="display_title")
	val displayTitle: String? = null,

	val link: Link,

	@Json(name="publication_date")
	val publicationDate: String,

	@Json(name="summary_short")
	val summaryShort: String? = null,

	@Json(name="critics_pick")
	val criticsPick: Int? = null,

	@Json(name="byline")
	val byline: String? = null,

	@Json(name="headline")
	val headline: String,

	val multimedia: Multimedia,

	@Json(name="mpaa_rating")
	val mpaaRating: String,

	@Json(name="opening_date")
	val openingDate: String? = null
)
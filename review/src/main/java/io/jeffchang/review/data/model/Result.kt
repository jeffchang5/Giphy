package io.jeffchang.review.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
		@Json(name="copyright")
	val copyright: String,
		@Json(name="has_more")
	val hasMore: Boolean,
		@Json(name="results")
	val reviews: List<Review>,
		@Json(name="num_results")
	val numResults: Int,
		@Json(name="status")
	val status: String
)
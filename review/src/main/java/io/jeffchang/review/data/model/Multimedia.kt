package io.jeffchang.review.data.model

import com.squareup.moshi.Json

data class Multimedia(

	@Json(name="src")
	val src: String,

	@Json(name="width")
	val width: Int,

	@Json(name="type")
	val type: String,

	@Json(name="height")
	val height: Int
)
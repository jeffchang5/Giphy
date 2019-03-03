package io.jeffchang.review.data.model

import com.squareup.moshi.Json

data class Multimedia(

	@Json(name="src")
	val src: String? = null,

	@Json(name="width")
	val width: Int? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="height")
	val height: Int? = null
)
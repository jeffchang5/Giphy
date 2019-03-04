package io.jeffchang.review.data.model

import com.squareup.moshi.Json

data class Link(

	@Json(name="suggested_link_text")
	val suggestedLinkText: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="url")
	val url: String
)
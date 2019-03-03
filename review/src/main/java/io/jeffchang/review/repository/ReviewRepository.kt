package io.jeffchang.review.repository

import io.jeffchang.review.data.service.ReviewService
import javax.inject.Inject

class ReviewRepository @Inject constructor(
        private val reviewService: ReviewService
) {

    fun getReviews() = reviewService.getReviews()

}
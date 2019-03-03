package io.jeffchang.review.interactor

import io.jeffchang.review.repository.ReviewRepository
import javax.inject.Inject

class ReviewInteractor @Inject constructor(
        private val reviewRepository: ReviewRepository) {

    fun getReviews() = reviewRepository.getReviews()
            .map { it.reviews }
}
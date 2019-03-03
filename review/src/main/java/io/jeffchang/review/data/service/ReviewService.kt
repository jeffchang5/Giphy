package io.jeffchang.review.data.service

import io.jeffchang.review.data.model.Result
import io.reactivex.Single
import retrofit2.http.GET

interface ReviewService {

    @GET("/svc/movies/v2/reviews/dvd-picks.json?order=by-date&api-key=KoRB4K5LRHygfjCL2AH6iQ7NeUqDAGAB&offset=0")
    fun getReviews(): Single<Result>
}
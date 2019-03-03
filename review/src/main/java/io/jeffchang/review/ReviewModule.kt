package io.jeffchang.review

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.jeffchang.base.common.di.ViewModelKey
import io.jeffchang.review.data.service.ReviewService
import io.jeffchang.review.viewmodel.ReviewViewModel
import retrofit2.Retrofit

@Suppress("unused")
@Module
abstract class ReviewModule {

    @ContributesAndroidInjector
    abstract fun contributeReviewFragment(): ReviewFragment

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun provideReviewService(retrofit: Retrofit) =
                retrofit.create(ReviewService::class.java)

    }

    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel::class)
    abstract fun bindReviewViewModel(reviewViewModel: ReviewViewModel): ViewModel

}
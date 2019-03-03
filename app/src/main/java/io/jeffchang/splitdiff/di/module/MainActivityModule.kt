package io.jeffchang.splitdiff.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.jeffchang.review.ReviewModule
import io.jeffchang.splitdiff.MainActivity

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [
        ReviewModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity

}
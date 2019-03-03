package io.jeffchang.splitdiff.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.jeffchang.base.common.kt.ViewModelFactory

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
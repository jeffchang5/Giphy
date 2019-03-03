package io.jeffchang.review.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.jeffchang.base.data.model.TextData
import io.jeffchang.challenge.R
import io.jeffchang.review.data.model.Review
import io.jeffchang.review.interactor.ReviewInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class ReviewViewModel @Inject constructor(
        private val reviewInteractor: ReviewInteractor): ViewModel() {

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    private val _textDataLiveData = MutableLiveData<TextData?>()

    val textDataLiveData: LiveData<TextData?> get() = _textDataLiveData

    private val _reviewLiveData = MutableLiveData<List<Review>>()

    val reviewLiveData: LiveData<List<Review>> get() = _reviewLiveData

    fun getReviews() {
        _textDataLiveData.value = TextData(R.string.loading)
        reviewInteractor.getReviews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("There are %s reviews.", it.size)
                    if (it.isEmpty()) {
                        _textDataLiveData.value = TextData(R.string.reviews_empty)
                    } else {
                        _textDataLiveData.value = null
                        _reviewLiveData.value = it
                    }
                }, { throwable ->
                    Timber.e(throwable)
                    (throwable as? HttpException)?.let {
                    }
                    _textDataLiveData.value = TextData(R.string.network_error)
                })
                .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
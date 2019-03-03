package io.jeffchang.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import io.jeffchang.base.common.LineItemDecoration
import io.jeffchang.challenge.R
import io.jeffchang.review.adapter.ReviewRecyclerViewAdapter
import io.jeffchang.review.viewmodel.ReviewViewModel
import kotlinx.android.synthetic.main.fragment_review.*
import javax.inject.Inject

class ReviewFragment: DaggerFragment() {

    @Inject
    lateinit var reviewViewModel: ReviewViewModel

    private val reviewRecyclerViewAdapter by lazy {
        ReviewRecyclerViewAdapter()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_review, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
        initRecyclerView()

        reviewViewModel.getReviews()
    }

    private fun initRecyclerView() {
        fragment_pull_request_recyclerview.layoutManager = LinearLayoutManager(context)
        fragment_pull_request_recyclerview.addItemDecoration(LineItemDecoration(context))
        fragment_pull_request_recyclerview.adapter = reviewRecyclerViewAdapter
    }

    private fun subscribeUi() {
        reviewViewModel.textDataLiveData.observe(this, Observer {
            fragment_pull_request_loading_view.textData = it
        })
        reviewViewModel.reviewLiveData.observe(this, Observer {
            reviewRecyclerViewAdapter.submitList(it)
        })
    }
}
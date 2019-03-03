package io.jeffchang.review.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.jeffchang.challenge.R
import io.jeffchang.review.data.model.Review
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.review_item.view.*

class ReviewRecyclerViewAdapter : ListAdapter<
        Review,
        ReviewRecyclerViewAdapter.ReviewViewHolder>(ReviewCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.review_item,
                        parent,
                        false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val pullRequest = getItem(position)
        holder.bind(pullRequest)
    }

    inner class ReviewViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View? get() = itemView

        fun bind(review: Review) {
            itemView.review_item_title_text_view.text = review.displayTitle
            itemView.review_item_date_text_view.text = review.dateUpdated

        }
    }

    internal class ReviewCallback : DiffUtil.ItemCallback<Review>() {

        override fun areItemsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem

        override fun areContentsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem
    }
}
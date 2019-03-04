package io.jeffchang.review.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.jeffchang.challenge.R
import io.jeffchang.review.data.model.Review
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.review_item.view.*

class ReviewRecyclerViewAdapter(
        private val onReviewClickedListener: ((url: String) -> Unit)
) : ListAdapter<
        Review,
        ReviewRecyclerViewAdapter.ReviewViewHolder>(ReviewCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.review_item,
                        parent,
                        false)

        val reviewViewHolder = ReviewViewHolder(view)
        reviewViewHolder.itemView.setOnClickListener {
            val url = getItem(reviewViewHolder.adapterPosition).link.url
            onReviewClickedListener.invoke(url)
        }
        return reviewViewHolder
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val pullRequest = getItem(position)
        holder.bind(pullRequest)
    }

    inner class ReviewViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View? get() = itemView

        fun bind(review: Review) {


            itemView.apply {
                Picasso
                        .get()
                        .load(review.multimedia.src)
                        .into(review_item_profile_image_view)
                review_item_movie_title_textview.text = review.displayTitle
                review_item_byline_textview.text = review.byline
                review_item_mpaa_textview.text = review.mpaaRating
                review_item_headline_textview.text = review.headline
                review_item_date_textview.text = review.publicationDate
                review_item_desc_textview.text = review.summaryShort
            }

        }
    }

    internal class ReviewCallback : DiffUtil.ItemCallback<Review>() {

        override fun areItemsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem

        override fun areContentsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem
    }

    interface OnReviewClickedListener {

        fun onReviewClicked(articleUrl: String)

    }
}
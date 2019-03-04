package io.jeffchang.review.adapter

import android.annotation.SuppressLint
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
import java.text.DateFormat
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
class ReviewRecyclerViewAdapter(
        private val onReviewClickedListener: ((url: String) -> Unit)
) : ListAdapter<
        Review,
        ReviewRecyclerViewAdapter.ReviewViewHolder>(ReviewCallback()) {

    private val dateFormatter by lazy {
        SimpleDateFormat(SERVER_DATE_TIME_FORMAT)
    }

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
                review_item_mpaa_textview.text =
                        if (review.mpaaRating.isEmpty())
                            context.getString(R.string.mpaa_empty)
                        else review.mpaaRating
                review_item_headline_textview.text = review.headline
                review_item_date_textview.text = formatDate(review.publicationDate)
                review_item_desc_textview.text = review.summaryShort
            }

        }
    }

    /**
     * Unfortunately, the designers of the API didn't take into consideration localization very well.
     * It is a standard practice to use ISO 8601 or epoch time on the backend to carry timezone
     * agnostic data. The client then interprets the data based on the locale. This will be
     * erroneous because we did not know what timezone when the datetime was created.
     *
     * [dateString] Takes a string in the format of yyyy-MM-dd.
     * @return A string that is formatted by the Android [DateFormat] API. If there is an issue,
     * it will return the original string.
     */
    private fun formatDate(dateString: String): String {
        val date = dateFormatter.parse(dateString)
        return DateFormat.getDateInstance().format(date) ?: dateString
    }

    internal class ReviewCallback : DiffUtil.ItemCallback<Review>() {

        override fun areItemsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem

        override fun areContentsTheSame(oldItem: Review, newItem: Review) =
                oldItem == newItem
    }

    companion object {

        private const val SERVER_DATE_TIME_FORMAT = "yyyy-MM-dd"

    }
}
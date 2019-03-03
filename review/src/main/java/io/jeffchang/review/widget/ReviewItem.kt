package io.jeffchang.review.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import io.jeffchang.challenge.R

/**
 * Custom view that lists pull requests in a list.
 */
class ReviewItem @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.pull_request_item, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

}
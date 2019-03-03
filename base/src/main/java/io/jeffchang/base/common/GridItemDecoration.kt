package io.jeffchang.base.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.jeffchang.base.common.kt.dpToPixel

/**
 * A decoration that draws a line on RecyclerViews.
 */

/**
 * Provides spacing for items on the GridLayoutManager
 *
 * [Gist for equal spacing on GridLayoutManager] (https://gist.github.com/yqritc/ccca77dc42f2364777e1)
 */
class GridItemDecoration(private val spaceInDp: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val dpInPixel = view.dpToPixel(spaceInDp)
        outRect.set(dpInPixel, dpInPixel, dpInPixel, dpInPixel)
    }
}
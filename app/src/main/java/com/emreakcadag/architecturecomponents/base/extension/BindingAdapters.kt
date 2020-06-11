package com.emreakcadag.architecturecomponents.base.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.emreakcadag.architecturecomponents.base.GlideApp

/**
 * Created by Emre Akçadağ on 11.06.2020
 */

/*@BindingMethods(value = [
    BindingMethod(type = ImageView::class, attribute = "app:srcCompat", method = "setImageResource")
])
object BindingAdapters*/

@BindingAdapter("app:imageResource")
fun ImageView.setImageResource(resource: Any?) {
    when (resource) {
        is String -> GlideApp.with(this).load(resource).into(this)
        is Drawable -> this.setImageDrawable(resource)
        else -> Unit
    }
}

@BindingAdapter("android:visibility")
fun View.setVisibility(value: Any?) {
    this.visibility = when {
        value is List<*> && value.isNotEmpty() -> View.VISIBLE
        value is String && value.isNotBlank() -> View.VISIBLE
        value is Boolean && value -> View.VISIBLE
        value is Int && (value == View.VISIBLE || value == View.INVISIBLE || value == View.GONE) -> value
        else -> View.GONE
    }
}
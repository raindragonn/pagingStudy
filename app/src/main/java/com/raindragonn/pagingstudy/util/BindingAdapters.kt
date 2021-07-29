package com.raindragonn.pagingstudy.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("loadUrl")
fun bindUrlImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .thumbnail(0.1f)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

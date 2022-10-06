package com.example.dimvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("playerImgUrl")
fun listOfPlayerImages(img: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(img.context).load(url).into(img)
    }
}

@BindingAdapter("playerDetailImgUrl")
fun playerDetailImage(img: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(img.context).load(url).into(img)
    }
}
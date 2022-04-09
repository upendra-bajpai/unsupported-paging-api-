package com.cedcos.omdb.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders


/**
 * Created by Upendra on 19/2/2022.
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url.isNullOrEmpty()&&!url.contentEquals("http")) return
    val gurl = GlideUrl(
        url, LazyHeaders.Builder()
            .addHeader("User-Agent", "your-user-agent")
            .build()
    )
    Glide.with(this).load(gurl).override(196,196).into(this)
}

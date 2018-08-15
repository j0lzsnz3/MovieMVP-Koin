package koin.example.snapnoob.insertkoin.util.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import koin.example.snapnoob.insertkoin.BuildConfig

internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
            .load(BuildConfig.MOVIE_IMAGE_URL + url)
            .asBitmap()
            .centerCrop()
            .into(this)
}
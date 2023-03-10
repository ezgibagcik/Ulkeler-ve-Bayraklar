package com.ezgib.kotlincountries.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.ezgib.kotlincountries.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

//extensions

//hangi sınıfa eklemek istiyosan belirt


fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable)
{

    val options = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.drawable.ic_launcher_background)

    Glide.with(context)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(this)

}

fun placeHolderProgressBar(context : Context): CircularProgressDrawable
{

    return CircularProgressDrawable(context).apply {

        strokeWidth=8f
        centerRadius=40f
        start()
    }
}

@BindingAdapter("android:downloadUrl")
fun download(view:ImageView,url: String?)
{
    view.downloadFromUrl(url, placeHolderProgressBar(view.context))
}

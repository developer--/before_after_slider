package com.awesomethings.beforeafterslider.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Jemo on 12/5/16.
 */
fun ImageView.loadImage(imgUrl: String){
    Glide.with(context).load(imgUrl).into(this)
}
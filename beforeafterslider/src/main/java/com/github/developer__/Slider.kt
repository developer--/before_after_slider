package com.github.developer__

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.github.developer__.asycn.ClipDrawableTaskProcessor
import com.github.developer__.extensions.loadImage
import com.github.developer__.R
import kotlinx.android.synthetic.main.slider_layout.view.*

/**
 * Created by Jemo on 12/5/16.
 */

class Slider : RelativeLayout{

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val attr = context.theme.obtainStyledAttributes(attrs, R.styleable.Slider,0,0)
        try {
            val thumbDrawable = attr.getDrawable(R.styleable.Slider_slider_thumb)
            setSliderThumb(thumbDrawable)
        }finally {
            attr.recycle()
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.slider_layout, this)
    }

    /**
     * set original image
     */
    fun setBeforeImage(imageUri: String): Slider {
        before_image_view_id.loadImage(imageUri)
        return this
    }

    /**
     * set changed image
     */
    fun setAfterImage(imageUri: String) {
        ClipDrawableTaskProcessor(after_image_view_id, seekbar_id, context).execute(imageUri)
    }

    /**
     * set thumb
     */
    fun setSliderThumb(thumb: Drawable?){
        thumb?.let {
            seekbar_id.thumb = thumb
        }
    }
}

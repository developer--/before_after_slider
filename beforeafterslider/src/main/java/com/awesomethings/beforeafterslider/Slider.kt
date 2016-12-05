package com.awesomethings.beforeafterslider

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.awesomethings.beforeafterslider.asycn.ClipDrawableTaskProcessor
import com.awesomethings.beforeafterslider.extensions.loadImage
import kotlinx.android.synthetic.main.slider_layout.view.*

/**
 * Created by Jemo on 12/5/16.
 */

class Slider : RelativeLayout {
    
    constructor(context: Context) : super(context) {
    }

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

    fun setBeforeImage(imageUri: String): Slider {
        before_image_view_id.loadImage(imageUri)
        return this
    }

    fun setAfterImage(imageUri: String) {
        ClipDrawableTaskProcessor(after_image_view_id, seekbar_id, context).execute(imageUri)
    }

    
    fun setSliderThumb(thumb: Drawable?){
        seekbar_id.thumb = thumb
    }
}

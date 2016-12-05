package com.awesomethings.beforeafterslider.asycn

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ClipDrawable
import android.os.AsyncTask
import android.os.Looper
import android.view.Gravity
import android.widget.ImageView
import android.widget.SeekBar

import com.bumptech.glide.Glide

import java.lang.ref.WeakReference

class ClipDrawableTaskProcessor(imageView: ImageView, seekBar: SeekBar, private val context: Context) : AsyncTask<String, Void, ClipDrawable>() {
    private val imageRef: WeakReference<ImageView>
    private val seekBarRef: WeakReference<SeekBar>

    init {
        this.imageRef = WeakReference(imageView)
        this.seekBarRef = WeakReference(seekBar)
    }

    private fun scaleBitmap(bitmap: Bitmap): Bitmap? {
        try {
            if (imageRef.get() == null)
                return bitmap
            val imageWidth = imageRef.get().width
            val imageHeight = imageRef.get().height

            if (imageWidth > 0 && imageHeight > 0)
                return Bitmap.createScaledBitmap(bitmap, imageWidth, imageHeight, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun doInBackground(vararg strings: String): ClipDrawable? {
        if (Looper.myLooper() == null)
            Looper.prepare()
        try {
            var theBitmap = Glide.with(context)
                    .load(strings[0])
                    .asBitmap()
                    .into(-1, -1)
                    .get()
            val tmpBitmap = scaleBitmap(theBitmap)
            if (tmpBitmap != null)
                theBitmap = tmpBitmap

            val bitmapDrawable = BitmapDrawable(context.resources, theBitmap)
            return ClipDrawable(bitmapDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun onPostExecute(clipDrawable: ClipDrawable?) {
        if (imageRef.get() != null) {
            if (clipDrawable != null) {
                initSeekBar(clipDrawable)
                imageRef.get().setImageDrawable(clipDrawable)
                val progressNum = 5000
                clipDrawable.level = progressNum
            }
        }
    }


    private fun initSeekBar(clipDrawable: ClipDrawable) {
        seekBarRef.get().setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                clipDrawable.level = i
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }
}
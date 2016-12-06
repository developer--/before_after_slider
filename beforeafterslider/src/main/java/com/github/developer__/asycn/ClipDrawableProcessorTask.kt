package com.github.developer__.asycn

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

/**
 * Created by Jemo on 12/5/16.
 */

class ClipDrawableProcessorTask<T>(imageView: ImageView, seekBar: SeekBar, private val context: Context, private val loadedFinishedListener: OnAfterImageLoaded? = null) : AsyncTask<T, Void, ClipDrawable>() {
    private val imageRef: WeakReference<ImageView>
    private val seekBarRef: WeakReference<SeekBar>

    init {
        this.imageRef = WeakReference(imageView)
        this.seekBarRef = WeakReference(seekBar)
    }

    override fun doInBackground(vararg args: T): ClipDrawable? {
        Looper.myLooper()?.let { Looper.prepare() }
        try {
            var theBitmap : Bitmap
            if (args[0] is String) {
                theBitmap = Glide.with(context)
                        .load(args[0])
                        .asBitmap()
                        .into(-1, -1)
                        .get()
            } else {
                theBitmap = (args[0] as BitmapDrawable).bitmap
            }
            val tmpBitmap = getScaledBitmap(theBitmap)
            if (tmpBitmap != null)
                theBitmap = tmpBitmap

            val bitmapDrawable = BitmapDrawable(context.resources, theBitmap)
            return ClipDrawable(bitmapDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    private fun getScaledBitmap(bitmap: Bitmap): Bitmap? {
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

    override fun onPostExecute(clipDrawable: ClipDrawable?) {
        if (imageRef.get() != null) {
            if (clipDrawable != null) {
                initSeekBar(clipDrawable)
                imageRef.get().setImageDrawable(clipDrawable)
                val progressNum = 5000
                clipDrawable.level = progressNum
                loadedFinishedListener?.onLoadedFinished(true)
            }else {
                loadedFinishedListener?.onLoadedFinished(false)
            }
        }else {
            loadedFinishedListener?.onLoadedFinished(false)
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

    interface OnAfterImageLoaded {
        fun onLoadedFinished(loadedSuccess: Boolean)
    }
}
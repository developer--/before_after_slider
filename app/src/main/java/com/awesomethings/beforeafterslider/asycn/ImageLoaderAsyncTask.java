package com.awesomethings.beforeafterslider.asycn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Looper;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;

public class ImageLoaderAsyncTask extends AsyncTask<String, Void, ClipDrawable> {
    private WeakReference<ImageView> imageRef;
    private WeakReference<SeekBar> seekBarRef;
    private Context context;

    public ImageLoaderAsyncTask(ImageView imageView, SeekBar seekBar, Context context) {
        this.imageRef = new WeakReference<>(imageView);
        this.seekBarRef = new WeakReference<>(seekBar);
        this.context = context;
    }

    private Bitmap scaleBitmap(Bitmap bitmap){
        try {
            if(imageRef.get() == null)
                return bitmap;
            int imageWidth = imageRef.get().getWidth();
            int imageHeight = imageRef.get().getHeight();

            if (imageWidth > 0 && imageHeight > 0)
                return Bitmap.createScaledBitmap(bitmap, imageWidth, imageHeight, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected ClipDrawable doInBackground(String... strings) {
        if(strings == null || strings.length < 1)
            return null;
        if (Looper.myLooper() == null)
            Looper.prepare();
        try {
            Bitmap theBitmap = Glide.
                    with(context)
                    .load(strings[0])
                    .asBitmap()
                    .into(-1, -1)
                    .get();
            Bitmap tmpBitmap = scaleBitmap(theBitmap);
            if (tmpBitmap != null)
                theBitmap = tmpBitmap;

            Drawable bitmapDrawable = new BitmapDrawable(context.getResources(),theBitmap);
            return new ClipDrawable(bitmapDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ClipDrawable clipDrawable) {
        if(imageRef.get() != null){
            if(clipDrawable != null) {
                initSeekBar(clipDrawable);
                imageRef.get().setImageDrawable(clipDrawable);
                int progressNum = 5000;
                clipDrawable.setLevel(progressNum);
            }
        }
    }


    private void initSeekBar(final ClipDrawable clipDrawable ) {
        seekBarRef.get().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                clipDrawable.setLevel(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
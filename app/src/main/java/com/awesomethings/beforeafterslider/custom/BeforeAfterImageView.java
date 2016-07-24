package com.awesomethings.beforeafterslider.custom;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.awesomethings.beforeafterslider.R;
import com.bumptech.glide.Glide;

/**
 * Created by Master on 7/24/16.
 */

public class BeforeAfterImageView extends PercentRelativeLayout {

    private ClipDrawable clipDrawable;
    private ImageView beforeImageView;
    private ImageView afterImageView;
    private SeekBar seekBar;

    private Context context;

    public BeforeAfterImageView(Context context) {
        super(context);
        initViews(context);
    }

    public BeforeAfterImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public BeforeAfterImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }


    private void initViews(Context context){
        View customView = LayoutInflater.from(context).inflate(R.layout.before_after_image_view, this);
        beforeImageView = (ImageView) customView.findViewById(R.id.before_image_view_id);
        afterImageView = (ImageView) customView.findViewById(R.id.after_image_view_id);
        seekBar = (SeekBar) customView.findViewById(R.id.seekbar_id);
    }


    public BeforeAfterImageView build(Context context) {
        this.context = context;
        return this;
    }

    public BeforeAfterImageView setBeforeImageView(String imageUri){
        Glide.with(context)
                .load(imageUri)
                .into(beforeImageView);

        return this;
    }

    public void setAfterImageView(String imageUri){
        Glide.with(context)
                .load(imageUri)
                .into(afterImageView);
    }




}

package com.awesomethings.beforeafterslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.awesomethings.beforeafterslider.custom.BeforeAfterImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BeforeAfterImageView slider = (BeforeAfterImageView) findViewById(R.id.before_after_slider_id);
        String img1 = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQh_U6ZLeHau3T6-LL9uGQHMoI7TI8PS3-I0cEO5J-EGrgUZNBh";
        String img2 = "http://www.cs.stir.ac.uk/~kjt/sailing/lasc/image/wallpaper/club-house-16-9.jpg";

        slider
              .setBeforeImageView(img1)
              .setAfterImageView(img2);

    }
}

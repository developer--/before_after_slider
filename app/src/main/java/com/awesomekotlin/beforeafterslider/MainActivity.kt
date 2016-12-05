package com.awesomekotlin.beforeafterslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img1 = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQh_U6ZLeHau3T6-LL9uGQHMoI7TI8PS3-I0cEO5J-EGrgUZNBh"
        val img2 = "http://www.cs.stir.ac.uk/~kjt/sailing/lasc/image/wallpaper/club-house-16-9.jpg"

        before_after_slider_id
                .setBeforeImage(img1)
                .setAfterImage(img2)
    }
}

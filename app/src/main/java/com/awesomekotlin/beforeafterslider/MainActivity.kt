package com.awesomekotlin.beforeafterslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgUrl1 = "http://storage.googleapis.com/ix_choosemuse/uploads/2016/02/android-logo.png"
        val imgUrl2 = "http://www.heise.de/imgs/18/1/4/5/4/0/3/1/kotlin-746417a7cc2556af.jpeg"

        before_after_slider_id.setBeforeImage(imgUrl1).setAfterImage(imgUrl2)
    }
}

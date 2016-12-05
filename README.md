# before_after_slider
Before after slider demo

<p align="center">
  <img src="before-after-slider.gif"/>
</p>


<h1> instructions </h1>

```xml
<!-- Into your xml layout -->

  <com.awesomethings.beforeafterslider.Slider
        android:id="@+id/mySlider"
        android:layout_width="match_parent"
        android:layout_height="300dp">
  </com.awesomethings.beforeafterslider.Slider>
```

```kotlin
  //Inside java
  
  mySlider.setBeforeImage(imgUrl1).setAfterImage(imgUrl2)
```

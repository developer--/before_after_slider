# <h1 align="center">Before and after image slider</h1>
<p align="center">
  <img src="before-after-slider.gif"/>
</p>
The library uses Glide for image loading

---------------------------------------------------------

Fix: The image clip retains its last position when screen orientation changes.

---------------------------------------------------------

```java
  <com.github.developer__.BeforeAfterSlider
        android:id="@+id/mySlider"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        app:slider_thumb="@mipmap/white_circle" 
        />
```

```kotlin
  //Inside java
  
  mySlider.setBeforeImage(imgUrl1).setAfterImage(imgUrl2)  
```

```kotlin
  //to change slider_thumb programmaticaly
  mySlider.setSliderThumb(yourDrawable)
```

```xml  
  <!--  to set images from xml  -->
  app:before_image="@mipmap/image1"
  app:after_image="@mipmap/image2"
```

<h1>Gradle dependency</h1>

```groovy        
//ORIGINAL
//add this to your top level build.gradle file
 maven { url 'https://dl.bintray.com/kandroid/maven' }
 
//and add this to your module level build.gradle file
  compile 'com.github.developer--:beforeafterslider:1.0.4'
  
//MY VERSION
//add this to your top level build.gradle file
  maven { url 'https://jitpack.io' }
```

<h1><a href="https://github.com/ioramashvili/BeforeAfterSlider"> iOS version</a> </h1>

# <h1 align="center">Before and after image slider</h1>
<p align="center">
  <img src="before-after-slider.gif"/>
</p>

<h1> instructions </h1>

```xml
<!-- Inside your xml layout -->

  <com.github.developer__.Slider
        android:id="@+id/mySlider"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        app:slider_thumb="@mipmap/white_circle" 
        >
  </com.github.developer__.Slider>
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

<h1>Maven dependency</h1>
```groovy
<dependency>
  <groupId>com.github.developer--</groupId>
  <artifactId>beforeafterslider</artifactId>
  <version>1.0.2</version>
  <type>pom</type>
</dependency>
```
<h1>Gradle dependency</h1>

```groovy        
  compile 'com.github.developer--:beforeafterslider:1.0.2'
```

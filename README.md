# <h1 align="center">Before and after image slider</h1>
<p align="center">
  <img src="before-after-slider.gif"/>
</p>

<h1> instructions </h1>

```xml
<!-- Inside your xml layout -->

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

<h1>Maven dependency</h1>
```groovy
<dependency>
  <groupId>com.awesomethings.beforeafterslider</groupId>
  <artifactId>beforeafterslider</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```
<h1>Gradle dependency</h1>
```groovy
  maven {
     url  "https://dl.bintray.com/kandroid/maven/"
  }  
```
```groovy        
  compile 'com.awesomethings.beforeafterslider:beforeafterslider:1.0.0'
```

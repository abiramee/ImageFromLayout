# ImageFromLayout
[![License](https://img.shields.io/badge/License-Apache%202-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![API](https://img.shields.io/badge/API-15+-orange.svg)](https://github.com/abiramee/ImageFromLayout)
[![](https://jitpack.io/v/abiramee/Imagefromlayout.svg)](https://jitpack.io/#abiramee/Imagefromlayout)

## Description
##### ImageFromLayout is an android library. From this android library, you can easily convert your android custom layout to image. 

## How to use
Add these lines in your build.gradle files:
##### In your Project Level build.gradle
```gradle
allprojects {
  repositories {
		...
		maven { url 'https://jitpack.io' }
    } 
  }
}
```
##### In your App Level build.gradle

```gradle
dependencies {
	        implementation 'com.github.abiramee:Imagefromlayout:1.1.0'
	}
```
# Using Maven
##### Step 1. Add the JitPack repository to your build file
```maven
<repositories>
	<repository>
		 <id>jitpack.io</id>
		 <url>https://jitpack.io</url>
	</repository>
</repositories>
```
##### Step 2. Add the dependency
```maven
<dependency>
	    <groupId>com.github.abiramee</groupId>
	    <artifactId>Imagefromlayout</artifactId>
	    <version>1.1.0</version>
</dependency>
```
# Basic Usage
##### SetUp ImageFromLayout from Java 
```java
//get bitmap
ImageFromLayout.getBitmap(getApplicationContext(), mLinearLayoutParentLayout);

//save image in storage
ImageFromLayout.saveImage(getApplicationContext(), mLinearLayoutParentLayout, "fileName", Format.JPG)

//save image in storage with file path
ImageFromLayout.saveImage(getApplicationContext(), mLinearLayoutParentLayout, "filePath", "fileName", Format.JPG)
 
 //happy coding :) 
```

### Let's get connected
- [Facebook](http://facebook.com/hossain.amee)
- [Github](https://github.com/abiramee)
- [LinkedIn](https://www.linkedin.com/in/abirhossainamee)

### License
```
   Copyright (C) 2018 Abir Hossain Amee
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

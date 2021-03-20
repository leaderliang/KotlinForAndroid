# KotlinForAndroid
Kotlin for android


> android studio 预览版 抢先体验 Android Studio 中的最新功能和改进，下载地址：
> https://developer.android.com/studio/preview/?utm_source=android-studio



from project root build.gradle file content

```groovy
 // Top-level build file where
you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.3.50'
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.2'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```


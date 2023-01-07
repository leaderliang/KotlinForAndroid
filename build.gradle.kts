// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
//    ext.kotlin_version = "1.3.50"
    val kotlinVersion by rootProject.extra { "1.3.50" }

    repositories {
        google()
        jcenter()

    }

    dependencies {
        classpath ("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
//        classpath(kotlin("gradle-plugin",version = "1.7.10"))

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

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}

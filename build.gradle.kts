// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.3.1" apply false
    id("com.android.library") version "8.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
}
buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
        classpath("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
        classpath("androidx.compose.runtime:runtime-livedata:1.6.7")
    }
}
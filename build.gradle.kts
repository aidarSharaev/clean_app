// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val jvmTarget by extra { "17" }
    val versionName by extra { "1.0" }
    val versionCode by extra { 1 }
    val namespace by extra { 21 }
    val minSdk by extra { "ru.aidar.clean_app" }
    val targetSdk by extra { 34 }
    val compileSdk by extra { 34 }

    val daggerVersion by extra { "2.50" }
    val retrofitVersion by extra { "2.9.0" }
    val serializationGsonVersion by extra { "1.6.0" }
    val okhttpVersion by extra { "4.12.0" }

    val viewModelVersion by extra { "2.7.0" }

    val composeVersion by extra { "1.6.2" }
    val material3Version by extra { "1.2.0" }

    val navigationVersion by extra { "2.7.7" }

    val dataStoreVersion by extra { "1.0.0" }

    val injectVersion by extra { "1" }

    val activityVersion by extra { "1.8.2" }

    val roomVersion by extra { "2.6.1" }


    val daggerDep by extra { "com.google.dagger:dagger:$daggerVersion" }
    val daggerKapt by extra { "com.google.dagger:dagger-compiler:$daggerVersion" }

    val retrofitDep by extra { "com.squareup.retrofit2:retrofit:$retrofitVersion" }
    val converterGsonDep by extra { "com.squareup.retrofit2:converter-gson:$retrofitVersion" }
    val serializationDep by extra { "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationGsonVersion" }
    val okhttpDep by extra { "com.squareup.okhttp3:okhttp:$okhttpVersion" }
    val loggingInterceptorDep by extra { "com.squareup.okhttp3:logging-interceptor:$okhttpVersion" }

    val viewModelDep by extra { "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion" }

    val navigationDep by extra { "androidx.navigation:navigation-fragment:$navigationVersion" }

    val dataStoreDep by extra { "androidx.datastore:datastore-preferences:$dataStoreVersion" }
    val dataStoreCoreDep by extra { "androidx.datastore:datastore-preferences-core:$dataStoreVersion" }

    val bomDep by extra { "androidx.compose:compose-bom:2024.02.01" }
    val foundationDep by extra { "androidx.compose.foundation:foundation:$composeVersion" }
    val material3Dep by extra { "androidx.compose.material3:material3:$material3Version" }
    val composeDep by extra { "androidx.compose.ui:ui-android:$composeVersion" }

    val injectDep by extra { "javax.inject:javax.inject:$injectVersion" }

    val activityDep by extra { "androidx.activity:activity-ktx:$activityVersion" }

    val roomDep by extra { "androidx.room:room-runtime:$roomVersion" }
    val roomAp by extra { "androidx.room:room-compiler:$roomVersion" }

    // To use Kotlin annotation processing tool (kapt)
    val roomKapt by extra { "androidx.room:room-compiler:$roomVersion" }
}


plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.22" apply false
    id("com.android.library") version "8.2.2" apply false
}


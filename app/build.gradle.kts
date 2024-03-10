plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "ru.aidar.clean_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.aidar.clean_app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":app_common"))
    implementation(project(":menu_impl"))
    implementation(project(":cat-impl"))
    implementation(project(":dog-impl"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    //implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(rootProject.extra["viewModelDep"].toString())

    implementation(rootProject.extra["daggerKapt"].toString())
    kapt(rootProject.extra["daggerDep"].toString())

    implementation(rootProject.extra["injectDep"].toString())

    implementation(rootProject.extra["okhttpDep"].toString())
    implementation(rootProject.extra["loggingInterceptorDep"].toString())
    implementation(rootProject.extra["retrofitDep"].toString())
    implementation(rootProject.extra["serializationDep"].toString())
    implementation(rootProject.extra["converterGsonDep"].toString())

    implementation(rootProject.extra["navigationDep"].toString())

    implementation(rootProject.extra["material3Dep"].toString())
    implementation(rootProject.extra["composeDep"].toString())
    implementation(rootProject.extra["bomDep"].toString())
    implementation(rootProject.extra["foundationDep"].toString())
}

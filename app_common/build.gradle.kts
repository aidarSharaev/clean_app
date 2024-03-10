plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "ru.aidar.app_common"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(rootProject.extra["viewModelDep"].toString())
    implementation(rootProject.extra["dataStoreDep"].toString())
    implementation(rootProject.extra["dataStoreCoreDep"].toString())
    implementation(rootProject.extra["injectDep"].toString())

    implementation(rootProject.extra["okhttpDep"].toString())
    implementation(rootProject.extra["loggingInterceptorDep"].toString())

    implementation(rootProject.extra["retrofitDep"].toString())
    implementation(rootProject.extra["converterGsonDep"].toString())
    implementation(rootProject.extra["serializationDep"].toString())

    implementation(rootProject.extra["activityDep"].toString())

    implementation(rootProject.extra["daggerDep"].toString())
    implementation(rootProject.extra["daggerKapt"].toString())
}

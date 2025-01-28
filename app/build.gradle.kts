plugins {
//    alias(libs.plugins.dagger)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.newsappproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newsappproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    configurations {
        implementation.get().exclude(mapOf("group" to "org.jetbrains", "module" to "annotations"))
    }

    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.paging.compose)

    // Retrofit for Networking
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // Dagger Hilt
//    implementation (libs.hilt.android)
//    kapt(libs.hilt.android.compiler)
//    implementation(libs.hilt.compose.navigation)

    // Room Database
    implementation (libs.androidx.room.runtime)
    implementation(libs.androidx.room.compiler)
    kapt("androidx.room:room-compiler:2.6.1")
    implementation(libs.annotations)     // Or the latest version

    // Coil for Image Loading
    implementation (libs.io.coil.kt.coil.compose2)

    // WorkManager
    implementation (libs.androidx.work.runtime.ktx)

    //koin
    implementation (libs.insert.koin.koin.android)
    implementation (libs.koin.androidx.compose)
    implementation (libs.koin.androidx.navigation)// Optional, for navigation if needed
    implementation(libs.navigation.compose.v250) // Ensure you have this dependency


    implementation (libs.androidx.material)
    implementation (libs.androidx.runtime.livedata)
    implementation (libs.androidx.lifecycle.runtime.compose)




}
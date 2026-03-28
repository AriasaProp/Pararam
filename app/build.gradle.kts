plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.serialization)
}

android {
    signingConfigs {
        create("mainSign") {
            storeFile = file("sign.keystore")
            storePassword = "123456"
            keyAlias = "demo"
            keyPassword = "123456"
        }
    }

    compileSdk = libs.versions.compileSdk.get().toInt()
    ndkVersion = libs.versions.ndk.get()
    namespace = libs.versions.packageName.get()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        applicationId = libs.versions.packageName.get()
        versionCode = libs.versions.app.get().toInt()
        versionName = libs.versions.appv.get()
        signingConfig = signingConfigs["mainSign"]
        multiDexEnabled = true
        //isMinifyEnabled = true
        //isShrinkResources = true
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    testOptions {
        unitTests {
            all {
                // testLogging.showStandardStreams = true
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    
    testImplementation(libs.junit)
    
    androidTestImplementation(libs.androidx.test.junit)
}

plugins {
    alias(libs.plugins.android.application)
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
        versionName = libs.versions.appv.get().toString()
        signingConfig = signingConfigs.getByName("mainSign")
        multiDexEnabled = true

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-release.pro")
        }
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-debug.pro")
        }
    }
    testOptions {
        unitTests {
            all {
                // failOnNoDiscoveredTests = false
                // setup
                // testLogging.showStandardStreams = true
            }
        }
    }
}

dependencies {
    implenentation(libs.androidx.activity.compose)
    implenentation(libs.androidx.activity.ktx)
    implenentation(libs.androidx.compose.bom)
    implenentation(libs.androidx.compose.foundation)
    implenentation(libs.androidx.compose.foundation.layout)
    implenentation(libs.androidx.compose.material.iconsExtended)
    implenentation(libs.androidx.compose.material3)
    implenentation(libs.androidx.compose.runtime)
    implenentation(libs.androidx.compose.ui.tooling)
    implenentation(libs.androidx.compose.ui.ui)
    implenentation(libs.androidx.compose.ui.util)
    implenentation(libs.androidx.core.ktx)
    implenentation(libs.androidx.dataStore.core)
    implenentation(libs.androidx.hilt.lifecycle.viewmodel.compose)
    implenentation(libs.androidx.hilt.navigation.compose)
    implenentation(libs.androidx.lifecycle.runtime.compose)
    implenentation(libs.androidx.lifecycle.runtime.ktx)
    implenentation(libs.androidx.lifecycle.viewmodel.compose)
    implenentation(libs.androidx.lifecycle.viewmodel.ktx)
    implenentation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    
    androidTestImplementation(libs.androidx.test.junit)
}

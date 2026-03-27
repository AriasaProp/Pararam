plugins {
    alias(libs.plugins.android.application)
}

val packageName: String by rootProject.extra
val version: Int by rootProject.extra
val versionName: String by rootProject.extra

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
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.recyclerview)
    
    testImplementation(libs.junit)
    
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}
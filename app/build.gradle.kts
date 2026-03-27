plugins {
    id("com.android.application")
}

var company = "com.ariasaproject.pararam"

android {
    signingConfigs {
        create("mainSign") {
            storeFile = file("sign.keystore")
            storePassword = "123456"
            keyAlias = "demo"
            keyPassword = "123456"
        }
    }

    compileSdk = 36
    ndkVersion = 
    namespace = company.toString()

    defaultConfig {
        minSdk = 28
        targetSdk = 33
        applicationId = company.toString()
        versionCode = 1
        versionName = "v0.0.0"
        signingConfig = signingConfigs.getByName("mainSign")
        multiDexEnabled = true

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core:1.7.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    
    testImplementation("junit:junit:6.0.3")
    
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
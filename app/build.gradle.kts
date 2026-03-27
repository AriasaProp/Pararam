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
    ndkVersion = "27.3.13750724"
    namespace = company.toString()

    defaultConfig {
        applicationId = company.toString()
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "v0.0.0"
        signingConfig = signingConfigs.getByName("mainSign")
        multiDexEnabled = true
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            file("proguard-rules.pro")
        )
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    // testOptions {
    //     unitTests.all {
    //             events("passed", "skipped", "failed", "standardOut", "standardError")
    //         testLogging.showStandardStreams = true
    //         testLogging.exceptionFormat = "full"
    //     }
    // }
}

dependencies {
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.0") {
        exclude(group = "com.android.support", module = "support-annotations")
    }

    implementation("androidx.core:core:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:6.0.3")
}

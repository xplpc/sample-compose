plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = "com.xplpc.runner"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    flatDir { dirs("libs") }
}

dependencies {
    // TODO: when in xplpc
    //implementation(project(":xplpc"))

    implementation(files("libs/library-release.aar"))
    implementation("com.google.code.gson:gson:2.10")

    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.multidex:multidex:2.0.1")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.xplpc.runner.compose.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    sourceSets {
        getByName("main") {
            res.srcDirs(
                "src/main/res",
                "../common/src/commonMain/res"
            )
        }
    }
}
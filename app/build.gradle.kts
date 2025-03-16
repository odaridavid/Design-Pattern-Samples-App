plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.mikepenz.aboutlibraries.plugin")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        val versionMajor = 1
        val versionMinor = 3
        val versionPatch = 1

        applicationId = "com.github.odaridavid.designpatterns"
        minSdk = 21
        targetSdk = 30
        versionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
        versionName = "$versionMajor.$versionMinor.$versionPatch"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            manifestPlaceholders["crashlyticsEnabled"] = true
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_round"
        }
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            manifestPlaceholders["crashlyticsEnabled"] = false
            manifestPlaceholders["appIcon"] = "@mipmap/ic_debug_launcher"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_debug_launcher_round"
        }
    }

    buildFeatures.viewBinding = true

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    val aboutLibrariesVersion = "8.9.1"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation("androidx.appcompat:appcompat:1.4.0-alpha03")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    // In-app updates
    implementation("com.google.android.play:core:1.10.0")

    // Material Design
    implementation("com.google.android.material:material:1.5.0-alpha01")

    // Libraries used info
    implementation("com.mikepenz:aboutlibraries-core:$aboutLibrariesVersion")
    implementation("com.mikepenz:aboutlibraries:$aboutLibrariesVersion")

    // Animations
    implementation("jp.wasabeef:recyclerview-animators:3.0.0")

    // Analytics
    implementation("com.google.firebase:firebase-analytics:19.0.0")

    // Crashlytics
    implementation("com.google.firebase:firebase-crashlytics:18.2.0")

    // Preference
    implementation("androidx.preference:preference-ktx:1.1.1")

    // Markdown Support
    implementation("us.feras.mdv:markdownview:1.1.0")

    // Unit testing
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
}

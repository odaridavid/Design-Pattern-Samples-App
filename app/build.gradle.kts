plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.mikepenz.aboutlibraries.plugin")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
    id("kotlin-parcelize")
}

android {
    namespace = "com.github.odaridavid.designpatterns"
    compileSdk = 35

    defaultConfig {
        val versionMajor = 1
        val versionMinor = 3
        val versionPatch = 1

        applicationId = "com.github.odaridavid.designpatterns"
        minSdk = 21
        targetSdk = 35
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    // In-app updates
    implementation("com.google.android.play:app-update:2.1.0")
    implementation("com.google.android.play:app-update-ktx:2.1.0")
    implementation("com.google.android.play:review:2.0.2")
    implementation("com.google.android.play:review-ktx:2.0.2")

    // Material Design
    implementation("com.google.android.material:material:1.12.0")

    // Libraries used info
    implementation("com.mikepenz:aboutlibraries-core:8.9.1")
    implementation("com.mikepenz:aboutlibraries:8.9.1")

    // Animations
    implementation("jp.wasabeef:recyclerview-animators:4.0.2")

    // Analytics
    implementation("com.google.firebase:firebase-analytics:22.3.0")

    // Crashlytics
    implementation("com.google.firebase:firebase-crashlytics:19.4.1")

    // Preference
    implementation("androidx.preference:preference-ktx:1.2.1")

    // Markdown Support
    implementation ("com.github.mukeshsolanki:MarkdownView-Android:2.0.0")

    // Unit testing
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
}

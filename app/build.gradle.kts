
plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
   // id ("com.google.gms.google-services")
    //id 'kotlin-kapt'
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.devtools.ksp")


}

android {
    namespace = "com.example.myshopping"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myshopping"
        minSdk = 29
        //noinspection EditedTargetSdkVersion
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
       // kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (libs.androidx.navigation.compose.v283)

    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")

    implementation (libs.androidx.core.splashscreen)
    implementation ("com.google.firebase:protolite-well-known-types:18.0.0")
    implementation ("com.google.android.gms:play-services-ads-lite:23.4.0")
    implementation ("com.android.support:support-annotations:28.0.0")
    implementation(libs.androidx.media3.common.ktx)

    val  room_version = ("2.6.1")
    val compose_ui_version=("1.5.3")
    implementation ("androidx.room:room-runtime:$room_version")
    annotationProcessor ("androidx.room:room-compiler:$room_version")
    implementation ("com.google.android.play:integrity:1.4.0")
    implementation ("androidx.core:core-ktx")

    ( constraints.implementation ("androidx.fragment:fragment:1.3.6"))
    implementation ("androidx.room:room-ktx:2.6.1")
    // kapt ("androidx.room:room-compiler:2.6.1")
    ksp ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.compose.material3:material3:1.3.0")
    implementation ("androidx.compose.animation:animation:1.7.4")//
    implementation ("androidx.compose.material3:material3-window-size-class:1.3.0")
    implementation ("androidx.core:core-ktx:1.13.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")//
    implementation ("androidx.activity:activity-compose:1.9.3")
    implementation ("androidx.compose.ui:ui:$compose_ui_version")
    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
    implementation ("androidx.compose.material:material")
    implementation ("com.google.firebase:firebase-database-ktx:21.0.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.2.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_ui_version")
    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_ui_version")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.7.4")//
    //Coroutine
    val coroutine_version = ("1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version")
    implementation ("androidx.navigation:navigation-compose")
    val nav_version = "2.8.3"

    implementation ("androidx.navigation:navigation-compose:$nav_version")
    //adMob
    implementation ("com.google.android.gms:play-services-ads:23.4.0")
}

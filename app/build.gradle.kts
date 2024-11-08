
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

    implementation (libs.androidx.lifecycle.runtime.compose)

    implementation (libs.androidx.core.splashscreen)
    implementation (libs.protolite.well.known.types)
    implementation (libs.play.services.ads.lite.v2350)
    implementation (libs.support.annotations)
    implementation(libs.androidx.media3.common.ktx)

   // val  room_version = ("2.6.1")
    //val compose_ui_version=("1.5.3")
    implementation (libs.androidx.room.runtime.v261)
    annotationProcessor (libs.androidx.room.compiler.v261)
    implementation (libs.integrity)
    implementation (libs.core.ktx)

    ( constraints.implementation ("androidx.fragment:fragment:1.3.6"))
    implementation (libs.androidx.room.ktx)
    // kapt ("androidx.room:room-compiler:2.6.1")
    ksp (libs.androidx.room.compiler.v261)
    implementation (libs.material3)
    implementation (libs.androidx.animation)//
    implementation ("androidx.compose.material3:material3-window-size-class:1.3.1")
    implementation (libs.androidx.core.ktx.v1150)
    implementation (libs.androidx.lifecycle.runtime.ktx.v287)//
    implementation (libs.androidx.activity.compose.v193)
    implementation (libs.ui)
    implementation (libs.ui.tooling.preview)
    implementation (libs.androidx.material)
    implementation (libs.firebase.database.ktx)
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.espresso.core)
    androidTestImplementation (libs.ui.test.junit4)
    debugImplementation (libs.ui.tooling)
    debugImplementation (libs.ui.test.manifest)//
    //Coroutine
    //val coroutine_version = ("1.7.1")
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.navigation.compose)
  //  val nav_version = "2.8.3"

    implementation (libs.androidx.navigation.compose.v283)
    //adMob
    implementation (libs.play.services.ads.v2350)
}

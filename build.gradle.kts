
//// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.jetbrains.kotlin.android) apply false
//
//}
buildscript {

    dependencies {
        classpath ("com.android.tools.build:gradle:8.5.2")
        classpath ("com.google.gms:google-services:4.4.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.25")    //1.9.23
        classpath ("com.android.tools.build:gradle:8.5.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.25")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
    repositories {
        google()
        mavenCentral()
    }
}
plugins {
    id ("com.android.application") version "8.5.2" apply false
    id ("com.android.library" ) version "8.5.2" apply false

    id ("org.jetbrains.kotlin.android")version "1.9.0" apply false //1.9.23
    id ("com.google.devtools.ksp" )version "1.9.10-1.0.13" apply false

}



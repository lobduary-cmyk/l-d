plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "in.rechargehub.app"
    compileSdk = 35
    defaultConfig {
        applicationId = "in.rechargehub.app"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }
}

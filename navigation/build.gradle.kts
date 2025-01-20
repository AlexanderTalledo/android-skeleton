plugins {
    id("dev.alexta.apps.plugins.libraries.android")

    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.alexta.apps.navigation"
}

dependencies {
    implementation(libs.androidx.navigation.compose)
    implementation(libs.dagger.hilt.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(project(":features:home:detail"))
    implementation(project(":features:home:master"))
    implementation(project(":shared:ui"))

    ksp(libs.dagger.hilt.compiler)
}

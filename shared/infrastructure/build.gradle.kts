plugins {
    id("dev.alexta.apps.plugins.libraries.android")

    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.alexta.apps.shared.infrastructure"
}

dependencies {
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.dagger.hilt.android)

    ksp(libs.dagger.hilt.compiler)
}

plugins {
    id("dev.alexta.apps.plugins.libraries.android")

    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.alexta.apps.business.shared"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    implementation(libs.dagger.hilt.android)

    ksp(libs.androidx.room.compiler)
    ksp(libs.dagger.hilt.compiler)
}

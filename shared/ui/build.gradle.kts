plugins {
    id("dev.alexta.apps.plugins.libraries.android")
}

android {
    namespace = "dev.alexta.apps.shared.ui"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}

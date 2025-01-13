package dev.alexta.apps.platform.build_logic.domain.platform.dependencies

internal enum class PlatformDependencyBundle(val value: String) {
    AndroidApplicationImplementation(value = "android-application-implementation"),
    AndroidApplicationKsp(value = "android-application-ksp"),
    FeatureLibraryImplementation(value = "feature-library-implementation"),
    FeatureLibraryKsp(value = "feature-library-ksp"),
}

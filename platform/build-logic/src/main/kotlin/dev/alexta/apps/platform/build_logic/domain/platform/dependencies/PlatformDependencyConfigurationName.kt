package dev.alexta.apps.platform.build_logic.domain.platform.dependencies

internal enum class PlatformDependencyConfigurationName(val value: String) {
    Api(value = "api"),
    Implementation(value = "implementation"),
    Ksp(value = "ksp"),
}

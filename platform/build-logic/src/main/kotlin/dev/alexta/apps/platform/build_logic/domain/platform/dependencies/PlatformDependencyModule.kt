package dev.alexta.apps.platform.build_logic.domain.platform.dependencies

internal enum class PlatformDependencyModule(val value: String) {
    BusinessShared(":business:shared"),
    SharedUi(":shared:ui"),
}

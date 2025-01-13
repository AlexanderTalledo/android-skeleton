package dev.alexta.apps.platform.build_logic.plugins

import dev.alexta.apps.platform.build_logic.domain.platform.plugins.PlatformPlugin
import dev.alexta.apps.platform.build_logic.domain.plugins.LibraryConventionPlugin
import org.gradle.api.Project

internal class AndroidLibraryConventionPlugin : LibraryConventionPlugin() {

    override fun apply(project: Project) = with(project) {
        applyPlugin(PlatformPlugin.AndroidLibrary)
        applyPlugin(PlatformPlugin.KotlinAndroid)
        applyPlugin(PlatformPlugin.KotlinCompose)

        configureAndroidEnvironment()
        configureKotlinOptions()
    }

}

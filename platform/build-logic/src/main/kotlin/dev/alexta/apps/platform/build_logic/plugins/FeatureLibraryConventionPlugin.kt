package dev.alexta.apps.platform.build_logic.plugins

import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyBundle
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyConfigurationName
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyModule
import dev.alexta.apps.platform.build_logic.domain.platform.plugins.PlatformPlugin
import dev.alexta.apps.platform.build_logic.domain.plugins.LibraryConventionPlugin
import org.gradle.api.Project

internal class FeatureLibraryConventionPlugin : LibraryConventionPlugin() {

    override fun apply(project: Project) = with(project) {
        applyPlugin(PlatformPlugin.AndroidLibrary)
        applyPlugin(PlatformPlugin.DaggerHilt)
        applyPlugin(PlatformPlugin.KotlinAndroid)
        applyPlugin(PlatformPlugin.Ksp)

        configureAndroidEnvironment()
        configureKotlinOptions()

        addBundleDependency(
            bundle = PlatformDependencyBundle.FeatureLibraryImplementation,
            configurationName = PlatformDependencyConfigurationName.Implementation,
        )

        addBundleDependency(
            bundle = PlatformDependencyBundle.FeatureLibraryKsp,
            configurationName = PlatformDependencyConfigurationName.Ksp,
        )

        addModuleDependency(
            module = PlatformDependencyModule.SharedUi,
            configurationName = PlatformDependencyConfigurationName.Implementation,
        )
    }

}

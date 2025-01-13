package dev.alexta.apps.platform.build_logic.domain.plugins

import dev.alexta.apps.platform.build_logic.domain.platform.config.PlatformAndroidConfig
import dev.alexta.apps.platform.build_logic.domain.platform.config.PlatformVersionCatalogsConfig
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyBundle
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyConfigurationName
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyModule
import dev.alexta.apps.platform.build_logic.domain.platform.plugins.PlatformPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.PluginAware
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal abstract class ConventionPlugin : Plugin<Project> {

    protected fun PluginAware.applyPlugin(plugin: PlatformPlugin) {
        apply(plugin = plugin.value)
    }

    protected fun Project.addBundleDependency(
        bundle: PlatformDependencyBundle,
        configurationName: PlatformDependencyConfigurationName,
    ) {
        getVersionCatalogsBundle(bundle.value)
            .also { versionCatalogsBundle ->
                addDependency(configurationName, versionCatalogsBundle)
            }
    }

    protected fun Project.addModuleDependency(
        module: PlatformDependencyModule,
        configurationName: PlatformDependencyConfigurationName,
    ) {
        addDependency(configurationName, project(module.value))
    }

    protected fun Project.configureKotlinOptions() {
        tasks.withType(KotlinJvmCompile::class) {
            compilerOptions {
                jvmTarget.set(PlatformAndroidConfig.CompileJvmTarget)
            }
        }
    }

    private fun Project.getVersionCatalogsBundle(bundleName: String) = getVersionCatalogs()
        .findBundle(bundleName)
        .get()

    private fun Project.getVersionCatalogsLibrary(libraryName: String) = getVersionCatalogs()
        .findLibrary(libraryName)
        .get()

    private fun Project.getVersionCatalogs() = extensions
        .getByType<VersionCatalogsExtension>()
        .named(PlatformVersionCatalogsConfig.NAME)

    private fun Project.addDependency(
        configurationName: PlatformDependencyConfigurationName,
        dependencyNotation: Any,
    ) {
        dependencies.add(configurationName.value, dependencyNotation)
    }

}

package dev.alexta.apps.platform.build_logic.domain.plugins

import com.android.build.api.dsl.LibraryExtension
import dev.alexta.apps.platform.build_logic.domain.platform.config.PlatformAndroidConfig
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyBundle
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyConfigurationName
import dev.alexta.apps.platform.build_logic.domain.platform.plugins.PlatformPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal abstract class AndroidLibraryConventionPlugin : ConventionPlugin() {

    override fun apply(project: Project) = with(project) {
        applyPlugin(PlatformPlugin.AndroidLibrary)
        applyPlugin(PlatformPlugin.DaggerHilt)
        applyPlugin(PlatformPlugin.KotlinAndroid)
        applyPlugin(PlatformPlugin.Ksp)

        configureAndroidEnvironment()
        configureKotlinOptions()

        addBundleDependency(
            bundle = PlatformDependencyBundle.AndroidLibraryImplementation,
            configurationName = PlatformDependencyConfigurationName.Implementation,
        )

        addBundleDependency(
            bundle = PlatformDependencyBundle.AndroidLibraryKsp,
            configurationName = PlatformDependencyConfigurationName.Ksp,
        )
    }

    private fun Project.configureAndroidEnvironment() {
        extensions.configure<LibraryExtension> {
            compileSdk = PlatformAndroidConfig.COMPILE_SDK

            compileOptions {
                sourceCompatibility = PlatformAndroidConfig.CompileJavaVersion
                targetCompatibility = PlatformAndroidConfig.CompileJavaVersion
            }
        }
    }

}

package dev.alexta.apps.platform.build_logic.domain.plugins

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.alexta.apps.platform.build_logic.domain.platform.config.PlatformAndroidConfig
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyBundle
import dev.alexta.apps.platform.build_logic.domain.platform.dependencies.PlatformDependencyConfigurationName
import dev.alexta.apps.platform.build_logic.domain.platform.plugins.PlatformPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal abstract class AndroidApplicationConventionPlugin : ConventionPlugin() {

    override fun apply(project: Project) = with(project) {
        applyPlugin(PlatformPlugin.AndroidApplication)
        applyPlugin(PlatformPlugin.DaggerHilt)
        applyPlugin(PlatformPlugin.KotlinAndroid)
        applyPlugin(PlatformPlugin.KotlinCompose)
        applyPlugin(PlatformPlugin.KotlinSerialization)
        applyPlugin(PlatformPlugin.Ksp)

        configureAndroidApplication()
        configureKotlinOptions()

        addBundleDependency(
            bundle = PlatformDependencyBundle.AndroidApplicationImplementation,
            configurationName = PlatformDependencyConfigurationName.Implementation,
        )

        addBundleDependency(
            bundle = PlatformDependencyBundle.AndroidApplicationKsp,
            configurationName = PlatformDependencyConfigurationName.Ksp,
        )
    }

    private fun Project.configureAndroidApplication() {
        extensions.configure<BaseAppModuleExtension> {
            with(PlatformAndroidConfig) {
                namespace = NAMESPACE
                compileSdk = COMPILE_SDK

                defaultConfig {
                    applicationId = APPLICATION_ID
                    minSdk = MIN_SDK
                    targetSdk = TARGET_SDK
                    versionCode = VERSION_CODE
                    versionName = VERSION_NAME
                }

                compileOptions {
                    sourceCompatibility = CompileJavaVersion
                    targetCompatibility = CompileJavaVersion
                }

                packaging {
                    resources {
                        excludes += EXCLUDED_PACKAGING_RESOURCES
                    }
                }

                buildFeatures {
                    compose = USES_COMPOSE
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.15"
                }
            }

            buildTypes {
                with(PlatformAndroidConfig.BuildTypes.Debug) {
                    getByName(NAME) {
                        applicationIdSuffix = APPLICATION_ID_SUFFIX
                        isMinifyEnabled = IS_MINIFY_ENABLED
                        isShrinkResources = IS_SHRINK_RESOURCES
                    }
                }

                with(PlatformAndroidConfig.BuildTypes.Release) {
                    getByName(NAME) {
                        applicationIdSuffix = APPLICATION_ID_SUFFIX
                        isMinifyEnabled = IS_MINIFY_ENABLED
                        isShrinkResources = IS_SHRINK_RESOURCES
                    }
                }
            }
        }
    }

}

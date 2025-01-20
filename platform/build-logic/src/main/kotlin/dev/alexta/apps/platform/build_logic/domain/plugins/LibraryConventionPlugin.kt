package dev.alexta.apps.platform.build_logic.domain.plugins

import com.android.build.api.dsl.LibraryExtension
import dev.alexta.apps.platform.build_logic.domain.platform.config.PlatformAndroidConfig
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal abstract class LibraryConventionPlugin : ConventionPlugin() {

    protected fun Project.configureAndroidEnvironment() {
        extensions.configure<LibraryExtension> {
            compileSdk = PlatformAndroidConfig.COMPILE_SDK

            defaultConfig {
                minSdk = PlatformAndroidConfig.MIN_SDK
            }

            compileOptions {
                sourceCompatibility = PlatformAndroidConfig.CompileJavaVersion
                targetCompatibility = PlatformAndroidConfig.CompileJavaVersion
            }
        }
    }

}

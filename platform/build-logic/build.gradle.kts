plugins {
    `kotlin-dsl`
}

group = "dev.alexta.apps.platform.build_logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.gradle.android)
    compileOnly(libs.gradle.kotlin)
}

gradlePlugin {
    plugins {
        register("library-application") {
            id = "dev.alexta.apps.plugins.application"
            implementationClass = "dev.alexta.apps.platform.build_logic.plugins.ApplicationConventionPlugin"
        }

        register("library-android") {
            id = "dev.alexta.apps.plugins.libraries.android"
            implementationClass = "dev.alexta.apps.platform.build_logic.plugins.AndroidLibraryConventionPlugin"
        }

        register("library-feature") {
            id = "dev.alexta.apps.plugins.libraries.feature"
            implementationClass = "dev.alexta.apps.platform.build_logic.plugins.FeatureLibraryConventionPlugin"
        }
    }
}

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
        register("plugin-application") {
            id = "dev.alexta.apps.plugins.application"
            implementationClass = "dev.alexta.apps.platform.build_logic.plugins.ApplicationConventionPlugin"
        }

        register("plugin-feature") {
            id = "dev.alexta.apps.plugins.feature"
            implementationClass = "dev.alexta.apps.platform.build_logic.plugins.FeatureConventionPlugin"
        }
    }
}

package dev.alexta.apps.platform.build_logic.plugins

import dev.alexta.apps.platform.build_logic.domain.plugins.AndroidLibraryConventionPlugin
import org.gradle.api.Project

internal class FeatureConventionPlugin : AndroidLibraryConventionPlugin() {

    override fun apply(project: Project) = with(project) {
        super.apply(this)
    }

}

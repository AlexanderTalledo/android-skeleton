package dev.alexta.apps.platform.build_logic.plugins

import dev.alexta.apps.platform.build_logic.domain.plugins.AndroidApplicationConventionPlugin
import org.gradle.api.Project

internal class ApplicationConventionPlugin : AndroidApplicationConventionPlugin() {

    override fun apply(project: Project) = with(project) {
        super.apply(this)
    }

}

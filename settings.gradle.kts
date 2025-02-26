pluginManagement {
    includeBuild("platform/build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

        mavenCentral()

        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Skeleton"

include(":app")
include(":business:shared")
include(":business:users")
include(":features:home:detail")
include(":features:home:master")
include(":navigation")
include(":shared:infrastructure")
include(":shared:ui")

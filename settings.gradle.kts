pluginManagement {
    repositories {
        google()
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

rootProject.name = "clean_app"
include(":app")
include(":cat-impl")
include(":cat-api")
include(":dog-api")
include(":dog-impl")
include(":menu_impl")
include(":app_common")

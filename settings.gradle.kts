@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
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
        maven { url = uri("https://jitpack.io") }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ProfNotesFunctional"

// Apps
include(":app")

// Core
include(
    ":core:common",
    ":core:ui",
    ":core:navigation",
)

// Features
include(
    ":feature:home",
    ":feature:add",
    ":feature:profile",
)

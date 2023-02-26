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

File(rootProject.projectDir, "modules").walk()
    .filter { it.isBuildGradleScript() }
    .filter { it != rootProject.buildFile }
    .mapNotNull { it.parentFile }
    .forEach { moduleDir ->
        val moduleName = when(moduleDir.parentFile.name) {
            "core" -> ":core:${moduleDir.name}"
            "domain" -> ":domain:${moduleDir.name}"
            "feature" -> ":feature:${moduleDir.name}"
            else -> ":${moduleDir.name}"
        }
        print(moduleName)
        include(moduleName)
        project(moduleName).projectDir = moduleDir
    }

fun File.isBuildGradleScript(): Boolean =
    isFile && name.matches("build\\.gradle(\\.kts)?".toRegex())

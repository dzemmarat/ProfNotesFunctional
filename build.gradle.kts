plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.ksp)
//    alias(libs.plugins.arrow.analysis)
    id("com.android.library") version "7.3.0" apply false
    base
}

val ktlintVersion = libs.versions.ktlint.asProvider().get()
val detektFormatting = libs.detekt.formatting
val detektCompose = libs.detekt.rules.compose

subprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
    }

    dependencies {
        detektPlugins(detektFormatting)
        detektPlugins(detektCompose)
    }
}

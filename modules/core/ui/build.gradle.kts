plugins {
    id("template.android.library")
    id("template.android.library.compose")
}

dependencies {
    implementation(projects.core.common)

    implementation(projects.domain.notes)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin)

    testImplementation(libs.bundles.test)
}

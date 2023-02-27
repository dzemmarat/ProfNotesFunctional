package ru.mrz.feature.home.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.mrz.core.navigation.SharedScreen
import ru.mrz.feature.home.pages.home.HomeScreen

val homeFeatureKoinModule = module {
    factory { NotesDependencies(notesRepository = get()) }
}

val homeFeatureScreenModule = screenModule {
    register<SharedScreen.Home> {
        HomeScreen()
    }
}

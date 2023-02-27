package ru.mrz.profnotes

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import org.koin.core.module.Module
import ru.mrz.domain.notes.di.notesDomainModule
import ru.mrz.feature.add.di.addKoinModule
import ru.mrz.feature.home.di.homeFeatureKoinModule
import ru.mrz.feature.profile.di.profileKoinModule

internal fun setupKoin(context: Context) {
    GlobalContext.startKoin {
        printLogger()
        androidLogger(Level.ERROR)
        androidContext(context)
        modules(koinModules)
    }
}

private val koinModules: List<Module> = listOf(
    homeFeatureKoinModule,
    addKoinModule,
    profileKoinModule,
    notesDomainModule,
)

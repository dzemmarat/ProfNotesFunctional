package ru.mrz.domain.notes.di

import org.koin.dsl.bind
import org.koin.dsl.module
import ru.mrz.domain.notes.INotesRepository
import ru.mrz.domain.notes.NotesRepositoryMock

val notesDomainModule = module {
    single { NotesRepositoryMock() } bind INotesRepository::class
}
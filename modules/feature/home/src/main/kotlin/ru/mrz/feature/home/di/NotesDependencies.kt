package ru.mrz.feature.home.di

import ru.mrz.domain.notes.INotesRepository

internal data class NotesDependencies(
    val notesRepository: INotesRepository,
)

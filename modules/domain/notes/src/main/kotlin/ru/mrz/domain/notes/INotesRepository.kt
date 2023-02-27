package ru.mrz.domain.notes

import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow
import ru.mrz.domain.notes.dto.Note

interface INotesRepository {
    fun getNotes(): Flow<ImmutableList<Note>>
}
package ru.mrz.domain.notes

import android.util.Log
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.mrz.domain.notes.dto.Note

class NotesRepositoryMock : INotesRepository {
    override fun getNotes(): Flow<ImmutableList<Note>> = flow {
        delay(1000)
        Log.e("Toast", "Toasr")
        emit(
            listOf(
                Note(
                    title = "Заметка 1",
                    description = "Описание заметки 1",
                    status = Note.Status.IN_PROGRESS
                )
            ).toImmutableList()
        )
    }
}
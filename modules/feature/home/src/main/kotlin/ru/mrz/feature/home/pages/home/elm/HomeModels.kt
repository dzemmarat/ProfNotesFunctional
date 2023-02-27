package ru.mrz.feature.home.pages.home.elm

import kotlinx.collections.immutable.ImmutableList
import ru.mrz.domain.notes.dto.Note

internal data class HomeState(
    val isLoading: Boolean = true,
    val error: Throwable? = null,
    val profileName: String? = null,
    val notes: ImmutableList<Note>? = null,
)

internal sealed interface HomeEffect

internal sealed interface HomeCommand {
    object LoadNotes : HomeCommand
}

internal sealed interface HomeEvent {
    sealed interface Ui : HomeEvent {
        object Init : Ui
    }

    sealed interface Internal : HomeEvent {
        data class NotesLoaded(val notes: ImmutableList<Note>) : Internal
        data class NotesLoadError(val error: Throwable) : Internal
    }
}

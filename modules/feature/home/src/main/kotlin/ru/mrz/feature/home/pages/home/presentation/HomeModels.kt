package ru.mrz.feature.home.pages.home.presentation

import ru.mrz.domain.notes.dto.Note

internal data class HomeState(
    val profileName: String,
    val notes: List<Note>
)

internal sealed class HomeEffect {
    // your code
}

internal sealed class HomeCommand {
    // your code
}

internal sealed interface HomeEvent {
    sealed class Internal : HomeEvent {
        // your code
    }

    sealed class Ui : HomeEvent {
        object System {
            object Init : Ui()
        }

        object Click {
            // your code
        }

        object Action {
            // your code
        }
    }
}
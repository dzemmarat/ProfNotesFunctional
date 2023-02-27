package ru.mrz.feature.home.pages.home.elm

import android.util.Log
import kotlinx.coroutines.flow.Flow
import ru.mrz.domain.notes.INotesRepository
import vivid.money.elmslie.coroutines.Actor

internal class HomeActor(
    private val notesRepository: INotesRepository,
) : Actor<HomeCommand, HomeEvent> {
    override fun execute(command: HomeCommand): Flow<HomeEvent> = when (command) {
        HomeCommand.LoadNotes -> notesRepository.getNotes().mapEvents(
            eventMapper = {
                Log.e("Home", "loaded")
                HomeEvent.Internal.NotesLoaded(it)
            },
            errorMapper = HomeEvent.Internal::NotesLoadError
        )
    }
}

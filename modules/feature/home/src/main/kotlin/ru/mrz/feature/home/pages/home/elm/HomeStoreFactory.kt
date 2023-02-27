package ru.mrz.feature.home.pages.home.elm

import ru.mrz.domain.notes.INotesRepository
import vivid.money.elmslie.coroutines.ElmStoreCompat

internal fun homeStoreFactory(notesRepository: INotesRepository) = ElmStoreCompat(
    initialState = HomeState(),
    reducer = HomeReducer,
    actor = HomeActor(notesRepository),
    startEvent = HomeEvent.Ui.Init
)
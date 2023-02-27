package ru.mrz.feature.home.pages.home.elm

import vivid.money.elmslie.core.store.dsl_reducer.DslReducer

internal object HomeReducer : DslReducer<HomeEvent, HomeState, HomeEffect, HomeCommand>() {
    override fun Result.reduce(event: HomeEvent) = when (event) {
        is HomeEvent.Ui -> reduceUi(event)
        is HomeEvent.Internal -> reduceInternal(event)
    }

    private fun Result.reduceUi(event: HomeEvent.Ui) = when (event) {
        is HomeEvent.Ui.Init -> commands {
            +HomeCommand.LoadNotes
        }
    }

    private fun Result.reduceInternal(event: HomeEvent.Internal) = when (event) {
        is HomeEvent.Internal.NotesLoaded -> state {
            copy(isLoading = false, notes = event.notes)
        }
        is HomeEvent.Internal.NotesLoadError -> state {
            copy(isLoading = false, error = event.error)
        }
    }
}
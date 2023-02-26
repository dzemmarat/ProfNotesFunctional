package ru.mrz.feature.home.pages.home.presentation

import vivid.money.elmslie.core.store.Result
import vivid.money.elmslie.core.store.dsl_reducer.ScreenDslReducer
import ru.mrz.feature.home.pages.home.presentation.HomeCommand.*
import ru.mrz.feature.home.pages.home.presentation.HomeEvent.Internal
import ru.mrz.feature.home.pages.home.presentation.HomeEvent.Ui

internal object HomeReducer : ScreenDslReducer<HomeEvent, Ui, Internal, HomeState,
        HomeEffect, HomeCommand>(Ui::class, Internal::class) {

    override fun Result.internal(event: Internal) = when (event) {
        else -> TODO("Not yet implemented")
    }

    override fun Result.ui(event: Ui) = when (event) {
        else -> TODO("Not yet implemented")
    }
}
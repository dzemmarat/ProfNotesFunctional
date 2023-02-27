package ru.mrz.feature.home.pages.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import org.koin.androidx.compose.get
import ru.mrz.core.ui.designsystem.Note
import ru.mrz.core.ui.designsystem.getNoteColor
import ru.mrz.core.ui.designsystem.getNoteStatus
import ru.mrz.core.ui.theme.AppTextStyle
import ru.mrz.core.ui.theme.ProfnotesTheme
import ru.mrz.feature.home.R
import ru.mrz.feature.home.di.NotesDependencies
import ru.mrz.feature.home.pages.home.elm.HomeEvent
import ru.mrz.feature.home.pages.home.elm.HomeState
import ru.mrz.feature.home.pages.home.elm.homeStoreFactory

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val notesDependencies = get<NotesDependencies>()
        val homeStore = remember { homeStoreFactory(notesDependencies.notesRepository).start() }
        val state by homeStore.states().collectAsState(HomeState())
        Log.e("Home", "state $state")
        HomeScreen(state = state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    state: HomeState,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(R.string.title_home), style = AppTextStyle.screenTitle)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            if (state.isLoading) {
                item {
                    Box(
                        modifier = Modifier.fillParentMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(56.dp))
                    }
                }
            }
            state.notes?.let {
                items(state.notes) {
                    Note(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        title = it.title,
                        description = it.description,
                        status = it.status.getNoteStatus(),
                        color = it.status.getNoteColor()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ProfnotesTheme {
        HomeScreen()
    }
}

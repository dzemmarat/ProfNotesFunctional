package ru.mrz.feature.home.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import ru.mrz.core.ui.designsystem.Note
import ru.mrz.core.ui.designsystem.getNoteColor
import ru.mrz.core.ui.designsystem.getNoteStatus
import ru.mrz.core.ui.theme.AppTextStyle
import ru.mrz.domain.notes.dto.Note
import ru.mrz.feature.home.R

class HomeScreen : AndroidScreen() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
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
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                Note(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    title = "Выполнение дз к понедельнику",
                    description = "Выучить основные компоненты андроид",
                    status = Note.Status.IN_PROGRESS.getNoteStatus(),
                    color = Note.Status.IN_PROGRESS.getNoteColor()
                )
            }
        }
    }
}

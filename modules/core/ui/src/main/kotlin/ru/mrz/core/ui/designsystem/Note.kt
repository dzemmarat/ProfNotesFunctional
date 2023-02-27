package ru.mrz.core.ui.designsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mrz.core.ui.theme.ProfnotesTheme
import ru.mrz.domain.notes.dto.Note
import ru.mrz.ui.R

@Composable
fun Note(
    title: String,
    description: String,
    status: String,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Text(text = status, color = color)
            Text(text = title)
            Text(text = description)
        }
    }
}

@Composable
fun Note.Status.getNoteColor(): Color = when (this) {
    Note.Status.NEW -> MaterialTheme.colorScheme.secondary
    Note.Status.IN_PROGRESS -> MaterialTheme.colorScheme.tertiary
    Note.Status.CLOSED -> MaterialTheme.colorScheme.error
    Note.Status.POSTPONED -> MaterialTheme.colorScheme.error
}

@Composable
fun Note.Status.getNoteStatus(): String = when (this) {
    Note.Status.NEW -> stringResource(R.string.status_note_status_new)
    Note.Status.IN_PROGRESS -> stringResource(R.string.status_note_status_in_progress)
    Note.Status.CLOSED -> stringResource(R.string.status_note_status_closed)
    Note.Status.POSTPONED -> stringResource(R.string.status_note_status_postponed)
}

@Preview
@Composable
private fun NotePreview() {
    ProfnotesTheme {
        val noteStatus = Note.Status.IN_PROGRESS
        Note(
            modifier = Modifier.fillMaxWidth(),
            title = "Выполнение дз к понедельнику",
            description = "Выучить основные компоненты андроид",
            status = noteStatus.getNoteStatus(),
            color = noteStatus.getNoteColor(),
        )
    }
}

@Preview
@Composable
private fun NoteDarkPreview() {
    ProfnotesTheme(isDarkTheme = true, false) {
        val noteStatus = Note.Status.IN_PROGRESS
        Note(
            modifier = Modifier.fillMaxWidth(),
            title = "Выполнение дз к понедельнику",
            description = "Выучить основные компоненты андроид",
            status = noteStatus.getNoteStatus(),
            color = noteStatus.getNoteColor(),
        )
    }
}
package ru.mrz.domain.notes.dto

data class Note(
    val title: String,
    val description: String,
    val status: Status,
) {
    enum class Status {
        NEW,
        IN_PROGRESS,
        CLOSED,
        POSTPONED
    }
}
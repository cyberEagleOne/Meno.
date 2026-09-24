package com.meno.app.domain.model

data class Reading(
    val id: String,
    val journeyId: String,
    val book: String,
    val chapter: Int,
    val startVerse: Int,
    val endVerse: Int,
    val order: Int,
    val isCompleted: Boolean = false
)

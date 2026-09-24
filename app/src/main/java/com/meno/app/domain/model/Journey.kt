package com.meno.app.domain.model

data class Journey(
    val id: String,
    val name: String,
    val description: String,
    val totalDays: Int,
    val readings: List<Reading> = emptyList()
)

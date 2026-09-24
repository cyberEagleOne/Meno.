package com.meno.app.domain.model

data class UserProgress(
    val id: Int = 1,
    val totalXp: Int = 0,
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastReadingDate: String? = null
)

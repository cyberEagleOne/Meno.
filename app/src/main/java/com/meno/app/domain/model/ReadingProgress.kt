package com.meno.app.domain.model

data class ReadingProgress(
    val readingId: String,
    val isCompleted: Boolean,
    val completedAt: Long? = null
)

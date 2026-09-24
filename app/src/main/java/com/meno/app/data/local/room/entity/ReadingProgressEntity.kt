package com.meno.app.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reading_progress")
data class ReadingProgressEntity(
    @PrimaryKey
    val readingId: String,
    val isCompleted: Boolean,
    val completedAt: Long? = null
)

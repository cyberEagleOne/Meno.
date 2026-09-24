package com.meno.app.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journey_progress")
data class JourneyProgressEntity(
    @PrimaryKey
    val journeyId: String,
    val completedReadingsCount: Int,
    val totalReadingsCount: Int
)

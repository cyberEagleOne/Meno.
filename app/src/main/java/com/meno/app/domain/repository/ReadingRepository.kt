package com.meno.app.domain.repository

import com.meno.app.domain.model.Reading
import kotlinx.coroutines.flow.Flow

interface ReadingRepository {
    fun getTodaysReading(): Flow<Reading?>
    fun getReadingById(readingId: String): Flow<Reading?>
    suspend fun completeReading(readingId: String)
}

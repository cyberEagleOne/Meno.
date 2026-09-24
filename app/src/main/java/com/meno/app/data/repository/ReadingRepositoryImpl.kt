package com.meno.app.data.repository

import com.meno.app.data.local.room.dao.ReadingProgressDao
import com.meno.app.domain.model.Reading
import com.meno.app.domain.repository.ReadingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReadingRepositoryImpl(
    private val readingProgressDao: ReadingProgressDao
) : ReadingRepository {

    override fun getTodaysReading(): Flow<Reading?> = flow {
        emit(
            Reading(
                id = "reading_1",
                journeyId = "journey_gospel_starter",
                book = "John",
                chapter = 1,
                startVerse = 1,
                endVerse = 18,
                order = 1
            )
        )
    }

    override fun getReadingById(readingId: String): Flow<Reading?> = flow {
        emit(
            Reading(
                id = readingId,
                journeyId = "journey_gospel_starter",
                book = "John",
                chapter = 1,
                startVerse = 1,
                endVerse = 18,
                order = 1
            )
        )
    }

    override suspend fun completeReading(readingId: String) {
        // Structural foundation for marking reading as complete in Room
    }
}

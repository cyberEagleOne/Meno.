package com.meno.app.data.repository

import com.meno.app.data.local.room.dao.JourneyProgressDao
import com.meno.app.domain.model.Journey
import com.meno.app.domain.repository.JourneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JourneyRepositoryImpl(
    private val journeyProgressDao: JourneyProgressDao
) : JourneyRepository {

    override fun getJourneys(): Flow<List<Journey>> = flow {
        emit(
            listOf(
                Journey(
                    id = "journey_gospel_starter",
                    name = "Gospel Starter",
                    description = "A 7-day guided journey through key chapters of John.",
                    totalDays = 7
                )
            )
        )
    }

    override fun getJourneyById(journeyId: String): Flow<Journey?> = flow {
        emit(
            Journey(
                id = journeyId,
                name = "Gospel Starter",
                description = "A 7-day guided journey through key chapters of John.",
                totalDays = 7
            )
        )
    }

    override fun getJourneyProgress(journeyId: String): Flow<Float> = flow {
        emit(0.14f)
    }
}

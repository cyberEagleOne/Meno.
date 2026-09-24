package com.meno.app.domain.repository

import com.meno.app.domain.model.Journey
import kotlinx.coroutines.flow.Flow

interface JourneyRepository {
    fun getJourneys(): Flow<List<Journey>>
    fun getJourneyById(journeyId: String): Flow<Journey?>
    fun getJourneyProgress(journeyId: String): Flow<Float>
}

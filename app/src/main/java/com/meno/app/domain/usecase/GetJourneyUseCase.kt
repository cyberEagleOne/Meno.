package com.meno.app.domain.usecase

import com.meno.app.domain.model.Journey
import com.meno.app.domain.repository.JourneyRepository
import kotlinx.coroutines.flow.Flow

class GetJourneyUseCase(
    private val journeyRepository: JourneyRepository
) {
    operator fun invoke(journeyId: String): Flow<Journey?> = journeyRepository.getJourneyById(journeyId)
}

package com.meno.app.domain.usecase

import com.meno.app.domain.repository.JourneyRepository
import kotlinx.coroutines.flow.Flow

class GetJourneyProgressUseCase(
    private val journeyRepository: JourneyRepository
) {
    operator fun invoke(journeyId: String): Flow<Float> = journeyRepository.getJourneyProgress(journeyId)
}

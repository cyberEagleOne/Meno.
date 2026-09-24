package com.meno.app.domain.usecase

import com.meno.app.domain.repository.ReadingRepository

class CompleteReadingUseCase(
    private val readingRepository: ReadingRepository
) {
    suspend operator fun invoke(readingId: String) {
        readingRepository.completeReading(readingId)
    }
}

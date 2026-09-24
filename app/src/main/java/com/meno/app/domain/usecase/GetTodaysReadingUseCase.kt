package com.meno.app.domain.usecase

import com.meno.app.domain.model.Reading
import com.meno.app.domain.repository.ReadingRepository
import kotlinx.coroutines.flow.Flow

class GetTodaysReadingUseCase(
    private val readingRepository: ReadingRepository
) {
    operator fun invoke(): Flow<Reading?> = readingRepository.getTodaysReading()
}

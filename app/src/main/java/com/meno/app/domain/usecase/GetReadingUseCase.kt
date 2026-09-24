package com.meno.app.domain.usecase

import com.meno.app.domain.model.Reading
import com.meno.app.domain.repository.ReadingRepository
import kotlinx.coroutines.flow.Flow

class GetReadingUseCase(
    private val readingRepository: ReadingRepository
) {
    operator fun invoke(readingId: String): Flow<Reading?> = readingRepository.getReadingById(readingId)
}

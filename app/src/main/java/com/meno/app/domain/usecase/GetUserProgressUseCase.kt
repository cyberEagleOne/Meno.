package com.meno.app.domain.usecase

import com.meno.app.domain.model.UserProgress
import com.meno.app.domain.repository.ProgressRepository
import kotlinx.coroutines.flow.Flow

class GetUserProgressUseCase(
    private val progressRepository: ProgressRepository
) {
    operator fun invoke(): Flow<UserProgress> = progressRepository.getUserProgress()
}

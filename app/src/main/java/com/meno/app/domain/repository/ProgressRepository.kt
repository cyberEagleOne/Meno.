package com.meno.app.domain.repository

import com.meno.app.domain.model.UserProgress
import kotlinx.coroutines.flow.Flow

interface ProgressRepository {
    fun getUserProgress(): Flow<UserProgress>
    suspend fun updateUserProgress(userProgress: UserProgress)
}

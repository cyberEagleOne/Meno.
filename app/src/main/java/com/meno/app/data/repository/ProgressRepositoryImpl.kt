package com.meno.app.data.repository

import com.meno.app.data.local.room.dao.UserProgressDao
import com.meno.app.domain.model.UserProgress
import com.meno.app.domain.repository.ProgressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProgressRepositoryImpl(
    private val userProgressDao: UserProgressDao
) : ProgressRepository {

    override fun getUserProgress(): Flow<UserProgress> {
        return userProgressDao.getUserProgress().map { entity ->
            entity?.let {
                UserProgress(
                    id = it.id,
                    totalXp = it.totalXp,
                    currentStreak = it.currentStreak,
                    longestStreak = it.longestStreak,
                    lastReadingDate = it.lastReadingDate
                )
            } ?: UserProgress()
        }
    }

    override suspend fun updateUserProgress(userProgress: UserProgress) {
        // Structural implementation
    }
}

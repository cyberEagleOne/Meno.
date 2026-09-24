package com.meno.app.domain.usecase

import com.meno.app.domain.model.UserProgress

class UpdateStreakUseCase {
    operator fun invoke(userProgress: UserProgress, isConsecutiveDay: Boolean): UserProgress {
        val newStreak = if (isConsecutiveDay) userProgress.currentStreak + 1 else 1
        val newLongest = maxOf(userProgress.longestStreak, newStreak)
        return userProgress.copy(
            currentStreak = newStreak,
            longestStreak = newLongest
        )
    }
}

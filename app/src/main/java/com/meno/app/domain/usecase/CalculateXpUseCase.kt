package com.meno.app.domain.usecase

class CalculateXpUseCase {
    operator fun invoke(currentXp: Int, rewardXp: Int = 10): Int {
        return currentXp + rewardXp
    }
}

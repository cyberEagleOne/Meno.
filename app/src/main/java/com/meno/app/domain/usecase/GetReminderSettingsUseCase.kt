package com.meno.app.domain.usecase

import com.meno.app.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

data class ReminderSettings(
    val isEnabled: Boolean,
    val time: String
)

class GetReminderSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(): Flow<ReminderSettings> {
        return combine(
            settingsRepository.isReminderEnabled(),
            settingsRepository.getReminderTime()
        ) { enabled, time ->
            ReminderSettings(isEnabled = enabled, time = time)
        }
    }
}

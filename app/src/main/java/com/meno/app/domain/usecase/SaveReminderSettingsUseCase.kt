package com.meno.app.domain.usecase

import com.meno.app.domain.repository.SettingsRepository

class SaveReminderSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(enabled: Boolean, time: String) {
        settingsRepository.setReminderSettings(enabled, time)
    }
}

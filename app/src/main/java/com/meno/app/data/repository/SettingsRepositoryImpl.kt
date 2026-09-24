package com.meno.app.data.repository

import com.meno.app.data.local.datastore.SettingsDataStore
import com.meno.app.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(
    private val settingsDataStore: SettingsDataStore
) : SettingsRepository {

    override fun isReminderEnabled(): Flow<Boolean> = settingsDataStore.reminderEnabled

    override fun getReminderTime(): Flow<String> = settingsDataStore.reminderTime

    override suspend fun setReminderSettings(enabled: Boolean, time: String) {
        settingsDataStore.setReminderSettings(enabled, time)
    }
}

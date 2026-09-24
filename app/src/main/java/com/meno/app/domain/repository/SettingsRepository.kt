package com.meno.app.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun isReminderEnabled(): Flow<Boolean>
    fun getReminderTime(): Flow<String>
    suspend fun setReminderSettings(enabled: Boolean, time: String)
}

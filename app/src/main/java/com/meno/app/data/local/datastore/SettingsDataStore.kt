package com.meno.app.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "meno_settings")

class SettingsDataStore(private val context: Context) {

    companion object {
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
        val SELECTED_JOURNEY_ID = stringPreferencesKey("selected_journey_id")
        val REMINDER_ENABLED = booleanPreferencesKey("reminder_enabled")
        val REMINDER_TIME = stringPreferencesKey("reminder_time")
    }

    val onboardingCompleted: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[ONBOARDING_COMPLETED] ?: false
    }

    val selectedJourneyId: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[SELECTED_JOURNEY_ID] ?: "journey_gospel_starter"
    }

    val reminderEnabled: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[REMINDER_ENABLED] ?: true
    }

    val reminderTime: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[REMINDER_TIME] ?: "08:00 AM"
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED] = completed
        }
    }

    suspend fun setSelectedJourneyId(journeyId: String) {
        context.dataStore.edit { preferences ->
            preferences[SELECTED_JOURNEY_ID] = journeyId
        }
    }

    suspend fun setReminderSettings(enabled: Boolean, time: String) {
        context.dataStore.edit { preferences ->
            preferences[REMINDER_ENABLED] = enabled
            preferences[REMINDER_TIME] = time
        }
    }
}

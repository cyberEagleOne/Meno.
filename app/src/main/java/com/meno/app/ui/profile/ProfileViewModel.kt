package com.meno.app.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProfileUiState(
    val isReminderEnabled: Boolean = true,
    val reminderTime: String = "08:00 AM"
)

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun updateReminderSettings(enabled: Boolean, time: String) {
        _uiState.value = _uiState.value.copy(
            isReminderEnabled = enabled,
            reminderTime = time
        )
    }
}

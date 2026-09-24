package com.meno.app.ui.progress

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProgressUiState(
    val currentStreak: Int = 1,
    val longestStreak: Int = 1,
    val totalXp: Int = 10,
    val completedReadingsCount: Int = 1
)

class ProgressViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProgressUiState())
    val uiState: StateFlow<ProgressUiState> = _uiState.asStateFlow()
}

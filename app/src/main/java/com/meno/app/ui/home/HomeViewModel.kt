package com.meno.app.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val isLoading: Boolean = false,
    val todaysReadingTitle: String = "John 1:1–18",
    val todaysReadingId: String = "reading_1",
    val selectedJourneyId: String = "journey_gospel_starter",
    val currentStreak: Int = 1,
    val totalXp: Int = 10,
    val errorMessage: String? = null
)

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}

package com.meno.app.ui.journey

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class JourneyUiState(
    val journeyId: String = "journey_gospel_starter",
    val title: String = "Gospel Starter",
    val description: String = "A 7-day guided journey through key chapters of the Gospel of John.",
    val progressPercent: Float = 0.14f,
    val completedCount: Int = 1,
    val totalCount: Int = 7
)

class JourneyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(JourneyUiState())
    val uiState: StateFlow<JourneyUiState> = _uiState.asStateFlow()
}

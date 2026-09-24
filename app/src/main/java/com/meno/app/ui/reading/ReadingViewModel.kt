package com.meno.app.ui.reading

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ReadingUiState(
    val readingId: String = "reading_1",
    val title: String = "John 1:1–18",
    val passageText: String = "In the beginning was the Word, and the Word was with God, and the Word was God...",
    val isCompleted: Boolean = false
)

class ReadingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReadingUiState())
    val uiState: StateFlow<ReadingUiState> = _uiState.asStateFlow()

    fun completeReading() {
        _uiState.value = _uiState.value.copy(isCompleted = true)
    }
}

package com.meno.app.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meno.app.ui.components.MenoButton
import com.meno.app.ui.components.MenoCard

@Composable
fun ProfileScreen(
    onNavigateToReminderSettings: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = ProfileViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Profile & Settings",
            style = MaterialTheme.typography.headlineLarge
        )

        MenoCard(
            title = "Daily Reading Reminder",
            description = if (uiState.isReminderEnabled) {
                "Reminder set for ${uiState.reminderTime} daily"
            } else {
                "Reminders disabled"
            }
        ) {
            MenoButton(
                text = "Reminder Settings",
                onClick = onNavigateToReminderSettings,
                modifier = Modifier.fillMaxWidth()
            )
        }

        MenoCard(
            title = "About Meno",
            description = "Meno — Read. Remain. Grow.\nA native Android MVP to build a consistent Scripture reading habit."
        )
    }
}

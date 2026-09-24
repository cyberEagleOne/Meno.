package com.meno.app.ui.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.meno.app.ui.components.MenoCard
import com.meno.app.ui.components.MenoStatCard

@Composable
fun ProgressScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgressViewModel = ProgressViewModel()
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
            text = "Your Progress",
            style = MaterialTheme.typography.headlineLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MenoStatCard(
                title = "Current Streak",
                value = "${uiState.currentStreak} Days",
                subtitle = "Active habit",
                modifier = Modifier.weight(1f)
            )

            MenoStatCard(
                title = "Longest Streak",
                value = "${uiState.longestStreak} Days",
                subtitle = "Personal best",
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MenoStatCard(
                title = "Total XP",
                value = "${uiState.totalXp} XP",
                subtitle = "Earned points",
                modifier = Modifier.weight(1f)
            )

            MenoStatCard(
                title = "Readings",
                value = "${uiState.completedReadingsCount}",
                subtitle = "Completed",
                modifier = Modifier.weight(1f)
            )
        }

        MenoCard(
            title = "Habit Growth",
            description = "Consistent small daily readings lead to long-term spiritual growth."
        )
    }
}

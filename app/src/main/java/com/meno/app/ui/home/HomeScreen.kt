package com.meno.app.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.meno.app.ui.components.MenoReadingCard
import com.meno.app.ui.components.MenoStatCard

@Composable
fun HomeScreen(
    onNavigateToReading: (String) -> Unit,
    onNavigateToJourney: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = HomeViewModel()
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
            text = "Daily Reading",
            style = MaterialTheme.typography.headlineLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MenoStatCard(
                title = "Streak",
                value = "${uiState.currentStreak} Days",
                subtitle = "Keep it up!",
                modifier = Modifier.weight(1f)
            )

            MenoStatCard(
                title = "Total XP",
                value = "${uiState.totalXp} XP",
                subtitle = "Earned so far",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Today's Reading",
            style = MaterialTheme.typography.titleLarge
        )

        MenoReadingCard(
            title = "Gospel Starter — Day 1",
            passage = uiState.todaysReadingTitle,
            subtitle = "John 1:1–18 • ~3 min read",
            onClick = { onNavigateToReading(uiState.todaysReadingId) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        MenoCard(
            title = "Current Journey",
            description = "Explore guided Bible journeys tailored for your pace."
        ) {
            MenoButton(
                text = "View Journey",
                onClick = { onNavigateToJourney(uiState.selectedJourneyId) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

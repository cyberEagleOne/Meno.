package com.meno.app.ui.journey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.meno.app.ui.components.MenoProgressBar

@Composable
fun JourneyScreen(
    journeyId: String,
    onNavigateToReading: (String) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: JourneyViewModel = JourneyViewModel()
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
            text = uiState.title,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = uiState.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        MenoProgressBar(
            progress = uiState.progressPercent,
            label = "Progress: ${uiState.completedCount}/${uiState.totalCount} Days"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Readings in Journey",
            style = MaterialTheme.typography.titleLarge
        )

        MenoCard(
            title = "Day 1: The Word Became Flesh",
            description = "John 1:1–18"
        ) {
            MenoButton(
                text = "Start Reading",
                onClick = { onNavigateToReading("reading_1") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        MenoCard(
            title = "Day 2: The Lamb of God",
            description = "John 1:19–34"
        )

        MenoCard(
            title = "Day 3: Jesus Calls His First Disciples",
            description = "John 1:35–51"
        )
    }
}

package com.meno.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.meno.app.ui.completion.CompletionScreen
import com.meno.app.ui.components.MenoBottomNavigation
import com.meno.app.ui.home.HomeScreen
import com.meno.app.ui.journey.JourneyScreen
import com.meno.app.ui.onboarding.OnboardingScreen
import com.meno.app.ui.profile.ProfileScreen
import com.meno.app.ui.profile.ReminderSettingsScreen
import com.meno.app.ui.progress.ProgressScreen
import com.meno.app.ui.reading.ReadingScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.ONBOARDING
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarRoutes = listOf(Routes.HOME, Routes.PROGRESS, Routes.PROFILE)

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (currentRoute in bottomBarRoutes) {
                MenoBottomNavigation(
                    currentRoute = currentRoute,
                    onNavigateToRoute = { route ->
                        if (currentRoute != route) {
                            navController.navigate(route) {
                                popUpTo(Routes.HOME) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.ONBOARDING) {
                OnboardingScreen(
                    onNavigateToHome = {
                        navController.navigate(Routes.HOME) {
                            popUpTo(Routes.ONBOARDING) { inclusive = true }
                        }
                    }
                )
            }

            composable(Routes.HOME) {
                HomeScreen(
                    onNavigateToReading = { readingId ->
                        navController.navigate(Routes.reading(readingId))
                    },
                    onNavigateToJourney = { journeyId ->
                        navController.navigate(Routes.journeyDetail(journeyId))
                    }
                )
            }

            composable(
                route = Routes.JOURNEY_DETAIL,
                arguments = listOf(navArgument("journeyId") { type = NavType.StringType })
            ) { backStackEntry ->
                val journeyId = backStackEntry.arguments?.getString("journeyId") ?: ""
                JourneyScreen(
                    journeyId = journeyId,
                    onNavigateToReading = { readingId ->
                        navController.navigate(Routes.reading(readingId))
                    },
                    onBack = { navController.popBackStack() }
                )
            }

            composable(
                route = Routes.READING,
                arguments = listOf(navArgument("readingId") { type = NavType.StringType })
            ) { backStackEntry ->
                val readingId = backStackEntry.arguments?.getString("readingId") ?: ""
                ReadingScreen(
                    readingId = readingId,
                    onNavigateToCompletion = {
                        navController.navigate(Routes.COMPLETION) {
                            popUpTo(Routes.HOME) { saveState = false }
                        }
                    },
                    onBack = { navController.popBackStack() }
                )
            }

            composable(Routes.COMPLETION) {
                CompletionScreen(
                    onNavigateToHome = {
                        navController.navigate(Routes.HOME) {
                            popUpTo(Routes.HOME) { inclusive = true }
                        }
                    }
                )
            }

            composable(Routes.PROGRESS) {
                ProgressScreen()
            }

            composable(Routes.PROFILE) {
                ProfileScreen(
                    onNavigateToReminderSettings = {
                        navController.navigate(Routes.REMINDER_SETTINGS)
                    }
                )
            }

            composable(Routes.REMINDER_SETTINGS) {
                ReminderSettingsScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

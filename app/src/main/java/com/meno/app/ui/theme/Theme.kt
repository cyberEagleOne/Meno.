package com.meno.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MenoLightColorScheme = lightColorScheme(
    primary = MenoTeal,
    onPrimary = MenoSurface,
    primaryContainer = MenoTealLight,
    onPrimaryContainer = MenoSurface,
    secondary = MenoTealLight,
    onSecondary = MenoSurface,
    tertiary = MenoOrange,
    onTertiary = MenoTextPrimary,
    background = MenoBackground,
    onBackground = MenoTextPrimary,
    surface = MenoSurface,
    onSurface = MenoTextPrimary,
    surfaceVariant = MenoSurfaceVariant,
    onSurfaceVariant = MenoTextSecondary,
    error = MenoError,
    onError = MenoSurface
)

@Composable
fun MenoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Meno MVP uses warm light palette as default per design specs
    MaterialTheme(
        colorScheme = MenoLightColorScheme,
        typography = MenoTypography,
        shapes = MenoShapes,
        content = content
    )
}

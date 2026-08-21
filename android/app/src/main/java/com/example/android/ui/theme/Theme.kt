package com.example.android.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    // Main Background Container Color
    background = premiumBlack,

    // Cards
    primaryContainer = glassBlack,
    primary = classicWhite,
    secondary = lightGray80,

    // Cards/Add-to-Watchlist
    tertiaryContainer = darkRed,
    onTertiaryContainer = classicWhite,
    tertiary = classicWhite,
    onTertiary = classicBlack,

    // Chip
    secondaryContainer = classicBlack70,
    onSecondary = classicWhite,

    // Nav Items
    primaryFixed = classicWhite70,
    onPrimaryFixed = darkRed,

    // Skeleton Colors
    surfaceContainer = skeletonDark
)

private val LightColorScheme = lightColorScheme(
    // Main Background Container Color
    background = premiumWhite,

    // Cards
    primaryContainer = glassWhite,
    primary = classicBlack,
    secondary = lightGray20,

    // Cards / Add-to-Watchlist
    tertiaryContainer = darkRed,
    onTertiaryContainer = classicWhite,
    tertiary = classicWhite,
    onTertiary = classicBlack,

    // Chip
    secondaryContainer = classicWhite70,
    onSecondary = classicBlack70,

    // Nav Items
    primaryFixed = classicBlack70,
    onPrimaryFixed = darkRed,

    // Skeleton Colors
    surfaceContainer = skeletonLight

)

@Composable
fun AndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}
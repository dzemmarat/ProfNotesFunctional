package ru.mrz.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Suppress("PrivatePropertyName")
private val DarkColorScheme = darkColorScheme(
    primary = Yellow,
    secondary = Azur,
    error = AlizarinRed,
    surface = DarkGray,
    onSurface = PearlGray,
    tertiary = Springgreen,
    background = DarkWalnut
)

@Composable
fun ProfnotesTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isDynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val dynamicColor = isDynamicColor && isDynamicThemeAvailable()
    val colorScheme = when {
        dynamicColor && isDarkTheme -> {
            dynamicDarkColorScheme(LocalContext.current)
        }

        dynamicColor && !isDarkTheme -> {
            dynamicLightColorScheme(LocalContext.current)
        }

        else -> DarkColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isDarkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}


@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun isDynamicThemeAvailable() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

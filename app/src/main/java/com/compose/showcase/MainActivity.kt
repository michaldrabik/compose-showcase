package com.compose.showcase

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.compose.showcase.core.main.MainScreen
import com.compose.showcase.ui.theme.ShowcaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(navigationBarStyle = SystemBarStyle.light(TRANSPARENT, TRANSPARENT))
        enableImmersiveMode()
        setupOrientation()

        setContent {
            ShowcaseTheme {
                MainScreen()
            }
        }
    }

    private fun enableImmersiveMode() {
        with(WindowCompat.getInsetsController(window, window.decorView)) {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.statusBars())
        }
    }

    @SuppressLint("SourceLockedOrientationActivity")
    private fun setupOrientation() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}

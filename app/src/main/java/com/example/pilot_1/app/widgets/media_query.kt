package com.example.pilot_1.app.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


object MediaQuery {
    @Composable
    fun getWidth():Double{
        val context = LocalContext.current
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.widthPixels.toDouble()
    }

    @Composable
    fun getHeight():Double{
        val context = LocalContext.current
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.heightPixels.toDouble()
    }

    @Composable
    fun getDensity():Float{
        val context = LocalContext.current
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.density
    }
}
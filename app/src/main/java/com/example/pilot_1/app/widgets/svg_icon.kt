package com.example.pilot_1.app.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SvgIcon(iconName: Int,size: Double = 24.0,color: Color = Color.Black) {
    Image(
        painter = painterResource(id = iconName), // Replace with your SVG resource
        contentDescription = "SVG Icon",
        modifier = Modifier.size(size.dp),  // Set size as needed
        colorFilter = ColorFilter.tint(color) // Optional: tint color
    )
}
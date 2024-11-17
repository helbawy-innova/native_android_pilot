package com.example.pilot_1.app.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SizedBox(height:Double = 0.0,width:Double = 0.0,child: (@Composable ()->Unit)? = null){
    Box(modifier = Modifier.height(height.dp).width(width.dp)){
        child
    }
}
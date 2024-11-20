package com.example.pilot_1.features.splash.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pilot_1.R
import com.example.pilot_1.navigation.AppRoutes
import com.example.pilot_1.navigation.Navigator
import com.example.pilot_1.navigation.Route
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen() {

    LaunchedEffect(Unit){
        delay(5000)
        Navigator.push(Route(AppRoutes.login), replacement = true)
    }

    Scaffold(
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val infiniteTransition = rememberInfiniteTransition()
            val logoSize by infiniteTransition.animateFloat(
                initialValue = 200f,
                targetValue = 300f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2000, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Image(
                modifier = Modifier
                    .size(logoSize.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
            )
        }
    }
}
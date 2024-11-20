package com.example.pilot_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pilot_1.features.authentication.login.data.repos.AuthenticationRepoImp
import com.example.pilot_1.features.authentication.login.ui.screens.LoginScreen
import com.example.pilot_1.features.authentication.login.ui.viewmodels.LoginViewModel
import com.example.pilot_1.features.home.ui.screens.HomeScreen
import com.example.pilot_1.navigation.Navigator
import com.example.pilot_1.ui.theme.Pilot_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pilot_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Navigator.navigationComponent()

                }
            }
        }
    }
}
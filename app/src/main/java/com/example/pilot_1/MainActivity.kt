package com.example.pilot_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pilot_1.app.widgets.TextInputField
import com.example.pilot_1.features.authentication.login.data.repos.AuthenticationRepoImp
import com.example.pilot_1.features.authentication.login.ui.screens.LoginScreen
import com.example.pilot_1.features.authentication.login.ui.viewmodels.LoginViewModel
import com.example.pilot_1.features.splash.ui.screens.SplashScreenView
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
                    LoginScreen(LoginViewModel(authenticationRepo = AuthenticationRepoImp()))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var value by remember { mutableStateOf("default") }
    Column() {
        Text(
            text = "Hello $value!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pilot_1Theme {
        Greeting("Android")
    }
}
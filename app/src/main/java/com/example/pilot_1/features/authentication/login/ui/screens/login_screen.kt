package com.example.pilot_1.features.authentication.login.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pilot_1.app.widgets.SizedBox
import com.example.pilot_1.app.widgets.TextInputField
import com.example.pilot_1.configurations.LoadingState
import com.example.pilot_1.features.authentication.login.ui.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(viewModel : LoginViewModel) {
    val uiState by viewModel.observeStates()
    Scaffold(
        modifier = Modifier.padding(
            24.dp
        )
    ) {
        val screenFocus = LocalFocusManager.current
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState(), enabled = true)
                .clickable(
                    onClick = {
                        screenFocus.clearFocus()
                    }, // Clear focus to dismiss keyboard
                    indication = null, // No ripple effect
                    interactionSource = remember { MutableInteractionSource() }
                ),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Hello", fontSize = 48.sp, fontWeight = FontWeight.W700)
            Text(
                "Again!",
                fontSize = 48.sp,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colorScheme.primary
            )
            SizedBox(height = 4.0)
            Text(
                "Welcome back you’ve \n been missed!",
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                maxLines = 2
            )
            SizedBox(height = 48.0)
            TextInputField(
                label = "Username", hint = "Please enter username",
                onChange = { viewModel.username = it },
                errorMessage = viewModel.usernameErrorMessage,
            )
            SizedBox(height = 16.0)
            TextInputField(
                label = "Password",
                hint = "Please enter password",
                keyboardType = KeyboardType.Password,
                onChange = { viewModel.password = it },
                errorMessage = viewModel.passwordErrorMessage,
            )
            SizedBox(height = 16.0)
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Forgot the password ?",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable {
                            Log.d("Helbawy", "Clicked")
                        },
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W400,
                )
            }
            SizedBox(height = 16.0)
            if(uiState is LoadingState){
                Box(modifier = Modifier.fillMaxWidth()){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            else ElevatedButton(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(6.dp),
                elevation = null,
                onClick = {
                    viewModel.login()
                },
            ) {
                Text(
                    "Forgot the password ?",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                )
            }

            SizedBox(height = 16.0)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "don't have an account ?")
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                    },
                )
            }
        }
    }
}
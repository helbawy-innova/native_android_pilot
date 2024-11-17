package com.example.pilot_1.features.authentication.login.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pilot_1.configurations.AppState
import com.example.pilot_1.configurations.Cubit
import com.example.pilot_1.configurations.ErrorState
import com.example.pilot_1.configurations.InitState
import com.example.pilot_1.configurations.LoadingState
import com.example.pilot_1.configurations.SuccessState
import com.example.pilot_1.features.authentication.login.domain.repos.AuthenticationRepo
import com.example.pilot_1.features.authentication.login.ui.core.InputValidation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    authenticationRepo: AuthenticationRepo
) : Cubit<AppState>(InitState()) {
    //================================
    //================================ Variables
    //================================
    var username: String = ""
    var usernameErrorMessage: String = ""
    var password: String = ""
    var passwordErrorMessage: String = ""
    private val authenticationRepo: AuthenticationRepo
    init {
        this.authenticationRepo = authenticationRepo
    }
    //================================
    //================================ Functions
    //================================
    private fun validateInputs(): Boolean {
        usernameErrorMessage = InputValidation.validateUsername(username)
        passwordErrorMessage = InputValidation.validatePassword(password)
        return usernameErrorMessage.isEmpty() && passwordErrorMessage.isEmpty()
    }

    private suspend fun _loginRequest() : Boolean {
        return this.authenticationRepo.login(username, password)
    }
    //================================
    //================================ Functions
    //================================
    fun login() {
        viewModelScope.launch {
            emit(LoadingState())
            if (validateInputs()) {
                try{
                    if (_loginRequest()) {
                        emit(SuccessState())
                    } else {
                        emit(ErrorState())
                    }
                } catch (e: Exception) {
                    Log.d("Helbawy", e.toString())

                    emit(ErrorState())
                }
            } else {
                emit(ErrorState())
            }
        }
    }
}



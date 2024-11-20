package com.example.pilot_1.features.authentication.login.ui.viewmodels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.pilot_1.configurations.AppStates
import com.example.pilot_1.configurations.Cubit
import com.example.pilot_1.configurations.ErrorState
import com.example.pilot_1.configurations.InitState
import com.example.pilot_1.configurations.LoadingState
import com.example.pilot_1.configurations.SuccessState
import com.example.pilot_1.features.authentication.login.domain.repos.AuthenticationRepo
import com.example.pilot_1.features.authentication.login.ui.core.InputValidation
import com.example.pilot_1.navigation.AppRoutes
import com.example.pilot_1.navigation.Navigator
import com.example.pilot_1.navigation.Route
import kotlinx.coroutines.launch

class LoginViewModel(
    authenticationRepo: AuthenticationRepo
) : Cubit<AppStates>(InitState()) {
    //================================
    //================================ Variables
    //================================
    var email: String = ""
    var emailErrorMessage: String = ""
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
        emailErrorMessage = InputValidation.validateEmail(email)
        passwordErrorMessage = InputValidation.validatePassword(password)
        return emailErrorMessage.isEmpty() && passwordErrorMessage.isEmpty()
    }

    private suspend fun _loginRequest() : Boolean {
        return this.authenticationRepo.login(email, password)
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
                        Navigator.push(Route(routeName = AppRoutes.home), replacement = true)
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



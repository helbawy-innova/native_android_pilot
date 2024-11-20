package com.example.pilot_1.features.authentication.login.data.repos

import android.util.Log
import com.example.pilot_1.features.authentication.login.data.models.LoginRequestBody
import com.example.pilot_1.features.authentication.login.data.services.AuthenticationServices
import com.example.pilot_1.features.authentication.login.domain.repos.AuthenticationRepo
import com.example.pilot_1.network.NetworkHelper

class AuthenticationRepoImp : AuthenticationRepo {
    private val authenticationServices: AuthenticationServices = NetworkHelper.createService(AuthenticationServices::class.java)

    override suspend fun login(username: String, password: String): Boolean {
        val response = authenticationServices.login(LoginRequestBody(username, password))

        return response.isSuccessful
    }
}
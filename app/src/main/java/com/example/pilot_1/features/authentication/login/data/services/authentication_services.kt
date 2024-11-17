package com.example.pilot_1.features.authentication.login.data.services

import com.example.pilot_1.features.authentication.login.data.models.LoginRequestBody
import com.example.pilot_1.features.authentication.login.data.models.LoginRequestResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationServices {
    @Headers("Accept:application/json")
    @POST("auth/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody): Response<LoginRequestResponse>
}
package com.example.pilot_1.features.home.data.services

import com.example.pilot_1.features.authentication.login.data.models.LoginRequestBody
import com.example.pilot_1.features.authentication.login.data.models.LoginRequestResponse
import com.example.pilot_1.features.home.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NewsServices {
    @GET("everything?apiKey=2f4b89b9da7a48889d3615dde4f8bd6f&q=Tech")
    suspend fun getNewsData(): Response<NewsResponse>
}
package com.example.pilot_1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val _baseUrl:String = "https://coursafer.innoeg.com/api/"
object NetworkHelper {
    private val _retro = Retrofit.Builder()
        .baseUrl(_baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(service: Class<T>): T {
        return _retro.create(service)
    }
}
package com.example.pilot_1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val _baseUrl:String = "https://coursafer.innoeg.com/api/"
const val newsApiBaseUrl:String = "https://newsapi.org/v2/"
object NetworkHelper {
    private val _retro = Retrofit.Builder()
        .baseUrl(_baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(service: Class<T>): T {
        return _retro.create(service)
    }
    fun <T> createServiceWithNewBaseUrl(service: Class<T>,baseUrl: String = _baseUrl ) : T{
        val newRetro = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return newRetro.create(service)
    }
}

//2f4b89b9da7a48889d3615dde4f8bd6f
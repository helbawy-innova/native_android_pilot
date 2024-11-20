package com.example.pilot_1.features.home.data.repo

import android.util.Log
import com.example.pilot_1.features.authentication.login.data.services.AuthenticationServices
import com.example.pilot_1.features.home.data.services.NewsServices
import com.example.pilot_1.features.home.domain.models.NewsModel
import com.example.pilot_1.features.home.domain.repo.HomeRepoInterface
import com.example.pilot_1.network.NetworkHelper
import com.example.pilot_1.network.newsApiBaseUrl

class HomeRepoImp : HomeRepoInterface {
    private val newsServices: NewsServices = NetworkHelper.createServiceWithNewBaseUrl(
        NewsServices::class.java, baseUrl = newsApiBaseUrl
    )

    override suspend fun getNewsData(): List<NewsModel> {
        val response = newsServices.getNewsData()
        Log.d("Helbawy", response.toString());
        Log.d("Helbawy", response.isSuccessful.toString())
        val newsList: List<NewsModel> = response.body()?.articles?.map {
            NewsModel(it.title, it.description, it.urlToImage)
        } ?: emptyList()
        return newsList

    }
}
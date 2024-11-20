package com.example.pilot_1.features.home.domain.repo

import com.example.pilot_1.features.home.domain.models.NewsModel

interface HomeRepoInterface {
    suspend fun getNewsData(): List<NewsModel>
}
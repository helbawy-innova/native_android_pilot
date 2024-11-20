package com.example.pilot_1.features.home.data.models
data class NewsResponse(
    val status: String,
    val totalResults: Long,
    val articles: List<ArticleData>,
)

data class ArticleData(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String,
)

data class Source(
    val id: String?,
    val name: String,
)

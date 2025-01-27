package com.example.newsappproject.data.remote

import com.example.newsappproject.data.models.Article
import com.example.newsappproject.data.models.Source
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "27f47898-f45b-489d-b91a-708900199bdc"
    ): List<Article>

    @GET("sources")
    suspend fun getNewsSources(
        @Query("apiKey") apiKey: String = "27f47898-f45b-489d-b91a-708900199bdc"
    ): List<Source>
}

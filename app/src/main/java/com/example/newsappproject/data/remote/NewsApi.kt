package com.example.newsappproject.data.remote

import com.example.newsappproject.data.models.NewsResponse
import retrofit2.http.GET

interface NewsApi {
    @GET("search?api-key=27f47898-f45b-489d-b91a-708900199bdc")
    suspend fun getTopHeadlines(): NewsResponse

}
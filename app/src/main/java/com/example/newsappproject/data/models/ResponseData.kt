package com.example.newsappproject.data.models

data class ResponseData(
    val status: String,
    val total: Int,
    val results: List<Article>
)
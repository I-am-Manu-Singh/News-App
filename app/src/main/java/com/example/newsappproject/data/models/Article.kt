package com.example.newsappproject.data.models

data class Article(
    val id: String,
    val type: String,
    val sectionName: String,
    val webTitle: String,
    val webUrl: String,
    val webPublicationDate: String,
    val date: String,
    val time: String,
//    val fullContent: String // New property for full article text

)
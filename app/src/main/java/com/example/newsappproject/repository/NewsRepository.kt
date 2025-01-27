package com.example.newsappproject.repository

import com.example.newsappproject.data.local.ArticleDao
import com.example.newsappproject.data.models.Article
import com.example.newsappproject.data.remote.NewsApi
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
) {
    // Fetch top headlines from the API
    suspend fun getTopHeadlines(country: String): List<Article> {
        return newsApi.getTopHeadlines(country)
    }

    // Get all saved articles from the local database
    fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles() // Assuming `Flow` is used for observing changes
    }

    // Save an article to the local database
    suspend fun saveArticle(article: Article) {
        articleDao.upsert(article) // Use `upsert` to handle conflicts gracefully
    }

    // Delete an article by title
    suspend fun deleteArticle(article: String) {
        articleDao.deleteArticle(article)
    }
}
package com.example.newsappproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappproject.data.models.Article
import com.example.newsappproject.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> get() = _articles

    private val _savedArticles = MutableStateFlow<List<Article>>(emptyList())
    val savedArticles: StateFlow<List<Article>> get() = _savedArticles

    fun fetchTopHeadlines(country: String) {
        viewModelScope.launch {
            val fetchedArticles = repository.getTopHeadlines(country)
            _articles.value = fetchedArticles
        }
    }

    // Collecting the flow from the repository and updating the savedArticles state
    fun getSavedArticles() {
        viewModelScope.launch {
            repository.getSavedArticles().collect { savedArticles ->
                _savedArticles.value = savedArticles
            }
        }
    }

    fun saveArticle(article: Article) {
        viewModelScope.launch {
            repository.saveArticle(article)
            getSavedArticles()
        }
    }

    fun deleteArticle(title: String) {
        viewModelScope.launch {
            repository.deleteArticle(title)
            getSavedArticles()
        }
    }
}
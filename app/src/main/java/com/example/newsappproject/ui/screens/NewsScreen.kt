package com.example.newsappproject.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.newsappproject.data.models.Article
import com.example.newsappproject.ui.components.fetchArticles
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.newsappproject.ui.components.ArticleList

@Composable
fun NewsScreen() {
    var articles by remember { mutableStateOf<List<Article>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        isLoading = true
        error = null  // Reset the error message
        try {
            articles = fetchArticles()
        } catch (e: Exception) {
            error = "Failed to load articles"
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

    // Show loading indicator while data is being fetched
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (error != null) {
        // Display error message if the data fetch fails
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = error ?: "An unknown error occurred")
        }
    } else if (articles.isEmpty()) {
        // Show a message if no articles are available
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No articles available.")
        }
    } else {
        // Display articles once loaded
        ArticleList(articles)
    }
}

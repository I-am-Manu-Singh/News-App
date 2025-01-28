package com.example.newsappproject.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.newsappproject.data.models.Article
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable

fun ArticleList(articles: List<Article>) {
    var selectedArticle: Article? by remember { mutableStateOf(null) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // Ensure this is the correct `items` function from LazyListScope
        items(articles) { article ->
            ArticleCard(article = article) {
                selectedArticle = article
            }
        }
    }

    selectedArticle?.let { article ->
        ArticleDialog(article = article, onDismiss = { selectedArticle = null })
    }
}

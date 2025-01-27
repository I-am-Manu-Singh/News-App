package com.example.newsappproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsappproject.data.models.Article
import com.example.newsappproject.ui.components.ArticleCard
import com.example.newsappproject.viewmodel.NewsViewModel

@Composable
fun SavedNewsScreen(
    savedArticles: List<Article>,
    onArticleClick: (Article) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//        items(savedArticles) { article ->
//            ArticleCard(article = article, onClick = { onArticleClick(article) })
//        }
    }
}
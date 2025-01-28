package com.example.newsappproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsappproject.data.models.Article

@Composable
fun ArticleDetailScreen(article: Article) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = article.webTitle ?: "No Title", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = article.sectionName ?: "No Description", style = MaterialTheme.typography.bodyMedium)
    }
}
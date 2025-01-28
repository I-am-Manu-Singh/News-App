package com.example.newsappproject.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsappproject.data.models.Article
import com.example.newsappproject.data.remote.RetrofitInstance

@Composable

fun ArticleCard(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Trigger the click event
        shape = RoundedCornerShape(12.dp), // Rounded corners for modern look
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            // Article Title
            Text(
                text = article.webTitle,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold, // Bold for prominence
                ),
                maxLines = 3, // Limit the title to 3 lines
                overflow = TextOverflow.Ellipsis, // Add ellipsis for overflow text
            )
            Spacer(modifier = Modifier.height(4.dp)) // Add space between title and section name

            Text(
                text = article.sectionName,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
        }
    }
}


suspend fun fetchArticles(): List<Article> {
    return try {
        val response = RetrofitInstance.newsApi.getTopHeadlines()
        response.response.results  // Extract articles from "response.results"
    } catch (e: Exception) {
        emptyList()  // Return an empty list in case of an error
    }
}
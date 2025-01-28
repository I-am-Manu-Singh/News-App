package com.example.newsappproject.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsappproject.data.models.Article

@Composable
fun ArticleDialog(article: Article, onDismiss: () -> Unit) {
    val context = LocalContext.current  // Get context inside Composable

    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Card(
                modifier = Modifier
//                    .fillMaxSize() // Full-screen card
                    .padding(26.dp), // Padding to avoid touching the edges
                shape = RoundedCornerShape(12.dp), // Rounded corners
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
//                        .fillMaxSize()
                        .padding(8.dp) // Inner padding for clean layout
                ) {
                    // Header Section
                    Text(
                        text = article.webTitle,
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onSurface
                        ),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Section: ${article.sectionName}",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // LazyColumn for Full Article Content
//                    LazyColumn(
//                        modifier = Modifier.weight(1f) // Take remaining space
//                    ) {
//                        item {
//                            Text(
//                                text = article.fullContent, // Assuming `fullContent` is the full article text
//                                style = MaterialTheme.typography.body1.copy(
//                                    lineHeight = 20.sp // Better readability
//                                )
//                            )
//                        }
//                    }

//                    Spacer(modifier = Modifier.height(16.dp)) // Space before buttons

                    // Buttons Section
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp), // Space between buttons
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = {
                                openWebUrl(context, article.webUrl)
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                        ) {
                            Text(
                                text = "Read Full Article in Browser",
                                style = MaterialTheme.typography.button.copy(
                                    color = MaterialTheme.colors.onPrimary
                                )
                            )
                        }

                        Button(
                            onClick = onDismiss,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                        ) {
                            Text(
                                text = "Close",
                                style = MaterialTheme.typography.button.copy(
                                    color = MaterialTheme.colors.onSecondary
                                )
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {} // Empty to avoid duplication
    )
}

/**
 * Helper function to open a web URL.
 */
fun openWebUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
package com.example.newsappproject.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsappproject.data.models.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    // Insert an article into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    // Delete an article from the database
    @Delete
    suspend fun deleteArticle(article: String)

    // Get all saved articles
    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<Article>>
}
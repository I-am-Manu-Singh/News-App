package com.example.newsappproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsappproject.data.models.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}
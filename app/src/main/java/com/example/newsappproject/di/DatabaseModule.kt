package com.example.newsappproject.di

import android.content.Context
import androidx.room.Room
import com.example.newsappproject.data.local.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NewsDatabase::class.java,
            "news_database"
        ).fallbackToDestructiveMigration() // Automatically migrate if schema changes
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(database: NewsDatabase) = database.articleDao()
}
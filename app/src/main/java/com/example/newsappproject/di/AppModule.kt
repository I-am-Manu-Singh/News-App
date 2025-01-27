package com.example.newsappproject.di

import android.content.Context
import androidx.room.Room
import com.example.newsappproject.data.local.NewsDatabase
import com.example.newsappproject.data.remote.NewsApi
import com.example.newsappproject.repository.NewsRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // Retrofit instance for making network requests
    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    // Room database instance for storing articles locally
    single {
        Room.databaseBuilder(get<Context>(), NewsDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration() // Handle schema changes
            .build()
    }

    // DAO instance for accessing articles
    single {
        get<NewsDatabase>().articleDao()  // Getting the ArticleDao from the database
    }

    // News repository for managing data flow (remote/local)
    single {
        NewsRepository(get(), get())  // Injecting Retrofit API and ArticleDao
    }
}
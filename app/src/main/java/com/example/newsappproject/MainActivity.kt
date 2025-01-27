package com.example.newsappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappproject.ui.screens.NewsScreen
import com.example.newsappproject.ui.screens.SavedNewsScreen
import com.example.newsappproject.ui.theme.NewsAppProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppProjectTheme {
                // Remembering NavController
                val navController = rememberNavController()

                // Define Navigation Graph
                NavHost(navController = navController, startDestination = "newsScreen") {
                    composable("newsScreen") {
                        NewsScreen(
                            viewModel = hiltViewModel(),
                        )
                    }
                    composable("savedNewsScreen") {
                        SavedNewsScreen(viewModel = hiltViewModel())
                    }
                }
            }
        }
    }
}
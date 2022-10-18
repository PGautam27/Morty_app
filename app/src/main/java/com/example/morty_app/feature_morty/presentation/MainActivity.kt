package com.example.morty_app.feature_morty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.morty_app.feature_morty.presentation.morty_details.MortyDetailScreen
import com.example.morty_app.feature_morty.presentation.morty_list.MortyListScreen
import com.example.morty_app.feature_morty.presentation.splash.MortySplashScreen
import com.example.morty_app.ui.theme.Morty_appTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Morty_appTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.MortySplashScreen.route
                ) {
                    composable(
                        route = Screen.MortyScreen.route
                    ) {
                        MortyListScreen(navController = navController)
                    }
                    composable(
                        route = Screen.MortyDetailScreen.route + "/{characterId}"
                    ) {
                        MortyDetailScreen(navController = navController)
                    }
                    composable(
                        route = Screen.MortySplashScreen.route
                    ) {
                        MortySplashScreen(navController=navController)
                    }
                }
            }
        }
    }
}

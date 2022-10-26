package com.example.morty_app.feature_morty.presentation

sealed class Screen(val route: String){
    object MortyScreen : Screen("morty_screen")
    object MortyDetailScreen : Screen("morty_detail_screen")
    object  MortySplashScreen:Screen("morty_splash_screen")
}

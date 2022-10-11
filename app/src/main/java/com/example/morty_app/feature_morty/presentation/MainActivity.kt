package com.example.morty_app.feature_morty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.example.morty_app.feature_morty.presentation.morty_details.MortyDetailScreen
import com.example.morty_app.feature_morty.presentation.morty_list.MortyListScreen
import com.example.morty_app.ui.theme.Morty_appTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import androidx.navigation.NavBackStackEntry
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Morty_appTheme {
                val navController = rememberAnimatedNavController()
                AnimatedNavHost(
                    navController = navController,
                    startDestination = Screen.MortyScreen.route
                ) {
                    composable(
                        route = Screen.MortyScreen.route,
                        exitTransition = {
                            slideOutHorizontally(
                                targetOffsetX = { -1200 },
                                animationSpec = tween(
                                    durationMillis = 500,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeOut(animationSpec = tween(800))
                        },
                        popEnterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { -1200 },
                                animationSpec = tween(
                                    durationMillis = 500
                                )
                            ) + fadeIn(animationSpec = tween(800))
                        }
                    ) {
                        MortyListScreen(navController = navController)
                    }
                    composable(
                        route = Screen.MortyDetailScreen.route + "/{characterId}",
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { 1200 },
                                animationSpec = tween(
                                    durationMillis = 500
                                )
                            ) + fadeIn(animationSpec = tween(800))
                        },
                        popExitTransition = {
                            slideOutHorizontally(
                                targetOffsetX = { 1200 },
                                animationSpec = tween(
                                    durationMillis = 500,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeOut(animationSpec = tween(800))
                        }
                    ) {
                        MortyDetailScreen(navController = navController)
                    }
                }
            }
        }
    }
}

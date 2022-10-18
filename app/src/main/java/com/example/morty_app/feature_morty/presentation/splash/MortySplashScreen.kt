package com.example.morty_app.feature_morty.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.morty_app.R
import com.example.morty_app.feature_morty.presentation.Screen
import kotlinx.coroutines.delay


@Composable
fun MortySplashScreen(navController: NavController)
{
    val scale=remember{
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true ){
        //delay(2500)
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing={
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2500)
        navController.navigate("morty_screen")
        navController.navigate(Screen.MortyScreen.route){
            popUpTo(0)
        }
    }


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(id = R.drawable.mortyapp2),
                    contentDescription ="splash",
                    modifier=Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }

}
@Composable
@Preview
fun MortySplashScreenPreview()
{

}
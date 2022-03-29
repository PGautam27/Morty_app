package com.example.morty_app.feature_morty.presentation.morty_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun MortyDetailScreen(
    navController: NavController,
    viewModel: MortyDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        TopAppBar(
            title = {
                Text(text = "Morty Characters")
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            )
        state.character?.let { character ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = rememberImagePainter(data = character.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "${character.name}", fontSize = 30.sp)
                Spacer(modifier = Modifier.padding(10.dp))
                Divider(
                    modifier = Modifier
                        .width(200.dp)
                        .height(5.dp), color = Color.Gray
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(text = "${character.species} - ${character.status}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Gender - ${character.gender}", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Type - ${character.type}", fontSize = 20.sp)
            }
        }
    }
}
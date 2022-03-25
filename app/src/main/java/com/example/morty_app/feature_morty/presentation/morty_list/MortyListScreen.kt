package com.example.morty_app.feature_morty.presentation.morty_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.morty_app.feature_morty.domain.use_cases.get_characters.page
import com.example.morty_app.feature_morty.presentation.Screen
import com.example.morty_app.feature_morty.presentation.morty_list.component.CharacterListItem

@Composable
fun MortyListScreen(
    navController: NavController,
    viewModel: MortyListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Morty Characters Page ${page.value}", textAlign = TextAlign.Center)
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        }, modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)){
            items(state.characters) {character ->
                CharacterListItem(
                    character = character,
                    onItemClick = {
                        navController.navigate(Screen.MortyDetailScreen.route +"/${character.id}")
                    }
                )
            }
        }
    }
    if (state.error.isNotBlank()){
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        )
    }
    if (state.isLoading){
        CircularProgressIndicator(modifier = Modifier)
    }
}
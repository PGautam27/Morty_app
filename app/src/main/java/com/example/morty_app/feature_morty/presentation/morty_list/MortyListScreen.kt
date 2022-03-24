package com.example.morty_app.feature_morty.presentation.morty_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.morty_app.feature_morty.presentation.morty_list.component.CharacterListItem

@Composable
fun MortyListScreen(
    viewModel: MortyListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.characters) {character ->
                CharacterListItem(
                    character = character
                )
            }
        }
    }
}
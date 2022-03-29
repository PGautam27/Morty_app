package com.example.morty_app.feature_morty.presentation.morty_list

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.presentation.Screen
import com.example.morty_app.feature_morty.presentation.morty_list.component.CharacterListItem

@Composable
fun MortyListScreen(
    navController: NavController,
    viewModel: MortyListViewModel = hiltViewModel(),
    context: Context
) {
    val characterListItems: LazyPagingItems<Character> = viewModel.character.collectAsLazyPagingItems()

    val state = viewModel.state.value
    Scaffold(
        topBar = {if (!state.isLoading){
            TopAppBar(
                title = {
                    Text(text = "Morty Characters", textAlign = TextAlign.Center)
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,

            )
        }
        }, modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)){
            items(characterListItems){ character ->
                character?.let {
                    CharacterListItem(
                        character = it,
                        onItemClick = {
                            navController.navigate(Screen.MortyDetailScreen.route +"/${character.id}")
                        }
                    )
                }
            }
        }
        if (state.error.isNotBlank()){
            Box(modifier = Modifier.fillMaxSize()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }
        if (state.isLoading){
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
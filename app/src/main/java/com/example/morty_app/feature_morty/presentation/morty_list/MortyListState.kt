package com.example.morty_app.feature_morty.presentation.morty_list

import com.example.morty_app.feature_morty.domain.model.Character

data class MortyListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
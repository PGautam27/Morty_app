package com.example.morty_app.feature_morty.presentation.morty_details

import com.example.morty_app.feature_morty.domain.model.Character

data class MortyDetailState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String = ""
)
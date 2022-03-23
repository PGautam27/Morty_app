package com.example.morty_app.feature_morty.data.repository

import com.example.morty_app.feature_morty.data.remote.MortyApi
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: MortyApi
) {
}
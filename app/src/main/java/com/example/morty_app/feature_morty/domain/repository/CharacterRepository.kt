package com.example.morty_app.feature_morty.domain.repository

import com.example.morty_app.feature_morty.data.remote.dto.CharacterDto

interface CharacterRepository {

    suspend fun getCharacters(page: Int): List<CharacterDto>

    suspend fun getCharacterById(characterId: String): CharacterDto

}
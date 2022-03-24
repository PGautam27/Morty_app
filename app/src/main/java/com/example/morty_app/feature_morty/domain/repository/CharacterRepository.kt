package com.example.morty_app.feature_morty.domain.repository

import com.example.morty_app.feature_morty.data.remote.dto.CharacterDto
import com.example.morty_app.feature_morty.data.remote.dto.CharacterListDto

interface CharacterRepository {

    suspend fun getCharacters(): List<CharacterDto>

    suspend fun getCharacterById(characterId: String): CharacterDto

}
package com.example.morty_app.feature_morty.data.repository

import com.example.morty_app.feature_morty.data.remote.MortyApi
import com.example.morty_app.feature_morty.data.remote.dto.CharacterDto
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: MortyApi
) : CharacterRepository {
    override suspend fun getCharacters(page: Int): List<CharacterDto> {
        return api.getAllCharacters(page).results
    }

    override suspend fun getCharacterById(characterId: String): CharacterDto {
        return api.getCharacter(characterId)
    }

}
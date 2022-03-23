package com.example.morty_app.feature_morty.data.remote.dto

import com.example.morty_app.feature_morty.domain.model.Character

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
){
    fun CharacterDto.toResult(): Character {
        return Character(
            id = id,
            image = image,
            name = name,
            species = species,
            status = status,
            type = type,
            gender = gender
        )
    }
}
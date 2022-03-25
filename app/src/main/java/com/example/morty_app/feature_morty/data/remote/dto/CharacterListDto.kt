package com.example.morty_app.feature_morty.data.remote.dto

data class CharacterListDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)

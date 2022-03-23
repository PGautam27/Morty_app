package com.example.morty_app.feature_morty.data.remote.dto

import com.example.morty_app.feature_morty.domain.model.CharacterList

data class CharacterListDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)

fun CharacterListDto.toCharacterList(): CharacterList{
    return CharacterList(
        info = info,
        results = results
    )
}
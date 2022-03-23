package com.example.morty_app.feature_morty.data.remote.dto

data class MortyDto(
    val info: InfoDto,
    val results: List<ResultDto>
)
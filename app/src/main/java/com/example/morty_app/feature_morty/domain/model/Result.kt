package com.example.morty_app.feature_morty.domain.model

import com.example.morty_app.feature_morty.data.remote.dto.LocationDto
import com.example.morty_app.feature_morty.data.remote.dto.OriginDto

data class Result(
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
)

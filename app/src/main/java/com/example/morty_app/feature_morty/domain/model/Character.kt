package com.example.morty_app.feature_morty.domain.model

data class Character(
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
)

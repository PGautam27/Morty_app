package com.example.morty_app.feature_morty.data.remote.dto

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)
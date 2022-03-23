package com.example.morty_app.feature_morty.data.remote

import com.example.morty_app.feature_morty.data.remote.dto.MortyDto
import com.example.morty_app.feature_morty.data.remote.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MortyApi {

    @GET("character")
    suspend fun getAllCharacters() : List<MortyDto>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): ResultDto

}
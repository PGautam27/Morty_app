package com.example.morty_app.feature_morty.data.remote

import com.example.morty_app.feature_morty.data.remote.dto.CharacterListDto
import com.example.morty_app.feature_morty.data.remote.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MortyApi {

    @GET("character")
    suspend fun getAllCharacters() : CharacterListDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): CharacterDto

}
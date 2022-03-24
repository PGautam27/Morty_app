package com.example.morty_app.core

import com.example.morty_app.feature_morty.data.remote.dto.CharacterDto
import com.example.morty_app.feature_morty.domain.model.Character

sealed class Resource<T>(val data: Any? = null, val message: String? = null){
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}


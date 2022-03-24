package com.example.morty_app.feature_morty.domain.use_cases.get_characters

import com.example.morty_app.core.Resource
import com.example.morty_app.core.Resources
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resources.Loading<List<Character>>())
            val character = repository.getCharacters()
            emit(Resources.Success<List<Character>>(character))
        }catch (e: HttpException){
            emit(Resources.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resources.Error<List<Character>>("Couldn't reach the server."))
        }
    }
}
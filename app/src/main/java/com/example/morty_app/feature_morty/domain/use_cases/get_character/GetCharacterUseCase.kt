package com.example.morty_app.feature_morty.domain.use_cases.get_character

import com.example.morty_app.core.Resource
import com.example.morty_app.feature_morty.data.remote.dto.toCharacter
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(characterId:String): Flow<Resource<Character>> = flow {
        try {
            emit(Resource.Loading<Character>())
            val character = repository.getCharacterById(characterId).toCharacter()
            emit(Resource.Success<Character>(character))
        }catch (e: HttpException){
            emit(Resource.Error<Character>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<Character>("Couldn't reach the server."))
        }
    }
}
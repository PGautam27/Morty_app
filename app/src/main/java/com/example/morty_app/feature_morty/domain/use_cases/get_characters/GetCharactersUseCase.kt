package com.example.morty_app.feature_morty.domain.use_cases.get_characters

import com.example.morty_app.core.Resource
import com.example.morty_app.feature_morty.data.remote.dto.toCharacter
import com.example.morty_app.feature_morty.data.remote.dto.toCharacterList
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.model.CharacterList
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<CharacterList>>> = flow {
        try {
            emit(Resource.Loading<List<CharacterList>>())
            val character = repository.getCharacters().map { it.toCharacterList()}
            emit(Resource.Success<List<CharacterList>>(character))
        }catch (e: HttpException){
            emit(Resource.Error<List<CharacterList>>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<CharacterList>>("Couldn't reach the server."))
        }
    }
}
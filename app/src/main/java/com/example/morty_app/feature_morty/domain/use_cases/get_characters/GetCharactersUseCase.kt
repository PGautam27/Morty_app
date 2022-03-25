package com.example.morty_app.feature_morty.domain.use_cases.get_characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.morty_app.core.Resource
import com.example.morty_app.feature_morty.data.remote.dto.toCharacter
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

object hi {val page = MutableLiveData<Int>(1)}

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            kotlinx.coroutines.delay(1000)
            val pageNo: LiveData<Int> = hi.page
            val characterDTOs = hi.page.value?.let { repository.getCharacters(it) }
            val characters = characterDTOs?.map { it.toCharacter() }
            Log.i("GetCharacterUse Case", "invoke: ${characters.toString()}")
            emit(Resource.Success<List<Character>>(characters!!))
        }catch (e: HttpException){
            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Character>>("Couldn't reach the server."))
        }
    }
}
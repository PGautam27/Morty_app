package com.example.morty_app.feature_morty.domain.use_cases.get_characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.morty_app.core.Resource
import com.example.morty_app.feature_morty.data.remote.MortyApi
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
    private val repository: CharacterRepository,
) : PagingSource<Int, Character>(){
//    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
//        try {
//            emit(Resource.Loading<List<Character>>())
//            kotlinx.coroutines.delay(1000)
//            val pageNo: LiveData<Int> = hi.page
//            val characterDTOs = hi.page.value?.let { repository.getCharacters(it) }
//            val characters = characterDTOs?.map { it.toCharacter() }
//            Log.i("GetCharacterUse Case", "invoke: ${characters.toString()}")
//            emit(Resource.Success<List<Character>>(characters!!))
//        }catch (e: HttpException){
//            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occurred"))
//        }catch (e: IOException){
//            emit(Resource.Error<List<Character>>("Couldn't reach the server."))
//        }
//    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state?.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key?:1
        return try {
            val characters = repository.getCharacters(page)
            LoadResult.Page(
                data = characters?.map { it.toCharacter() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (characters.isEmpty()!!) null else page + 1
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}
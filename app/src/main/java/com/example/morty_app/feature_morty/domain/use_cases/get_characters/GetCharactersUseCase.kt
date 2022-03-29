package com.example.morty_app.feature_morty.domain.use_cases.get_characters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.example.morty_app.feature_morty.data.remote.dto.toCharacter
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.repository.CharacterRepository
import okio.IOException
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository,
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state?.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: 1
        return try {
            val characters = repository.getCharacters(page)
            LoadResult.Page(
                data = characters?.map { it.toCharacter() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (characters.isEmpty()!!) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
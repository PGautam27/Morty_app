package com.example.morty_app.feature_morty.presentation.morty_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.use_cases.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MortyListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val character: Flow<PagingData<Character>> = Pager(PagingConfig(pageSize = 42)) {
        getCharactersUseCase
    }.flow.cachedIn(viewModelScope)

}
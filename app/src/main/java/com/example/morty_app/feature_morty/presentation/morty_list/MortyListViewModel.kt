package com.example.morty_app.feature_morty.presentation.morty_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.use_cases.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MortyListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val _state = mutableStateOf(MortyListState())
    val state: State<MortyListState> = _state

    val character: Flow<PagingData<Character>> = Pager(PagingConfig(pageSize = 42)) {
        getCharactersUseCase
    }.flow.cachedIn(viewModelScope)


    init {
        character
    }
}
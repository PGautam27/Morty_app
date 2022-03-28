package com.example.morty_app.feature_morty.presentation.morty_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.morty_app.core.Resource
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.use_cases.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MortyListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _state = mutableStateOf(MortyListState())
    val state: State<MortyListState> = _state

    val character: Flow<PagingData<Character>> = Pager(PagingConfig(pageSize = 42)) {
        getCharactersUseCase
    }.flow.cachedIn(viewModelScope)

    init {
        getCharacters()
    }

    private fun getCharacters(){
//        getCharactersUseCase().onEach { result ->
//
//            when(result){
//                is Resource.Success ->{
//                    _state.value = MortyListState(characters = result.data as List<Character>)
//                }
//                is Resource.Error ->{
//                    _state.value = MortyListState(
//                        error = result.message?: "An unexpected error occurred"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = MortyListState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
        character


    }
}
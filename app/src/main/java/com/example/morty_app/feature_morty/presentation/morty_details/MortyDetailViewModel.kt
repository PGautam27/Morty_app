package com.example.morty_app.feature_morty.presentation.morty_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.morty_app.core.Constants
import com.example.morty_app.core.Resource
import com.example.morty_app.feature_morty.domain.model.Character
import com.example.morty_app.feature_morty.domain.use_cases.get_character.GetCharacterUseCase
import com.example.morty_app.feature_morty.domain.use_cases.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MortyDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(MortyDetailState())
    val state: State<MortyDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MORTY_ID)?.let { characterId ->
            getCharacter(characterId)
        }
    }

    private fun getCharacter(characterId: String){
        getCharacterUseCase(characterId = characterId).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value = MortyDetailState(character = result.data)
                }
                is Resource.Error ->{
                    _state.value = MortyDetailState(
                        error = result.message?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MortyDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
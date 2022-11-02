package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktn.pokemonpay.feature_pokemon.common.Constants.PARAM_POKEMON_NAME
import com.ktn.pokemonpay.feature_pokemon.common.Resource
import com.ktn.pokemonpay.feature_pokemon.domain.usecase.get_pokemon.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(PokemonState())
    val state: State<PokemonState> = _state

    init {
        savedStateHandle.get<String>(PARAM_POKEMON_NAME)?.let {
            searchPokemon(it)
        }
    }

    fun searchPokemon(name:String){
        getPokemonUseCase(name).onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = PokemonState(false,it.data)
                }
                is Resource.Error ->{
                    _state.value = PokemonState(error = it.message?:"An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value = PokemonState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
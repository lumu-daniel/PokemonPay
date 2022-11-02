package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ktn.pokemonpay.feature_pokemon.common.Utils
import com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(
    viewModel: PokemonDetailsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(

    ){
        Utils.LoaderAndError(state, Modifier.align(Alignment.Center))
    }
}
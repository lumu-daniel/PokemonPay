package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details

import com.ktn.pokemonpay.feature_pokemon.domain.model.Pokemon

data class PokemonState (
    val isLoading: Boolean = false,
    val pokemon: Pokemon? = null,
    val error: String = ""
)
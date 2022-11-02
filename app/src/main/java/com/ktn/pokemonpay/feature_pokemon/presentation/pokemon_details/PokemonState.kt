package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details

import com.ktn.pokemonpay.feature_pokemon.data.data_source.local.LocalDataSource
import com.ktn.pokemonpay.feature_pokemon.data.data_source.local.User
import com.ktn.pokemonpay.feature_pokemon.domain.model.Pokemon

data class PokemonState (
    val isLoading: Boolean = false,
    val pokemon: Pokemon? = null,
    val user: User? = LocalDataSource.users.get(1),
    val error: String = ""
)
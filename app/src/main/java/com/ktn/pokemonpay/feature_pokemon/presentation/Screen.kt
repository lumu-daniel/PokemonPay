package com.ktn.pokemonpay.feature_pokemon.presentation

sealed class Screen(val route:String) {
    object SearchPokemonScreen:Screen("search_pokemon")
    object PokemonDetailsScreen:Screen("pokemon_Details")
}
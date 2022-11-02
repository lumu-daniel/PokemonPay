package com.ktn.pokemonpay.feature_pokemon.domain.repository

import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.PokemonDto

interface PokemonRepository {

    suspend fun getPokemonByName(name: String):PokemonDto

}
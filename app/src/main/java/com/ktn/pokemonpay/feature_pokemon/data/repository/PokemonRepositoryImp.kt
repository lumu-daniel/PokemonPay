package com.ktn.pokemonpay.feature_pokemon.data.repository

import com.ktn.pokemonpay.feature_pokemon.data.remote.PokemonApi
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.PokemonDto
import com.ktn.pokemonpay.feature_pokemon.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImp @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonRepository{
    override suspend fun getPokemonByName(name: String): PokemonDto {
       return pokemonApi.getPokemonByName(name)
    }

}
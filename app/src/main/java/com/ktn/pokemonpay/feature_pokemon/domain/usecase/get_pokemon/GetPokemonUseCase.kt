package com.ktn.pokemonpay.feature_pokemon.domain.usecase.get_pokemon

import com.ktn.pokemonpay.feature_pokemon.common.Resource
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.toPokemon
import com.ktn.pokemonpay.feature_pokemon.domain.model.Pokemon
import com.ktn.pokemonpay.feature_pokemon.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    operator fun invoke(name: String): Flow<Resource<Pokemon>> = flow{
        try {
            emit(Resource.Loading())
            val pokemons = repository.getPokemonByName(name).toPokemon()
            emit(Resource.Success(pokemons))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error ocurred"))
        }
    }
}
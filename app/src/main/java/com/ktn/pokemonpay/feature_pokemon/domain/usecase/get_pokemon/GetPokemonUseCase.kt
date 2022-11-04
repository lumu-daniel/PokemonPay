package com.ktn.pokemonpay.feature_pokemon.domain.usecase.get_pokemon

import android.content.res.Resources.NotFoundException
import com.ktn.pokemonpay.feature_pokemon.common.Resource
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.toPokemon
import com.ktn.pokemonpay.feature_pokemon.domain.model.Pokemon
import com.ktn.pokemonpay.feature_pokemon.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    operator fun invoke(name: String): Flow<Resource<Pokemon>> = flow{
        try {
            emit(Resource.Loading())
            val pokemons = repository.getPokemonByName(name).toPokemon()
            emit(Resource.Success(pokemons))
        }catch (e: HttpException){
            emit(Resource.Error("Pokemon Not Found"))
        }catch (e: Exception){
            emit(Resource.Error("An unexpected error ocurred. Please try again later"))
        }
    }
}
package com.ktn.pokemonpay.feature_pokemon.data.remote

import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.PokemonDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name:String): PokemonDto

}
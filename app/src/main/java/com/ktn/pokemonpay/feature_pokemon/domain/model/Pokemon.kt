package com.ktn.pokemonpay.feature_pokemon.domain.model

import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.Ability
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.Move

data class Pokemon(
    val id: Int,
    val abilities: List<Ability>,
    val name: String,
    val moves: List<Move>,
    )

package com.ktn.pokemonpay.feature_pokemon.domain.model

import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.Ability
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.GameIndice
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.Move

data class Pokemon(
    val id: Int,
    val abilities: List<Ability>,
    val gameIndices: List<GameIndice>,
    val name: String,
    val price: Double,
    val moves: List<Move>,
    )

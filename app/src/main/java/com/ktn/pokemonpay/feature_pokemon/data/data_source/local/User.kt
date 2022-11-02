package com.ktn.pokemonpay.feature_pokemon.data.data_source.local

data class User(
    val name:String = "",
    val last: String = "",
    val accountNumber:String = "",
    val balance: Double = 0.0,
    val email:String = "",
    val isBlcSufficient:Boolean
)
package com.ktn.pokemonpay.feature_pokemon.data.remote.dto

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)
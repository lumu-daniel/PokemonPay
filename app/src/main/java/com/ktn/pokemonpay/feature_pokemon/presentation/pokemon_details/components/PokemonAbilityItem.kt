package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ktn.pokemonpay.feature_pokemon.data.remote.dto.Ability

@Composable
fun PokemonAbilityItem(
    itemName: String,
    itemValue: String,
    modifier: Modifier=Modifier
){
    Column (
        Modifier.fillMaxWidth().padding(vertical = 20.dp),
        horizontalAlignment = Alignment.Start
        ) {
        Text(
            text = itemName,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 20.dp),
            fontWeight = FontWeight.Bold,
            maxLines = 1

        )
        Text(
            text = itemValue.toString(),
            modifier = Modifier.padding(horizontal = 20.dp),
            style = MaterialTheme.typography.body1,
            maxLines = 1
        )
    }
}
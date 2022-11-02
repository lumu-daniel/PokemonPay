package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ResultSnackBar(
    message: String,
    modifier: Modifier = Modifier
){
    Snackbar(
        modifier = modifier.fillMaxWidth(),
    ){
        Text(
            text = message,
        )
    }
}
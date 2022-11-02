package com.ktn.pokemonpay.feature_pokemon.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.PokemonState

object Utils {

    @Composable
    fun <T>LoaderAndError( state: T, modifier: Modifier){
        when(state){
            is PokemonState->{
                if(state.error.isNotBlank()){
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                }
                if(state.isLoading){
                    CircularProgressIndicator(modifier = modifier)
                }
            }

        }
    }
}
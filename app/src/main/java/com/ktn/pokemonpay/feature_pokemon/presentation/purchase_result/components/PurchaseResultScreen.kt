package com.ktn.pokemonpay.feature_pokemon.presentation.purchase_result.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ktn.pokemonpay.feature_pokemon.presentation.purchase_result.PurchaseResultViewModel

@Composable
fun PurchaseResultScreen(
    modifier: Modifier=Modifier,
    viewModel: PurchaseResultViewModel= hiltViewModel()
){
    val state = viewModel.state
    Box(
        modifier = modifier.fillMaxSize(),
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = state.value,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h5
        )
        }
    }
}
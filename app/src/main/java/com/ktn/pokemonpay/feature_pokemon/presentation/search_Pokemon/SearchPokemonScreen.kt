package com.ktn.pokemonpay.feature_pokemon.presentation.search_Pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ktn.pokemonpay.R
import com.ktn.pokemonpay.feature_pokemon.presentation.Screen

@Composable
fun SearchPokemonScreen(
    navController: NavController,
    modifier: Modifier=Modifier
){
    val pokemonName = remember {
        mutableStateOf("")
    }

    Box(){
        Column (
            modifier = modifier.align(Alignment.Center)
        ){
            Image(
                painter = painterResource(R.drawable.pokemon_logo),
                modifier = Modifier.height(100.dp).width(300.dp).align(Alignment.CenterHorizontally),
                contentDescription = null
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Enter Pokemon name",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            Spacer(Modifier.height(20.dp))
            TextField(
                value = pokemonName.value,
                onValueChange = {pokemonName.value = it},
                modifier = Modifier.fillMaxWidth().padding(all = 16.dp),
                trailingIcon = {
                   IconButton(
                     onClick =   {
                         navController.navigate(Screen.PokemonDetailsScreen.route + "/${pokemonName}")
                     }
                   ){
                       Icon(
                           painter = painterResource(R.drawable.ic_baseline_search) ,
                           contentDescription = null
                       )
                   }
                },
                placeholder = {
                    Text(
                        text = "Like... Ditto",
                    )
                }

            )
        }
    }
}
package com.ktn.pokemonpay.feature_pokemon.presentation.search_Pokemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                text = stringResource(R.string.enter_name),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
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
                         if(!pokemonName.value.equals("")){
                             navController.navigate(Screen.PokemonDetailsScreen.route + "/${pokemonName.value}")
                         }
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
                        text = stringResource(R.string.like_ditto),
                    )
                }

            )
        }
    }
}

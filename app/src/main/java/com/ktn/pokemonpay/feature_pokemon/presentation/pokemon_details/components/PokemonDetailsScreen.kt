package com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ktn.pokemonpay.feature_pokemon.common.Utils
import com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.PokemonDetailsViewModel
import kotlinx.coroutines.launch

@Composable
fun PokemonDetailsScreen(
    viewModel: PokemonDetailsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            state.pokemon?.let {pokemon ->  run{
                Box(Modifier.weight(4f)) {
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        item{
                            Text(
                                text = pokemon.name,
                                style = MaterialTheme.typography.h3,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.primary,
                                modifier = Modifier.height(70.dp).fillMaxWidth(),
                            )
                            Spacer(Modifier.height(16.dp))
                        }
                        item {
                            Row (
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Text(
                                    text = "Price",
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic
                                )
                                Text(
                                    text = pokemon.price.toString(),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.h6,
                                    color = MaterialTheme.colors.secondary
                                )
                                Spacer(Modifier.height(50.dp))
                            }
                        }
                        item {
                            Spacer(Modifier.height(50.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                                    ){
                                Text(
                                    text = "Abilities",
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                    style = MaterialTheme.typography.h6,
                                )
                            }
                        }
                        items(pokemon.abilities){ability->
                            run {
                                PokemonAbilityItem(
                                    itemName = ability.ability.name,
                                    itemValue = ability.slot.toString(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                )
                                Divider()
                            }
                        }

                        item {
                            Spacer(Modifier.height(50.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ){
                                Text(
                                    text = "Game Indices",
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                    style = MaterialTheme.typography.h6,
                                )
                            }
                        }
                        items(pokemon.gameIndices){gameIndex->
                            run {
                                PokemonAbilityItem(
                                    itemName = gameIndex.version.name,
                                    itemValue = gameIndex.game_index.toString(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                )
                                Divider()
                            }
                        }
                    }
                }
                Column (
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                ){
                    Button(
                        onClick = {
                            viewModel.performPayment(pokemon.price)
                        },
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        contentPadding = PaddingValues(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onSurface
                        ),
                    ){
                        Text(
                            text = "Buy Pokemon",
                            color = Color.White
                        )
                    }
                }
            }

            }
        }
        Utils.LoaderAndError(state, Modifier.align(Alignment.Center))
    }
}
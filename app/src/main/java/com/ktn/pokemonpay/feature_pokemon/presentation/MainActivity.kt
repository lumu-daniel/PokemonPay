package com.ktn.pokemonpay.feature_pokemon.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components.PokemonDetailsScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.purchase_result.components.PurchaseResultScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.search_Pokemon.SearchPokemonScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.theme.PokemonPayTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonPayTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.SearchPokemonScreen.route){
                        composable(
                            route = Screen.SearchPokemonScreen.route
                        ) {
                            SearchPokemonScreen(navController)
                        }
                        composable(
                            route = Screen.PokemonDetailsScreen.route+"/{pokemon_name}"
                        ) {
                            PokemonDetailsScreen(navController)
                        }
                        composable(
                            route = Screen.PurchaseResultScreen.route+"/{purchase_result}"
                        ) {
                            PurchaseResultScreen()
                        }
                    }
                }
            }
        }
    }
}

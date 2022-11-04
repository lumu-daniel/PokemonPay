package com.ktn.pokemonpay.feature_pokemon.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktn.pokemonpay.feature_pokemon.presentation.Screen
import com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components.PokemonDetailsScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.purchase_result.components.PurchaseResultScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.search_Pokemon.SearchPokemonScreen

@Composable
fun AppNavHost(
    navController: NavHostController
){
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
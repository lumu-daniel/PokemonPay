package com.ktn.pokemonpay

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ktn.pokemonpay.feature_pokemon.presentation.Screen
import com.ktn.pokemonpay.feature_pokemon.presentation.components.AppNavHost
import com.ktn.pokemonpay.feature_pokemon.presentation.pokemon_details.components.PokemonDetailsScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.purchase_result.components.PurchaseResultScreen
import com.ktn.pokemonpay.feature_pokemon.presentation.search_Pokemon.SearchPokemonScreen
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SearchPokemonUnitTest {

    @get:Rule
    @JvmField
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navController = navController)
        }
    }

    // Unit test
    @Test
    fun appNavHost_verifyStartDestination() {
        composeTestRule
            .onNodeWithContentDescription(Screen.SearchPokemonScreen.route)
            .assertIsDisplayed()
    }
}
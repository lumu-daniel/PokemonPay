package com.ktn.pokemonpay.feature_pokemon.presentation.purchase_result

import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ktn.pokemonpay.feature_pokemon.common.Constants.PARAM_PURCHASE_RESULT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseResultViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf("")
    val state = _state

    init {
        savedStateHandle.get<String>(PARAM_PURCHASE_RESULT)?.let{
            _state.value = it
        }
    }
}
package com.example.diceroller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.diceroller.models.DiceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DiceViewModel : ViewModel() {

    private val _diceUiState = MutableStateFlow(DiceUiState())
    val diceUiState : StateFlow<DiceUiState> = _diceUiState.asStateFlow()

     var imageResource = when (_diceUiState.value.result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    fun onButtonClicked() {
        // Logic to handle button click
        _diceUiState.update { currentState ->
            currentState.copy(
                result = (1..6).random(),
                totalrolls = currentState.totalrolls + 1,
                diceCounts = currentState.diceCounts.toMutableList().apply {
                    val result = currentState.result
                    this[result - 1] = this[result - 1] + 1
                }
            )
        }
//        _diceUiState.value.result = (1..6).random()
//        _diceUiState.value.totalrolls++
//        diceCounts[result - 1]++
    }
}
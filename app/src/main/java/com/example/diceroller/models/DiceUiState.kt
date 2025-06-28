package com.example.diceroller.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class DiceUiState(
    val diceCounts: List<Int> = mutableStateListOf(0, 0, 0, 0, 0, 0),
    val totalrolls  : Int = 0,
    var result : Int = 1,
)



package com.example.diceroller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {

    val diceCounts = mutableStateListOf(0, 0, 0, 0, 0, 0)
    var totalrolls by mutableStateOf(0)

    var result by  mutableStateOf(1)
    var imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    fun onButtonClicked() {
        // Logic to handle button click
        result = (1..6).random()
        totalrolls++
        diceCounts[result - 1]++
    }
}
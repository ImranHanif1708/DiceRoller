package com.example.diceroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
    fun DiceWithButtonAndImage(
    viewModel: DiceViewModel = viewModel(),modifier : Modifier = Modifier
    ) {
        val diceUiState  by viewModel.diceUiState.collectAsState()
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Total Rolls = ${diceUiState.totalrolls}")
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in 1..3) {
                    Text("No.$i : ${diceUiState.diceCounts[i - 1]}")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in 4..6) {
                    Text("No.$i : ${diceUiState.diceCounts[i - 1]}")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(viewModel.imageResource),
                contentDescription = viewModel.imageResource.toString()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.onButtonClicked() },
                Modifier.height(48.dp).width(100.dp)) {
                Text(text = stringResource(R.string.roll))
            }

        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DiceRollerApp() {

        DiceWithButtonAndImage()

    }
package com.example.tictactoecompose.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

object TicTacToeViewModel:ViewModel() {
    var isWon by mutableStateOf(false)
    var isDraw by mutableStateOf(false)
    var isPlaying by mutableStateOf(true)
    var currentUser by mutableStateOf("X")
    var currentUserText by mutableStateOf("X")
    val startColor = Color.White
    var rowCount by mutableStateOf(3)
    var allFields by mutableStateOf(Array(rowCount){Array(rowCount){""} })
}
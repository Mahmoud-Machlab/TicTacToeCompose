package com.example.tictactoecompose.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

object TicTacToeViewModel:ViewModel() {
    var isWon by mutableStateOf(false)
    var isDraw by mutableStateOf(false)
    var isPlaying by mutableStateOf(true)
    var currentUser by mutableStateOf("X")
}
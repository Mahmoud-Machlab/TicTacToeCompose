package com.example.tictactoecompose.engin

import androidx.compose.ui.graphics.Color
import com.example.tictactoecompose.model.TicTacToeViewModel
import com.example.tictactoecompose.model.TicTacToeViewModel.allFields

var screenWidth: Float = 0f
var screenHeight: Float = 0f

fun fieldOnClick(bColor: Color, row: Int, col: Int): Color {
    var retColor = bColor
    if (!TicTacToeViewModel.isPlaying) TicTacToeViewModel.isPlaying = !TicTacToeViewModel.isPlaying
    if (TicTacToeViewModel.currentUser == "X") {
        retColor = Color.Red
        TicTacToeViewModel.currentUser = "O"
        TicTacToeViewModel.currentUserText = "X"
    } else {
        retColor = Color.Green
        TicTacToeViewModel.currentUser = "X"
        TicTacToeViewModel.currentUserText = "O"
    }
    TicTacToeViewModel.allFields[row][col] = TicTacToeViewModel.currentUserText
    if (checkWin()) {
        TicTacToeViewModel.isWon = true
        TicTacToeViewModel.currentUser = TicTacToeViewModel.currentUserText
    } else {
        var hasFreeField = false
        TicTacToeViewModel.allFields.forEach { array ->
            array.forEach { string ->
                if (string == "")
                    hasFreeField = true
            }
        }
        if (!hasFreeField)
            TicTacToeViewModel.isDraw = true
    }
    return retColor
}

fun checkWin(): Boolean {

    val rows =
        allFields[0][0] == allFields[0][1] && allFields[0][0] == allFields[0][2] && allFields[0][0] != "" ||
                allFields[1][0] == allFields[1][1] && allFields[1][0] == allFields[1][2] && allFields[1][0] != "" ||
                allFields[2][0] == allFields[2][1] && allFields[2][0] == allFields[2][2] && allFields[2][0] != ""

    val cols =
        allFields[0][0] == allFields[1][0] && allFields[0][0] == allFields[2][0] && allFields[0][0] != "" ||
                allFields[0][1] == allFields[1][1] && allFields[0][1] == allFields[2][1] && allFields[0][1] != "" ||
                allFields[0][2] == allFields[1][2] && allFields[0][2] == allFields[2][2] && allFields[0][2] != ""

    val diagonal =
        allFields[0][0] == allFields[1][1] && allFields[0][0] == allFields[2][2] && allFields[0][0] != "" ||
                allFields[0][2] == allFields[1][1] && allFields[0][2] == allFields[2][0] && allFields[0][2] != ""

    return rows || cols || diagonal
}

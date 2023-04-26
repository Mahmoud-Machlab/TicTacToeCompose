package com.example.tictactoecompose.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoecompose.R
import com.example.tictactoecompose.model.TicTacToeViewModel


@Composable
fun Status() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
    ) {
        Text(
            text = if (TicTacToeViewModel.isWon)
                stringResource(id = R.string.tv_status_win, TicTacToeViewModel.currentUser)
            else if (TicTacToeViewModel.isDraw)
                stringResource(id = R.string.tv_status_draw)
            else
                stringResource(id = R.string.tv_status_start, TicTacToeViewModel.currentUser),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
            fontSize = 24.sp
        )
    }
}

@Composable
fun Field(){

}

@Composable
fun GameField(rows: Int, cols: Int){

}
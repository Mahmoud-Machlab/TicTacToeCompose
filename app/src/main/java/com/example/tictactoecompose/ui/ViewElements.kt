package com.example.tictactoecompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoecompose.R
import com.example.tictactoecompose.engin.fieldOnClick
import com.example.tictactoecompose.engin.screenHeight
import com.example.tictactoecompose.engin.screenWidth
import com.example.tictactoecompose.model.TicTacToeViewModel
import kotlin.reflect.KProperty


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
fun Field(modifier: Modifier, row: Int, col:Int){
    var bColor by remember {
        mutableStateOf(Color.White)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable { bColor = fieldOnClick(bColor, row, col)}
            .background(
                if (TicTacToeViewModel.isPlaying) bColor else {
                    bColor = TicTacToeViewModel.startColor
                    TicTacToeViewModel.startColor
                }
            ),

    ){
        Text(text = if(bColor == Color.White) "" else TicTacToeViewModel.allFields[row][col],
            fontSize = 36.sp,
            textAlign = TextAlign.Center

        )
    }

}


@Composable
fun GameField(rows: Int, cols: Int){
    val size = if (screenWidth < screenHeight) screenWidth else screenHeight
    Column(modifier = Modifier
        .width(size.dp)
        .height(size.dp)
        .fillMaxSize()
        .padding(8.dp)
        .border(1.dp, Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(rows){row ->
            Row(modifier = Modifier
                .fillMaxWidth(1f)
                .weight(1f)
            ) {
                repeat(cols){col ->
                    Field(
                        Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .border(1.dp, Color.Black),
                        row,col
                    )
                }
            }
        }
    }
}
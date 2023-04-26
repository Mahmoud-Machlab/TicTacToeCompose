package com.example.tictactoecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoecompose.engin.screenHeight
import com.example.tictactoecompose.engin.screenWidth
import com.example.tictactoecompose.ui.Status
import com.example.tictactoecompose.ui.theme.TicTacToeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FullScreen("Android")
                }
            }
        }
        val displaMetrics = resources.displayMetrics
        screenHeight = displaMetrics.heightPixels/displaMetrics.density
        screenWidth = displaMetrics.widthPixels/displaMetrics.density
    }
}


@Composable
fun FullScreen(name: String, modifier: Modifier = Modifier) {

    val count = rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) },

            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { count.value++}) {
                Text(text = "Reset")
            }
        }

        ) {
        it.calculateBottomPadding()
        Column {
            Text(text = count.value.toString(), modifier = Modifier.padding(all =  8.dp))
            Status()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TicTacToeComposeTheme {
        FullScreen("Android")
    }
}
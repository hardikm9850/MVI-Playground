package com.hardik.mvidemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hardik.mvidemo.ui.theme.MVIDemoTheme
import com.hardik.mvidemo.ui.theme.MainReducer
import com.hardik.mvidemo.ui.theme.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVIDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterWidget(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun CounterWidget(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val number = viewModel.uiState.collectAsState()
    ListenOneTimeEffects(viewModel)
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Counter Example",
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Text(
            text = "${number.value.count}",
            modifier = Modifier.align(Alignment.Center)
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 100.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(
                enabled = true,
                onClick = {
                    viewModel.onAction(MainReducer.MainEvent.Increment)
                }) { Text("Increment") }

            Button(onClick = {
                viewModel.onAction(MainReducer.MainEvent.Decrement)
            }) { Text("Decrement") }
        }

    }
}

@Composable
fun ListenOneTimeEffects(viewModel: MainViewModel) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is MainReducer.MainEffect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
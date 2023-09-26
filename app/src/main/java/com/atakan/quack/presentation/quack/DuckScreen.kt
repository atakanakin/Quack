package com.atakan.quack.presentation.quack

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.atakan.quack.R
import com.atakan.quack.presentation.quack.components.Image

@Composable
fun DuckScreen(
    context: Context,
    viewModel: DuckViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    val mediaPlayer = MediaPlayer.create(context, R.raw.quack)

    // Remember the viewModel to avoid unnecessary recomposition
    val rememberedViewModel = remember { viewModel }

    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .padding(20.dp)
        .fillMaxHeight(1f)) {
        if (!state.error.isNotBlank()){
            Text(text = "Here is your duck")
        }
        Box(
            modifier = Modifier.fillMaxHeight(0.5f),
            contentAlignment = Alignment.Center // Center the content vertically
        ) {
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
            } else if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier)
            } else {
                Image(duck = state.duck, modifier = Modifier)
            }
        }

        Button(onClick = {
            rememberedViewModel.refreshDuck()
            mediaPlayer.start()
        }) {
            Text(text = "Quack")
        }
    }
}

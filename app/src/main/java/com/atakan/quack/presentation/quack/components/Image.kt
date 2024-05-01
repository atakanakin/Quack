package com.atakan.quack.presentation.quack.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.atakan.quack.domain.model.Duck
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Image(duck: Duck,
          modifier: Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(duck.url)
            .crossfade(true)
            .build(),
        contentDescription = "Quack",
        modifier = modifier.fillMaxWidth()
    )

}
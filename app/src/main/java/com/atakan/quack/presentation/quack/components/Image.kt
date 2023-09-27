package com.atakan.quack.presentation.quack.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.atakan.quack.domain.model.Duck
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Image(duck: Duck,
          modifier: Modifier
) {
    GlideImage(model = duck.url, contentDescription = "Quack", modifier = modifier.fillMaxWidth())
}
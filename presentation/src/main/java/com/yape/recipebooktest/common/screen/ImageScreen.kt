package com.yape.recipebooktest.common.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun Image(imagePath: String, modifier: Modifier = Modifier) {
    GlideImage(imageModel = imagePath, modifier = modifier.fillMaxWidth())
}
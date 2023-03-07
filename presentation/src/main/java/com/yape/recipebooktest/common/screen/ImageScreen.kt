package com.yape.recipebooktest.common.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.yape.recipebooktest.R
import com.yape.recipebooktest.ui.theme.Multiplier_X100
import com.yape.recipebooktest.ui.theme.Purple700


@Composable
fun ImageScreen(imagePath: String, modifier: Modifier = Modifier) {
    GlideImage(
        imageModel = imagePath,
        imageOptions = ImageOptions(alignment = Alignment.Center),
        modifier = modifier
            .fillMaxWidth()
            .height(Multiplier_X100),
        failure = {
            val emptyImage = painterResource(id = R.drawable.ic_empty_list_512)
            Icon(
                painter = emptyImage,
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center),
                tint = Purple700
            )
        },
        loading = {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    )
}
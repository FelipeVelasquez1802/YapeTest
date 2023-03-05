package com.yape.recipebooktest.common.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.yape.recipebooktest.ui.theme.Multiplier_X2
import com.yape.recipebooktest.ui.theme.Multiplier_X4


@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle = MaterialTheme.typography.h4
) {
    Text(
        text = title,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Multiplier_X2, vertical = Multiplier_X4),
        style = style,
        textAlign = textAlign
    )
}
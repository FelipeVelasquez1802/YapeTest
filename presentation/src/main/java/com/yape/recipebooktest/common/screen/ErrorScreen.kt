package com.yape.recipebooktest.common.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.yape.recipebooktest.R
import com.yape.recipebooktest.ui.theme.Multiplier_X4
import com.yape.recipebooktest.ui.theme.Purple700

@Composable
fun ErrorScreen(onUpdate:()->Unit){
    Column(
        modifier = Modifier
            .padding(Multiplier_X4)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val errorTitle = stringResource(id = R.string.title_error)
        Title(title = errorTitle)
        val errorIcon = painterResource(id = R.drawable.ic_error)
        Icon(
            painter = errorIcon,
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = Multiplier_X4),
            tint = Purple700
        )
        val errorMessage = stringResource(id = R.string.description_error)
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        val buttonText = stringResource(id = R.string.button_error)
        Button(onClick = onUpdate) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}
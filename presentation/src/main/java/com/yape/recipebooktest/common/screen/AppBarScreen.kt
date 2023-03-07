package com.yape.recipebooktest.common.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.yape.recipebooktest.R
import com.yape.recipebooktest.recipe.router.RecipeRouter
import com.yape.recipebooktest.ui.theme.Multiplier_X2


@Composable
fun AppBarScreen(@StringRes titleRes: Int) {
    val context = LocalContext.current
    TopAppBar(
        title = {
            val title = stringResource(id = titleRes)
            Title(
                title = title,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                val router = RecipeRouter()
                router.goToBack(context)
            }) {
                val backArrow = painterResource(id = R.drawable.ic_back_arrow_24)
                Icon(painter = backArrow, contentDescription = "")
            }
        },
        elevation = Multiplier_X2,
    )
}
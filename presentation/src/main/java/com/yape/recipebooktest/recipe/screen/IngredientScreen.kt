package com.yape.recipebooktest.recipe.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yape.domain.recipe.model.Ingredient
import com.yape.recipebooktest.ui.theme.Multiplier_X4

@Composable
fun IngredientScreen(ingredient: Ingredient) {
    Text(
        text = "- $ingredient",
        modifier = Modifier
            .padding(horizontal = Multiplier_X4)
            .fillMaxWidth(),
        style = MaterialTheme.typography.body1
    )
}
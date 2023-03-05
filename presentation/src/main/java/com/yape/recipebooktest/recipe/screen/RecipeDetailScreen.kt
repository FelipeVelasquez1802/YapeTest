package com.yape.recipebooktest.recipe.screen

import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.common.screen.Image
import com.yape.recipebooktest.common.screen.Title
import com.yape.recipebooktest.ui.theme.Multiplier_X100
import com.yape.recipebooktest.ui.theme.Multiplier_X4
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    LazyColumn {
        item { AppBar() }
        item { Image(imagePath = recipe.image, modifier = Modifier.height(Multiplier_X100)) }
        item {
            Title(
                title = recipe.name,
                modifier = Modifier.padding(horizontal = Multiplier_X4),
                textAlign = TextAlign.Start
            )
        }
        item { DescriptionScreen(description = recipe.description) }
        item { Divider() }
        item { Title(title = "Ingredientes", style = MaterialTheme.typography.subtitle1) }
        items(recipe.ingredients) { ingredient ->
            IngredientScreen(ingredient = ingredient)
        }
        item { Divider() }
        item { MapButtonScreen() }
    }
}

@Composable
private fun AppBar() {
    TopAppBar {
        Text(
            text = "Recipe detail",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun DescriptionScreen(description: String) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Multiplier_X4),
        factory = { context ->
            TextView(context).apply {
                text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
        })
}

@Composable
private fun MapButtonScreen() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(horizontal = Multiplier_X4)
            .fillMaxWidth()
    ) {
        Text(text = "Ver ubicacion")
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipesPreview() {
    RecipeBookTestTheme {
        val ingredients = listOf(
            Ingredient(name = "banana", amount = 0.25, unit = "cup")
        )
        val recipe = Recipe(
            name = "Example 1",
            description = "Description 1",
            image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
            showMapButton = true,
            ingredients = ingredients
        )
        RecipeDetailScreen(recipe = recipe)
    }
}
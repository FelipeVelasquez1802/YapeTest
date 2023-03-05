package com.yape.recipebooktest.recipe.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.glide.GlideImage
import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.R
import com.yape.recipebooktest.ui.theme.Multiplier
import com.yape.recipebooktest.ui.theme.Multiplier_X2
import com.yape.recipebooktest.ui.theme.Multiplier_X4
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme

@Composable
fun RecipesScreen(recipes: List<Recipe>) {
    Column {
        val filterRecipe = recipes.toMutableStateList()
        val onSearch: (key: String) -> Unit = { key ->
            val result = recipes.filter {
                it.name.contains(key, ignoreCase = true) || it.isIngredient(key)
            }
            filterRecipe.clear()
            filterRecipe.addAll(result)
        }
        AppBarScreen(onSearch)
        LazyColumn(
            modifier = Modifier.padding(
                vertical = Multiplier_X4,
                horizontal = Multiplier_X2
            )
        ) {
            items(filterRecipe) { recipe ->
                RecipeScreen(recipe = recipe)
            }
        }
    }
}

private fun Recipe.isIngredient(key: String): Boolean =
    ingredients.any { it.name.contains(key, ignoreCase = true) }

@Composable
private fun AppBarScreen(onSearch: (String) -> Unit) {
    TopAppBar {
        SearchScreen(onSearch)
    }
}

@Composable
private fun SearchScreen(onSearch: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Multiplier_X4, vertical = Multiplier)
    ) {
        TextField(
            value = text,
            onValueChange = {
                onSearch.invoke(it)
                text = it
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_24),
                    contentDescription = "ParamsEnum.SEARCH.value"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun RecipeScreen(recipe: Recipe) {
    Card(modifier = Modifier.padding(all = Multiplier_X4), elevation = Multiplier_X2) {
        Column {
            Title(title = recipe.name)
            Image(imagePath = recipe.image)
        }
    }
}

@Composable
private fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Multiplier_X2, vertical = Multiplier_X4),
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Image(imagePath: String) {
    GlideImage(imageModel = imagePath, modifier = Modifier.fillMaxWidth())
}

@Preview(showBackground = true)
@Composable
private fun RecipesPreview() {
    RecipeBookTestTheme {
        val ingredients = listOf(
            Ingredient(name = "banana", amount = 0.25, unit = "cup")
        )
        val recipes = listOf(
            Recipe(
                name = "Example 1",
                description = "Description 1",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients
            ),
            Recipe(
                name = "Example 2",
                description = "Description 2",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients
            ),
            Recipe(
                name = "Example 3",
                description = "Description 3",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients
            ),
            Recipe(
                name = "Example 4",
                description = "Description 4",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients
            )
        )
        RecipesScreen(recipes)
    }
}
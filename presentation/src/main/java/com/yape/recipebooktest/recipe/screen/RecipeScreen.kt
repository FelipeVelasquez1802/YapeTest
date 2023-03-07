package com.yape.recipebooktest.recipe.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Location
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.R
import com.yape.recipebooktest.common.screen.ImageScreen
import com.yape.recipebooktest.common.screen.Title
import com.yape.recipebooktest.recipe.model.KeyRecipeFieldEnum
import com.yape.recipebooktest.recipe.router.RecipeRouter
import com.yape.recipebooktest.ui.theme.Multiplier_X2
import com.yape.recipebooktest.ui.theme.Multiplier_X4
import com.yape.recipebooktest.ui.theme.Purple700
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme

@Composable
fun RecipesScreen(recipes: List<Recipe>) {
    if (recipes.isEmpty()) EmptyListScreen()
    else {
        LazyColumn(
            modifier = Modifier.padding(horizontal = Multiplier_X2)
        ) {
            items(recipes) { recipe ->
                RecipeScreen(recipe = recipe)
            }
        }
    }
}

@Composable
private fun EmptyListScreen() {
    Column(
        modifier = Modifier
            .padding(Multiplier_X4)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val emptyListTitle = stringResource(id = R.string.title_empty_list)
        Title(title = emptyListTitle)
        val emptyList = painterResource(id = R.drawable.ic_empty_list_512)
        val description = stringResource(id = R.string.description_recipe_image)
        Icon(
            painter = emptyList,
            contentDescription = description,
            modifier = Modifier
                .padding(vertical = Multiplier_X4)
                .testTag(KeyRecipeFieldEnum.TITLE_EMPTY_LIST.name),
            tint = Purple700
        )
        val emptyListMessage = stringResource(id = R.string.message_emptyList)
        Text(
            text = emptyListMessage,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun RecipeScreen(recipe: Recipe) {
    Card(
        modifier = Modifier
            .padding(all = Multiplier_X4)
            .clickable {
                val router = RecipeRouter()
                router.goToRecipeDetail(recipe)
            }
            .testTag(KeyRecipeFieldEnum.CARD_RECIPE.name),
        elevation = Multiplier_X2,
    ) {
        Column {
            Title(
                title = recipe.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.testTag(KeyRecipeFieldEnum.CARD_TITLE.name)
            )
            Divider()
            ImageScreen(imagePath = recipe.image)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipesPreview() {
    RecipeBookTestTheme {
        val ingredients = listOf(
            Ingredient(name = "banana", amount = 0.25, unit = "cup")
        )
        val location = Location(
            name = "Singapore",
            description = "Marker in Singapore",
            latitude = 1.35,
            longitude = 103.87
        )
        val recipes = listOf(
            Recipe(
                name = "Example 1",
                description = "Description 1",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients,
                location = location
            ), Recipe(
                name = "Example 2",
                description = "Description 2",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients,
                location = location
            ), Recipe(
                name = "Example 3",
                description = "Description 3",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients,
                location = location
            ), Recipe(
                name = "Example 4",
                description = "Description 4",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                showMapButton = true,
                ingredients = ingredients,
                location = location
            )
        )
        RecipesScreen(recipes)
    }
}
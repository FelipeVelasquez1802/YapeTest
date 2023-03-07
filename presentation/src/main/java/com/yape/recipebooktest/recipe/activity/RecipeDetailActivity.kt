package com.yape.recipebooktest.recipe.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Location
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.R
import com.yape.recipebooktest.common.screen.AppBarScreen
import com.yape.recipebooktest.common.screen.ErrorScreen
import com.yape.recipebooktest.recipe.mapper.RecipeMapper
import com.yape.recipebooktest.recipe.model.KeyRecipeFieldEnum
import com.yape.recipebooktest.recipe.model.RecipeView
import com.yape.recipebooktest.recipe.screen.RecipeDetailScreen
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme

class RecipeDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeBookTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val onUpdate:()->Unit ={
                        recreate()
                    }
                    val recipe = intent.getRecipeOrNull()
                    recipe?.let {
                        RecipeDetail(it)
                    } ?: run {
                        ErrorScreen(onUpdate = onUpdate)
                    }
                }
            }
        }
    }

    private fun Intent.getRecipeOrNull(): Recipe? {
        val recipeView: RecipeView? = extras?.getParcelable(KeyRecipeFieldEnum.RECIPE_KEY.name)
        return recipeView?.let { RecipeMapper.fromViewToDomain(it) }
    }
}

@Composable
private fun RecipeDetail(recipe: Recipe) {
    Column {
        AppBarScreen(titleRes = R.string.title_recipe_detail)
        RecipeDetailScreen(recipe = recipe)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
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
        val recipe = Recipe(
            name = "Example 1",
            description = "Description 1",
            image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
            showMapButton = true,
            ingredients = ingredients,
            location = location
        )
        RecipeDetail(recipe = recipe)
    }
}
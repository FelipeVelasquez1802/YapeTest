package com.yape.recipebooktest.recipe.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.recipe.screen.RecipesScreen
import com.yape.recipebooktest.recipe.viewmodel.RecipeViewModel
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeViewModel.executeGetRecipes()
        setContent {
            RecipeBookTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val recipes = recipeViewModel.recipes
                    MainScreen(recipes)
                }
            }
        }
    }
}

@Composable
private fun MainScreen(recipes:List<Recipe>) {
    RecipesScreen(recipes = recipes)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
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
        MainScreen(recipes = recipes)
    }
}
package com.yape.recipebooktest.recipe.action

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Location
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.YapeApplication
import com.yape.recipebooktest.recipe.activity.MainScreen
import com.yape.recipebooktest.recipe.model.KeyRecipeFieldEnum
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme

class RecipeAction(private val composableTestRule: ComposeContentTestRule) {

    private val context = YapeApplication.getContext()

    private val ingredients = listOf(
        Ingredient(name = "banana", amount = 0.25, unit = "cup")
    )
    private val location = Location(
        name = "Singapore",
        description = "Marker in Singapore",
        latitude = 1.35,
        longitude = 103.87
    )
    private val recipes = listOf(
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

    fun setUp() {
        composableTestRule.setContent {
            RecipeBookTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(recipes = recipes)
                }
            }
        }
    }

    fun addSearchText(text: String) {
        val search = composableTestRule.onNodeWithTag(KeyRecipeFieldEnum.SEARCH_KEY.name)
        search.performTextInput(text)
    }

    fun validateEmptyList() {
        val titleEmptyList = composableTestRule.onNodeWithTag(KeyRecipeFieldEnum.TITLE_EMPTY_LIST.name)
        titleEmptyList.assertExists()
    }

    fun validateRecipes() {
        composableTestRule.waitUntil {
            val titleEmptyList = composableTestRule.onAllNodesWithTag(KeyRecipeFieldEnum.CARD_RECIPE.name)
            titleEmptyList.fetchSemanticsNodes().isNotEmpty()
        }
    }

    fun validateOnlyRecipe() {
        composableTestRule.waitUntil {
            val titleEmptyList = composableTestRule.onAllNodesWithTag(KeyRecipeFieldEnum.CARD_RECIPE.name)
            titleEmptyList.fetchSemanticsNodes().size == 1
        }
    }
}
package com.yape.recipebooktest.recipe.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.R
import com.yape.recipebooktest.recipe.model.KeyRecipeFieldEnum
import com.yape.recipebooktest.recipe.screen.RecipesScreen
import com.yape.recipebooktest.recipe.viewmodel.RecipeViewModel
import com.yape.recipebooktest.ui.theme.Multiplier
import com.yape.recipebooktest.ui.theme.Multiplier_X4
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
                    val isLoading = recipeViewModel.isLoading
                    if (isLoading.value) LoadingScreen()
                    else {
                        val recipes = recipeViewModel.recipes
                        MainScreen(recipes = recipes)
                    }
                }
            }
        }
    }
}

@Composable
private fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun MainScreen(recipes: List<Recipe>) {
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
        RecipesScreen(filterRecipe)
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
            modifier = Modifier
                .fillMaxWidth()
                .testTag(KeyRecipeFieldEnum.SEARCH_KEY.name)
        )
    }
}
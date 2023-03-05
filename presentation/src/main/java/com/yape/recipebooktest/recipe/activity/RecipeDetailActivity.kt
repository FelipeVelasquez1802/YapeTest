package com.yape.recipebooktest.recipe.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.recipe.mapper.RecipeMapper
import com.yape.recipebooktest.recipe.model.KeyFieldEnum
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
                    val recipe = intent.getRecipeOrNull()
                    recipe?.let {
                        RecipeDetailScreen(recipe = it)
                    } ?: run {
                        // TODO: Colocar mensaje de error
                    }
                }
            }
        }
    }

    private fun Intent.getRecipeOrNull(): Recipe? {
        val recipeView: RecipeView? = extras?.getParcelable(KeyFieldEnum.RECIPE_KEY.name)
        return recipeView?.let { RecipeMapper.fromViewToDomain(it) }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    RecipeBookTestTheme {
        Greeting("Android")
    }
}
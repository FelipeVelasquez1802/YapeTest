package com.yape.recipebooktest.recipe

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.yape.recipebooktest.recipe.action.RecipeAction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RecipeInstrumentedTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    private val actions by lazy { RecipeAction(composableTestRule) }

    @Test
    fun givenSearchRecipe_whenTheTextIsExample15_thenReturnEmptyList() {
        val searchText = "Example15"
        actions.setUp()
        actions.addSearchText(searchText)
        actions.validateEmptyList()
    }

    @Test
    fun givenSearchRecipe_whenTheTextIsExample_thenReturnRecipes() {
        val searchText = "Example"
        actions.setUp()
        actions.addSearchText(searchText)
        actions.validateRecipes()
    }

    @Test
    fun givenSearchRecipe_whenTheTextIsExample1_thenReturnOnlyRecipe() {
        val searchText = "Example 1"
        actions.setUp()
        actions.addSearchText(searchText)
        actions.validateOnlyRecipe()
    }
}
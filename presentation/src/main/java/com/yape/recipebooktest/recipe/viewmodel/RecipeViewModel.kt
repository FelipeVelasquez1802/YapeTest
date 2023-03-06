package com.yape.recipebooktest.recipe.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.yape.domain.recipe.model.Recipe
import com.yape.domain.recipe.service.RecipeService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal open class RecipeViewModel @Inject constructor() : ViewModel() {
    @Inject
    protected lateinit var recipeService: RecipeService

    val recipes: MutableList<Recipe> = mutableStateListOf()
    val isLoading = mutableStateOf(true)

    fun executeGetRecipes() {
        isLoading.value = true
        CoroutineScope(IO).launch {
            val result = recipeService.consultRecipes()
            recipes.apply {
                clear()
                addAll(result)
            }
            isLoading.value = false
        }
    }
}
package com.yape.domain.recipe.repository

import com.yape.domain.recipe.model.Recipe

interface RecipeRepository {
    fun consultRecipes(): List<Recipe>
}
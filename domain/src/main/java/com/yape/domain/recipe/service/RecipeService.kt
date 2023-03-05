package com.yape.domain.recipe.service

import com.yape.domain.recipe.model.Recipe
import com.yape.domain.recipe.repository.RecipeRepository
import javax.inject.Inject

class RecipeService @Inject constructor(private val recipeRepository: RecipeRepository) {

    fun consultRecipes(): List<Recipe> = recipeRepository.consultRecipes()
}
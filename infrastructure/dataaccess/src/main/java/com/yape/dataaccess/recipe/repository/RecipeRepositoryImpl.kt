package com.yape.dataaccess.recipe.repository

import com.yape.dataaccess.recipe.RecipeAdapter
import com.yape.dataaccess.recipe.mapper.RecipeMapper
import com.yape.domain.recipe.model.Recipe
import com.yape.domain.recipe.repository.RecipeRepository
import javax.inject.Inject

internal class RecipeRepositoryImpl @Inject constructor(private val recipeAdapter: RecipeAdapter) :
    RecipeRepository {
    override fun consultRecipes(): List<Recipe> {
        val recipesDto = recipeAdapter.getRecipes()
        return RecipeMapper.fromListDtoToListDomain(recipesDto)
    }
}
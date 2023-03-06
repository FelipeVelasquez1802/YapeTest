package com.yape.dataaccess.recipe

import com.yape.dataaccess.common.ConfigApi
import com.yape.dataaccess.recipe.api.RecipeApi
import com.yape.dataaccess.recipe.dto.RecipeDto
import javax.inject.Inject

internal class RecipeAdapter @Inject constructor() {
    private val api = ConfigApi.getApi(RecipeApi::class.java)
    fun getRecipes(): List<RecipeDto> {
        val recipesDtoCall = api.getRecipes()
        val recipesDtoResponse = recipesDtoCall.execute()
        return recipesDtoResponse.body().orEmpty()
    }
}
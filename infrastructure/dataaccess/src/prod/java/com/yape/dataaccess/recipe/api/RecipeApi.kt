package com.yape.dataaccess.recipe.api

import com.yape.dataaccess.recipe.dto.RecipeDto
import retrofit2.Call
import retrofit2.http.GET

private const val RECIPES_PATH = "/recipes"

internal interface RecipeApi {
    @GET(RECIPES_PATH)
    fun getRecipes(): Call<List<RecipeDto>>
}
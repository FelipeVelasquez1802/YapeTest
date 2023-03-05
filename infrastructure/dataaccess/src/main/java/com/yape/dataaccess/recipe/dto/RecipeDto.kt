package com.yape.dataaccess.recipe.dto

internal data class RecipeDto(
    val name: String,
    val description: String,
    val image: String,
    val showMapButton: Boolean = true,
    val ingredients: List<IngredientDto>
)
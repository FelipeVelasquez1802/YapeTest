package com.yape.dataaccess.recipe

import com.yape.dataaccess.recipe.dto.IngredientDto
import com.yape.dataaccess.recipe.dto.RecipeDto
import javax.inject.Inject

internal class RecipeAdapter @Inject constructor() {
    fun getRecipes(): List<RecipeDto> {
        val ingredients = listOf(
            IngredientDto(name = "banana", amount = 0.25, unit = "cup")
        )
        return listOf(
            RecipeDto(
                name = "Example 1",
                description = "Description 1",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                ingredients = ingredients
            ),
            RecipeDto(
                name = "Example 2",
                description = "Description 2",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                ingredients = ingredients
            ),
            RecipeDto(
                name = "Example 3",
                description = "Description 3",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                ingredients = ingredients
            ),
            RecipeDto(
                name = "Example 4",
                description = "Description 4",
                image = "www.image.com/image4.png",
                ingredients = ingredients
            )
        )
    }
}
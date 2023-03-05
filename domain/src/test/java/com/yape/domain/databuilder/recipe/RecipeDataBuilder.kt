package com.yape.domain.databuilder.recipe

import com.yape.domain.recipe.model.Ingredient
import com.yape.domain.recipe.model.Recipe

internal class RecipeDataBuilder {

    private var name: String = "Example"
    private var description: String = "Example"
    private var image: String = "www.image.com/image.png"
    private var ingredients = mutableListOf(IngredientDataBuilder().build())

    fun withName(name: String): RecipeDataBuilder = this.apply { this.name = name }

    fun withDescription(description: String): RecipeDataBuilder =
        this.apply { this.description = description }

    fun withImage(image: String): RecipeDataBuilder = this.apply { this.image = image }

    fun withIngredients(ingredients: List<Ingredient>) = this.apply {
        this.ingredients.apply {
            clear()
            addAll(ingredients)
        }
    }

    fun build(): Recipe {
        val showMapButton = true
        return Recipe(name, description, image, showMapButton, ingredients)
    }
}
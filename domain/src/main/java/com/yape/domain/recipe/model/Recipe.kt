package com.yape.domain.recipe.model

import com.yape.domain.exception.BadUrlException
import com.yape.domain.exception.EmptyListException
import com.yape.domain.exception.EmptyValueException

class Recipe(
    val name: String,
    val description: String,
    val image: String,
    val showMapButton: Boolean,
    val ingredients: List<Ingredient>,
    val location: Location
) {
    init {
        validateName()
        validateDescription()
        validateImage()
        validateIngredients()
    }

    private fun validateName() {
        if (name.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateDescription() {
        if (description.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateImage() {
        validateEmptyImage()
        validateVadImageUrl()
    }

    private fun validateEmptyImage() {
        if (image.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateIngredients() {
        if (ingredients.isEmpty()) {
            throw EmptyListException()
        }
    }

    private fun validateVadImageUrl() {
        val urlPattern =
            "^(http(s)?://)?[\\w.-]+(\\.[\\w.-]+)+[\\w\\-._~:/?#\\[\\]@!$&'()*+,;=%]*\$".toRegex()
        val isUrlValid = urlPattern.matches(image)
        if (isUrlValid.not()) {
            throw BadUrlException()
        }
    }
}
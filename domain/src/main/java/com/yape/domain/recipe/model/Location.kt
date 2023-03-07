package com.yape.domain.recipe.model

import com.yape.domain.exception.EmptyValueException

class Location(
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
) {
    init {
        validateName()
    }

    private fun validateName() {
        if (name.isEmpty()) {
            throw EmptyValueException()
        }
    }
}
package com.yape.domain.recipe.model

import com.yape.domain.exception.EmptyValueException
import com.yape.domain.exception.NegativeNumberException

class Ingredient(
    val name: String,
    val amount: Double,
    val unit: String
) {
    init {
        validate()
    }

    private fun validate() {
        validateName()
        validateAmount()
        validateUnit()
    }

    private fun validateName() {
        if (name.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateAmount() {
        if (amount < 0) {
            throw NegativeNumberException()
        }
    }

    private fun validateUnit() {
        if (unit.isEmpty()) {
            throw EmptyValueException()
        }
    }

    override fun toString(): String {
        return "$amount $unit $name"
    }
}
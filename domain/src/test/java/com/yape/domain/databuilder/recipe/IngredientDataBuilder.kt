package com.yape.domain.databuilder.recipe

import com.yape.domain.recipe.model.Ingredient

internal class IngredientDataBuilder {
    private var name: String = "banana"
    private var amount: Double = 0.25
    private var unit: String = "cup"

    fun withName(name: String): IngredientDataBuilder = this.apply { this.name = name }

    fun withAmount(amount: Double): IngredientDataBuilder = this.apply { this.amount = amount }

    fun withUnit(unit: String): IngredientDataBuilder = this.apply { this.unit = unit }

    fun build(): Ingredient = Ingredient(name, amount, unit)
}
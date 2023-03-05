package com.yape.dataaccess.recipe.mapper

import com.yape.dataaccess.recipe.dto.IngredientDto
import com.yape.domain.recipe.model.Ingredient

internal object IngredientMapper : BaseMapper<IngredientDto, Ingredient>() {
    override fun fromDtoToDomain(dto: IngredientDto): Ingredient =
        Ingredient(dto.name, dto.amount, dto.unit)

}
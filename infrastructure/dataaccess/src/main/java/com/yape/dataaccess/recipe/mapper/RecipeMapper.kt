package com.yape.dataaccess.recipe.mapper

import com.yape.dataaccess.recipe.dto.RecipeDto
import com.yape.domain.recipe.model.Recipe

internal object RecipeMapper : BaseMapper<RecipeDto, Recipe>() {
    override fun fromDtoToDomain(dto: RecipeDto): Recipe {
        val ingredients = IngredientMapper.fromListDtoToListDomain(dto.ingredients)
        val location = LocationMapper.fromDtoToDomain(dto.location)
        return Recipe(
            dto.name, dto.description, dto.image, dto.showMapButton, ingredients, location
        )
    }

}
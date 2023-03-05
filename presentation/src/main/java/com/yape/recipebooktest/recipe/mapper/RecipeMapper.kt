package com.yape.recipebooktest.recipe.mapper

import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.recipe.model.RecipeView

internal object RecipeMapper : BaseMapper<RecipeView, Recipe>() {
    override fun fromViewToDomain(view: RecipeView): Recipe {
        val ingredients = IngredientMapper.fromListViewToListDomain(view.ingredients)
        return Recipe(view.name, view.description, view.image, view.showMapButton, ingredients)
    }

    override fun fromDomainToView(domain: Recipe): RecipeView {
        val ingredients = IngredientMapper.fromListDomainToListView(domain.ingredients)
        return RecipeView(
            domain.name,
            domain.description,
            domain.image,
            domain.showMapButton,
            ingredients
        )
    }
}
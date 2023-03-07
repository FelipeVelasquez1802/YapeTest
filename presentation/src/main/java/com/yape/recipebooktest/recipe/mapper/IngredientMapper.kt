package com.yape.recipebooktest.recipe.mapper

import com.yape.domain.recipe.model.Ingredient
import com.yape.recipebooktest.common.mapper.BaseMapper
import com.yape.recipebooktest.recipe.model.IngredientView

internal object IngredientMapper : BaseMapper<IngredientView, Ingredient>() {
    override fun fromViewToDomain(view: IngredientView): Ingredient =
        Ingredient(view.name, view.amount, view.unit)

    fun fromListViewToListDomain(listView: List<IngredientView>): List<Ingredient> =
        listView.map { fromViewToDomain(it) }

    override fun fromDomainToView(domain: Ingredient): IngredientView =
        IngredientView(domain.name, domain.amount, domain.unit)

    fun fromListDomainToListView(listView: List<Ingredient>): List<IngredientView> =
        listView.map { fromDomainToView(it) }

}
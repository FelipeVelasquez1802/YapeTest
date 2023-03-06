package com.yape.recipebooktest.recipe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RecipeView(
    val name: String,
    val description: String,
    val image: String,
    val showMapButton: Boolean,
    val ingredients: List<IngredientView>,
    val location: LocationView
) : Parcelable

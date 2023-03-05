package com.yape.recipebooktest.recipe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class IngredientView(
    val name: String,
    val amount: Double,
    val unit: String
) : Parcelable

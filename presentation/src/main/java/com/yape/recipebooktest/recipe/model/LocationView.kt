package com.yape.recipebooktest.recipe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class LocationView(
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable
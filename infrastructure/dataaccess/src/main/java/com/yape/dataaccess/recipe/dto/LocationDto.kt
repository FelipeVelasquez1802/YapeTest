package com.yape.dataaccess.recipe.dto

internal data class LocationDto(
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)
package com.yape.domain.databuilder.recipe

import com.yape.domain.recipe.model.Location

class LocationDataBuilder {
    private var name: String = "Singapore"
    private var description: String = "Marker in Singapore"
    private var latitude: Double = 1.35
    private var longitude: Double = 103.87

    fun withName(name: String): LocationDataBuilder = this.apply { this.name = name }
    fun build(): Location = Location(name, description, latitude, longitude)
}
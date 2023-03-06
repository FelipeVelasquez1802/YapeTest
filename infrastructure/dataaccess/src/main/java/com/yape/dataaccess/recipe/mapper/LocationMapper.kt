package com.yape.dataaccess.recipe.mapper

import com.yape.dataaccess.recipe.dto.LocationDto
import com.yape.domain.recipe.model.Location

internal object LocationMapper : BaseMapper<LocationDto, Location>() {
    override fun fromDtoToDomain(dto: LocationDto): Location =
        Location(dto.name, dto.description, dto.latitude, dto.longitude)
}
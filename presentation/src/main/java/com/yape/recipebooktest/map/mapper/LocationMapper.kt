package com.yape.recipebooktest.map.mapper

import com.yape.domain.recipe.model.Location
import com.yape.recipebooktest.map.model.LocationView
import com.yape.recipebooktest.common.mapper.BaseMapper

internal object LocationMapper : BaseMapper<LocationView, Location>() {
    override fun fromViewToDomain(view: LocationView): Location =
        Location(view.name, view.description, view.latitude, view.longitude)

    override fun fromDomainToView(domain: Location): LocationView =
        LocationView(domain.name, domain.description, domain.latitude, domain.longitude)
}
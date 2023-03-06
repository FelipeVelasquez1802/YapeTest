package com.yape.recipebooktest.recipe.mapper

import com.yape.domain.recipe.model.Location
import com.yape.recipebooktest.recipe.model.LocationView

internal object LocationMapper : BaseMapper<LocationView, Location>() {
    override fun fromViewToDomain(view: LocationView): Location =
        Location(view.name, view.description, view.latitude, view.longitude)

    override fun fromDomainToView(domain: Location): LocationView =
        LocationView(domain.name, domain.description, domain.latitude, domain.longitude)
}
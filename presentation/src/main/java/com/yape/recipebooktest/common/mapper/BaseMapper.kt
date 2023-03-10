package com.yape.recipebooktest.common.mapper

internal abstract class BaseMapper<View, Domain> {
    abstract fun fromViewToDomain(view: View): Domain

    abstract fun fromDomainToView(domain: Domain): View

}
package com.yape.dataaccess.recipe.mapper

internal abstract class BaseMapper<Dto, Domain> {

    protected abstract fun fromDtoToDomain(dto: Dto): Domain

    fun fromListDtoToListDomain(listDto: List<Dto>): List<Domain> =
        listDto.map { fromDtoToDomain(it) }
}
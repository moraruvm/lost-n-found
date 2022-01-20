package io.millers.lostnfoundapi.mapper

import io.millers.lostnfoundapi.entity.AbstractDoc

interface DtoMapper<E : AbstractDoc<ID>, ID, C, R, U> {
    fun mapCreate(createDto: C): E
    fun mapUpdate(updateDto: U): E
    fun mapRead(doc: E): R
}
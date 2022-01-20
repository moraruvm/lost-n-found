package io.millers.lostnfoundapi.dto

import io.millers.lostnfoundapi.entity.parts.Location

data class UserDto(
        val id: String?,
        val displayName: String,
        val location: Location
)
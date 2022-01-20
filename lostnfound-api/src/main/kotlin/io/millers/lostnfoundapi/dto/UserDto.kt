package io.millers.lostnfoundapi.dto

import io.millers.lostnfoundapi.dto.parts.Location

data class UserDto(
        val id: String?,
        val displayName: String,
        val location: Location
)
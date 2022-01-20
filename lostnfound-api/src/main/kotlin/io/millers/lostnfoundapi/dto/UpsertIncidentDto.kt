package io.millers.lostnfoundapi.dto

import io.millers.lostnfoundapi.dto.parts.IncidentType
import io.millers.lostnfoundapi.dto.parts.Location

data class UpsertIncidentDto(
        val id: String?,
        val title: String,
        var type: IncidentType,
        var location: Location
)

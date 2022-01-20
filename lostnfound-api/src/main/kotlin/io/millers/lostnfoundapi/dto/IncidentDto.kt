package io.millers.lostnfoundapi.dto

import io.millers.lostnfoundapi.dto.parts.IncidentType
import io.millers.lostnfoundapi.dto.parts.Location
import java.time.LocalDateTime

data class IncidentDto(
        val id: String?,
        val title: String,
        var type: IncidentType,
        var location: Location,
        var createdAt: LocalDateTime,
        var open: Boolean,
        var authorId: String
)

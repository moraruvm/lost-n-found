package io.millers.lostnfoundapi.entity

import io.millers.lostnfoundapi.entity.parts.Location
import org.springframework.data.annotation.Id

data class User(
        @Id var id: String?,
        var displayName: String,
        var location: Location
)

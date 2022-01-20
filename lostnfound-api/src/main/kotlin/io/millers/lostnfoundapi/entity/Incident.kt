package io.millers.lostnfoundapi.entity

import io.millers.lostnfoundapi.dto.parts.IncidentType
import io.millers.lostnfoundapi.dto.parts.Location
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Incident(
        @Id override var id: String = ObjectId.get().toString(),
        val title: String,
        var type: IncidentType,
        var location: Location,
        var createdAt: LocalDateTime,
        var open: Boolean,
        var authorId: String
) : AbstractDoc<String>
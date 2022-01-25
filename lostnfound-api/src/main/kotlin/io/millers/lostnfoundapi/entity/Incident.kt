package io.millers.lostnfoundapi.entity

import io.millers.lostnfoundapi.dto.parts.IncidentType
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.geo.Point
import java.time.LocalDateTime

data class Incident(
    @Id override var id: String = ObjectId.get().toString(),
    val title: String,
    var type: IncidentType,
    var location: Point,
    var createdAt: LocalDateTime,
    var open: Boolean,
    var authorId: String
) : AbstractDoc<String>
package io.millers.lostnfoundapi.entity

import io.millers.lostnfoundapi.dto.parts.IncidentType
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Incident(
    @Id override var id: String = ObjectId.get().toString(),
    val title: String,
    var type: IncidentType,
    @GeoSpatialIndexed
    var location: Point,
    var createdAt: LocalDateTime,
    var open: Boolean,
    var authorId: String
) : AbstractDoc<String>
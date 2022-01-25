package io.millers.lostnfoundapi.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id override var id: String = ObjectId.get().toString(),
    var displayName: String,
    @GeoSpatialIndexed
    var location: Point
) : AbstractDoc<String>

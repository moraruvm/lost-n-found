package io.millers.lostnfoundapi.mapper

import io.millers.lostnfoundapi.dto.parts.Location
import org.springframework.data.geo.Point
import org.springframework.stereotype.Component

@Component
class PartMapper {
    fun toDocument(location: Location) = Point(location.lon, location.lat)
    fun toDto(geoPoint: Point) = Location(geoPoint.x, geoPoint.y)
}
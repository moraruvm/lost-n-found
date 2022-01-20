package io.millers.lostnfoundapi.entity

import io.millers.lostnfoundapi.dto.parts.Location
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class User(
        @Id override var id: String = ObjectId.get().toString(),
        var displayName: String,
        var location: Location
) : AbstractDoc<String>

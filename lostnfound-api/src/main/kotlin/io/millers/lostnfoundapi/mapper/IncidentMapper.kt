package io.millers.lostnfoundapi.mapper

import io.millers.lostnfoundapi.dto.IncidentDto
import io.millers.lostnfoundapi.dto.UpsertIncidentDto
import io.millers.lostnfoundapi.entity.Incident
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class IncidentMapper {

    fun toDocument(createDto: UpsertIncidentDto, authorId: String): Incident {
        return Incident(
                title = createDto.title,
                type = createDto.type,
                location = createDto.location,
                createdAt = LocalDateTime.now(),
                open = false,
                authorId = authorId
        );
    }

    fun toDto(doc: Incident): IncidentDto {
        return IncidentDto(doc.id, doc.title, doc.type, doc.location, doc.createdAt, doc.open, doc.authorId)
    }
}

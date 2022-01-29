package io.millers.lostnfoundapi.service

import io.millers.lostnfoundapi.common.UserDetailsProvider
import io.millers.lostnfoundapi.dto.IncidentDto
import io.millers.lostnfoundapi.dto.UpsertIncidentDto
import io.millers.lostnfoundapi.dto.search.GeoSearch
import io.millers.lostnfoundapi.entity.Incident
import io.millers.lostnfoundapi.mapper.IncidentMapper
import io.millers.lostnfoundapi.repo.IncidentRepo
import org.springframework.data.domain.Pageable
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class IncidentService(
    private val repo: IncidentRepo,
    private val mapper: IncidentMapper,
    private val userDetails: UserDetailsProvider
) {

    fun create(dto: UpsertIncidentDto): Mono<IncidentDto> {
        val doc = mapper.toDocument(dto, userDetails.getAuthorId())
        return repo.save(doc).map(mapper::toDto)
    }

    fun read(id: String): Mono<IncidentDto> {
        return repo.findById(id).map(mapper::toDto)
    }

    fun update(dto: UpsertIncidentDto): Mono<IncidentDto> {
        return dto.id?.let(repo::findById)
            ?.flatMap(repo::save)
            ?.map(mapper::toDto) ?: Mono.empty();
    }

    fun find(geoSearch: GeoSearch?, page: Pageable): Flux<IncidentDto> {
        return (geoSearch?.let { findAll(it) } ?: repo.findAll())
            .skip(page.offset)
            .take(page.pageSize.toLong())
            .map(mapper::toDto)
    }

    private fun findAll(geo: GeoSearch): Flux<Incident> {
        return repo.findAllByLocationNear(Point(geo.lat, geo.lon), Distance(geo.range))
    }
}

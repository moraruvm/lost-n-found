package io.millers.lostnfoundapi.controller

import io.millers.lostnfoundapi.dto.IncidentDto
import io.millers.lostnfoundapi.dto.UpsertIncidentDto
import io.millers.lostnfoundapi.dto.search.GeoSearch
import io.millers.lostnfoundapi.service.IncidentService
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class IncidentController(private val service: IncidentService) {

    @PostMapping("/incident")
    fun create(@RequestBody incident: UpsertIncidentDto): Mono<ResponseEntity<IncidentDto>> {
        return service.create(incident)
            .map { ResponseEntity.ok(it) }
    }

    @GetMapping("/incident/{id}")
    fun get(@PathVariable id: String): Mono<ResponseEntity<IncidentDto>> {
        return service.read(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/incidents")
    fun get(
        @RequestParam geoStr: String?,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "20") size: Int
    ): ResponseEntity<Flux<IncidentDto>> {
        return ResponseEntity.ok(service.find(GeoSearch.of(geoStr), PageRequest.of(page, size)))
    }
}
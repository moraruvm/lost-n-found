package io.millers.lostnfoundapi.controller

import io.millers.lostnfoundapi.dto.UserDto
import io.millers.lostnfoundapi.dto.search.GeoSearch
import io.millers.lostnfoundapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserController(val service: UserService) {

    @PostMapping("/user")
    fun create(@RequestBody user: UserDto): Mono<ResponseEntity<UserDto>> {
        return service.create(user)
            .map { ResponseEntity.status(HttpStatus.CREATED).body(it) }
    }

    @GetMapping("/user/{id}")
    fun get(@PathVariable id: String): Mono<ResponseEntity<UserDto>> {
        return service.read(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/users")
    fun find(): ResponseEntity<Flux<UserDto>> {
        return ResponseEntity.ok(service.find())
    }

}
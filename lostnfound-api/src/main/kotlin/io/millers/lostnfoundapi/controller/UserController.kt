package io.millers.lostnfoundapi.controller

import io.millers.lostnfoundapi.dto.UserDto
import io.millers.lostnfoundapi.mapper.UserMapper
import io.millers.lostnfoundapi.repo.UserRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserController(val repo: UserRepo, val userMapper: UserMapper) {

    @PostMapping("/user")
    fun create(@RequestBody user: UserDto): Mono<ResponseEntity<UserDto>> {
        return repo.save(userMapper.toEntity(user))
                .map(userMapper::toDto)
                .map { ResponseEntity.ok(it) }
    }

    @GetMapping("/user/{id}")
    fun get(@PathVariable id: String): Mono<ResponseEntity<UserDto>> {
        return repo.findById(id)
                .map(userMapper::toDto)
                .map { ResponseEntity.ok(it) }
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/users")
    fun get(): ResponseEntity<Flux<UserDto>> {
        return ResponseEntity.ok(repo.findAll().map(userMapper::toDto))
    }
}
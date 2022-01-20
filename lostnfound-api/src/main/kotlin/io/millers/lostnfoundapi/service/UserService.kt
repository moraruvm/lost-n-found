package io.millers.lostnfoundapi.service

import io.millers.lostnfoundapi.dto.UserDto
import io.millers.lostnfoundapi.mapper.UserMapper
import io.millers.lostnfoundapi.repo.UserRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(
        private val repo: UserRepo,
        private val mapper: UserMapper
) {

    fun create(dto: UserDto): Mono<UserDto> {
        val doc = mapper.toDocument(dto)
        return repo.save(doc).map(mapper::toDto)
    }

    fun read(id: String): Mono<UserDto> {
        return repo.findById(id).map(mapper::toDto)
    }

    fun update(dto: UserDto): Mono<UserDto> {
        return dto.id?.let(repo::findById)
                ?.flatMap(repo::save)
                ?.map(mapper::toDto) ?: Mono.empty();
    }

    fun findAll(): Flux<UserDto> {
        return repo.findAll().map(mapper::toDto);
    }

}
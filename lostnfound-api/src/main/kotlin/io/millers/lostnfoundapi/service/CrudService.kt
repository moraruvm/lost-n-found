package io.millers.lostnfoundapi.service

import io.millers.lostnfoundapi.entity.AbstractDoc
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

open class CrudService<T : AbstractDoc<ID>, ID : Any>(private val repo: ReactiveMongoRepository<T, ID>) {
    fun create(doc: T): Mono<T> {
        return repo.insert(doc)
    }

    fun read(id: ID): Mono<T> {
        return repo.findById(id)
    }

    fun update(doc: T): Mono<T> {
        return repo.findById(doc.id).flatMap(repo::save)
    }

    fun findAll(): Flux<T> {
        return repo.findAll()
    }
}
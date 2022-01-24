package io.millers.lostnfoundapi.repo

import io.millers.lostnfoundapi.entity.User
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface UserRepo : ReactiveMongoRepository<User, String> {
    fun findAllByLocationNear(point: Point, distance: Distance): Flux<User>
}
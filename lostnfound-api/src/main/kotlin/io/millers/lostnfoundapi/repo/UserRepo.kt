package io.millers.lostnfoundapi.repo

import io.millers.lostnfoundapi.entity.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepo : ReactiveMongoRepository<User, String>
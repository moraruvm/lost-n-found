package io.millers.lostnfoundapi.mapper

import io.millers.lostnfoundapi.dto.UserDto
import io.millers.lostnfoundapi.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toDocument(user: UserDto): User {
        return User(displayName = user.displayName, location = user.location)
    }

    fun toDto(user: User): UserDto {
        return UserDto(user.id, user.displayName, user.location)
    }
}
package io.millers.lostnfoundapi.mapper

import io.millers.lostnfoundapi.dto.UserDto
import io.millers.lostnfoundapi.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper(private val partMapper: PartMapper) {

    fun toDocument(user: UserDto): User {
        return User(
            displayName = user.displayName,
            location = partMapper.toDocument(user.location)
        )
    }

    fun toDto(user: User): UserDto {
        return UserDto(user.id, user.displayName, partMapper.toDto(user.location))
    }
}
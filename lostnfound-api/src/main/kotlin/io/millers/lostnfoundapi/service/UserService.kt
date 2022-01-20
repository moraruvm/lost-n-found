package io.millers.lostnfoundapi.service

import io.millers.lostnfoundapi.entity.User
import io.millers.lostnfoundapi.repo.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(repo: UserRepo): CrudService<User, String>(repo) {
}
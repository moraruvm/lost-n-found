package io.millers.lostnfoundapi.common

import org.springframework.stereotype.Component

@Component
class UserDetailsProvider {
    fun getAuthorId() = "ANONYMOUS"
}
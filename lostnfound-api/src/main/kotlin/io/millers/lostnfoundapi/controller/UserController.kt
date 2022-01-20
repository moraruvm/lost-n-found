package io.millers.lostnfoundapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping
    fun test(): Mono<ResponseEntity<String>> {
        return Mono.just(ResponseEntity.ok("Hello world!"));
    }
}
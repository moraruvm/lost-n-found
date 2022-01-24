package io.millers.lostnfoundapi.controller

import io.restassured.RestAssured
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.lang.RuntimeException
import javax.annotation.PostConstruct

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AbstractIntegrationTest {

    @LocalServerPort
    private var port: Int = 0

    @PostConstruct
    fun init() {
        RestAssured.baseURI = "http://localhost:$port"
    }

    protected fun getPayload(filePath: String): String {
        val fileName = "payloads/$filePath"
        val bytes = javaClass.classLoader.getResourceAsStream(fileName)?.readAllBytes()
        return bytes?.let { String(it) }
            ?: throw RuntimeException("Couldn't read resource file $filePath")
    }
}
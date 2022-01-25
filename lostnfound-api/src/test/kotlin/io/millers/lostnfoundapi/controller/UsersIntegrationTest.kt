package io.millers.lostnfoundapi.controller

import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class UsersIntegrationTest : AbstractIntegrationTest() {

    companion object {
        const val USER = "/user"
        const val USER_LIST = "/users"
    }

    @Test
    fun testUserCreate() {
        val given = given()
            .contentType(ContentType.JSON)
            .body(getPayload("create_user.json"))

        given.post(USER)
            .then().log().all()
            .assertThat()
            .statusCode(HttpStatus.CREATED.value())
    }

    @Test
    fun testUserGetAll() {
        get(USER_LIST)
            .then().log().all()
            .assertThat()
            .statusCode(HttpStatus.OK.value())
    }

}
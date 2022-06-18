package com.kotlinspring.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //8080말고 랜덤포트 쓰겠다.
@ActiveProfiles("test")
@AutoConfigureWebTestClient //restTemplate 테스트할 때 쓰는 건데 이게 최신?이라는듯, webtestClient 인스턴스 얻어서 controller랑 interact 가능하게 함
class GreetingControllerIntgTest {

    @Autowired
    lateinit var webTestClient : WebTestClient

    @Test
    fun retrieveGreeting() {

        val name = "DiDi"
        val result = webTestClient.get()
            .uri("/v1/greetings/{name}",name)
            .exchange() //실제 invoke
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        Assertions.assertEquals("$name, Hello from default profile",result.responseBody)

    }
}
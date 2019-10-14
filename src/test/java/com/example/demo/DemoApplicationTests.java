package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest
public class DemoApplicationTests {


    @Autowired
    WebTestClient client;


    @Test
    void test() {
        client.post()
                .uri("/test")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("{\"id\":\"test\"}"), String.class)
                .exchange()
                .returnResult(String.class)
                .getResponseBody()
                .as(StepVerifier::create)
                .expectNext("TestEntity")
                .verifyComplete();
    }

}

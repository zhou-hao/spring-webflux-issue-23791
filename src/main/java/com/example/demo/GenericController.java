package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

public interface GenericController<E> {

    @PostMapping("/test")
    default Mono<String> test(@RequestBody Mono<E> test){
            return test
                    .map(e-> e.getClass().getSimpleName());
    }

}

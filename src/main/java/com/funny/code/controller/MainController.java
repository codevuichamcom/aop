package com.funny.code.controller;

import com.funny.code.annotation.PositiveNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {

    @GetMapping("/hello/{number}")
    public String sayHello(@PathVariable @PositiveNumber String number) {
        log.info("In controller {}", number);
        return "Hello";
    }
}

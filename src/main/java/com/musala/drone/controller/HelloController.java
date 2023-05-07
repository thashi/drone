package com.musala.drone.controller;

import com.musala.drone.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloService helloService;

    @GetMapping("/{name}")
    public String greetUser(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/ping")
    public String ping() {
        return helloService.greetUser();
    }
}

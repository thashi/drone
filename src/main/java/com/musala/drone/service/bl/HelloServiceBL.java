package com.musala.drone.service.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceBL {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceBL.class);

    public String greetUser() {
        LOGGER.info("Call from HelloService");
        return "Pong";
    }
}

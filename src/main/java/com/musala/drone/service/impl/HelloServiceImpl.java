package com.musala.drone.service.impl;

import com.musala.drone.service.HelloService;
import com.musala.drone.service.bl.HelloServiceBL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HelloServiceImpl implements HelloService {

    public static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Autowired
    HelloServiceBL helloServiceBL;


    @Override
    public String greetUser() {
        LOGGER.info("Call from ping-pong controller");
        return helloServiceBL.greetUser();
    }
}

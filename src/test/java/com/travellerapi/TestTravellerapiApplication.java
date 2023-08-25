package com.travellerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTravellerapiApplication {

    public static void main(String[] args) {
        SpringApplication.from(TravellerApiApplication::main).with(TestTravellerapiApplication.class).run(args);
    }

}

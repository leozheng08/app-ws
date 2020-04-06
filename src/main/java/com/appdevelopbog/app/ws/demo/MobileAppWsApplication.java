package com.appdevelopbog.app.ws.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobileAppWsApplication {

    public static void main(String[] args) {
        System.getProperties().put( "server.port", 9090 );  //90 port is set here
        SpringApplication.run(MobileAppWsApplication.class, args);
    }

}

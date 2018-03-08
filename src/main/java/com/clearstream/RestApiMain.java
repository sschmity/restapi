package com.clearstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
// load the spring xml file from classpath
@ImportResource("classpath:camel-context.xml")
public class RestApiMain {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(RestApiMain.class, args);
    }

}

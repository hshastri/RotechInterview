package com.example.demo;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@RestController
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class.getName());

    @GetMapping("/hello")
    public String hello() {
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("/Users/apple/Desktop/RotechInterview/demo 2/src/logs.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("GET: 'Hello, World!");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("GET: 'Hello, World!'");
        return "Hello, World!";

    }

}
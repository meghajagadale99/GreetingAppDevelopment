package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sayWelcome() {
        return new ResponseEntity("Welcome to Greeting App", HttpStatus.OK);
    }
}

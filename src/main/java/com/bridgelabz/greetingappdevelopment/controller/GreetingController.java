package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sayWelcome() {
        return new ResponseEntity("Welcome to Greeting App", HttpStatus.OK);
    }

    @GetMapping("/greeting/message")
    public String getWelcomeMessage() {
        return greetingService.greetingMessage();
    }

    @GetMapping("/greeting/message/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + "! Hello World!";
    }
    @GetMapping("/greeting/messages/{name}")
    public String greeting(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname) {
        return "Hello " + fname + " " + lname +"! Hello World!";
    }
}

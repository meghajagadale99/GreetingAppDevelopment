package com.bridgelabz.greetingappdevelopment.controller;


import com.bridgelabz.greetingappdevelopment.dto.GreetingDTO;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/")
    public String greeting() {
        return "Hello! Welcome to Greeting App!";
    }

    @GetMapping("/greeting/message")
    public String greetingMessage() {
        return greetingService.greetingMessage();
    }

    @GetMapping("/name")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + "! Welcome to Greeting App!";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "fname") String fname,
                           @RequestParam(value = "lname") String lname) {
        return "Hello " + fname + " " + lname + "! Welcome to Greeting App!";
    }

    @PostMapping(value = "/greeting")
    public Greeting addGreeting(@RequestBody GreetingDTO greetingDTO) {
        return greetingService.addGreeting(greetingDTO);
    }

    @GetMapping(value = "/get-greeting-by-id")
    public Greeting getGreetingById(@RequestBody int id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping(value = "/greetings")
    public List<Greeting> greetings() {
        return greetingService.greetings();
    }

    @PutMapping(value = "/greeting/{id}")
    public Greeting updateGreeting(@PathVariable int id, @RequestBody GreetingDTO greetingDTO) {
        return greetingService.updateGreeting(id, greetingDTO);
    }

    @DeleteMapping(value = "/greeting")
    public String deleteGreeting(@RequestParam int id) {
        return greetingService.deleteGreeting(id);
    }

}

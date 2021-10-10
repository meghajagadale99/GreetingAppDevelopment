package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.GreetingDTO;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;


    public String greetingMessage(){
        return "Hello World!";
    }

    public List<Greeting> greetings() {
        return greetingRepository.findAll();
    }

    public Greeting getGreetingById(int id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if(greeting.isPresent()) {
            return greeting.get();
        }
        return null;
    }

    public Greeting addGreeting(GreetingDTO greetingDTO) {
        Greeting greeting = new Greeting();

        greeting.setMessage(greetingDTO.getMessage());
        return greetingRepository.save(greeting);
    }

    public Greeting updateGreeting(int id, GreetingDTO greetingDTO) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if(optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            greeting.setMessage(greetingDTO.getMessage());
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public String deleteGreeting(int id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            greetingRepository.delete(greeting.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this id : " + id;
    }
}

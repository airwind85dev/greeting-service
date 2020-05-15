package com.home.greetings.greetingservice.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/base")
public class GreetingController {

    @ApiOperation(value = "Greets with a Hi! all the time", notes = "hit with a / to get a 'Hi!' message",
            response = String.class)
    @GetMapping("/")
    public String home() {
        return "Hi!";
    }

    @ApiOperation(value = "Greets with static values", notes = "hit with a /greeting to get a random greeting message",
    response = String.class)
    @GetMapping("/greeting")
    public String greet(){
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

}

package com.orion.trivia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TriviaController {

    @GetMapping("/api/v1/trivia")
    public List getAllQuestions(){
        return
    }
}

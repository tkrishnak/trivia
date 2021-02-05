package com.orion.trivia.controller;

import com.orion.trivia.service.TriviaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="trivia")
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    @GetMapping("/api/v1/trivia")
    public List getAllQuestions(){
        return triviaService.getAllQuestions();
    }
}

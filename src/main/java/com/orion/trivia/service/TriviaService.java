package com.orion.trivia.service;

import com.orion.trivia.repository.TriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TriviaService {

    @Autowired
    TriviaRepository triviaRepository;

    public List getAllQuestions() {
        return triviaRepository.findAll();
    }
}

package com.orion.trivia.controller;

import com.orion.trivia.entity.Question;
import com.orion.trivia.service.TriviaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TriviaControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TriviaService triviaService;

    @Test
    public void getAllQuestions_NoQuestion_Test() throws Exception {

        when(triviaService.getAllQuestions()).thenReturn(new ArrayList());

        mvc.perform(get("/api/v1/trivia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
        verify(triviaService, times(1)).getAllQuestions();
    }


    @Test
    public void getAllQuestions_TwoQuestion_Test() throws Exception {

        Question question1 = Question.builder().question("What did Yankee Doodle stick in his cap?")
                .timestamp(new Date()).build();
        Question question2 = Question.builder().question("What word completes the phrase: “Everything but the kitchen”?")
                .timestamp(new Date()).build();

        List<Question> expectedList = new ArrayList<Question>();
        expectedList.add(question1);
        expectedList.add(question2);

        when(triviaService.getAllQuestions()).thenReturn(expectedList);

        mvc.perform(get("/api/v1/trivia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].question").value(question1.getQuestion()))
                .andExpect(jsonPath("$[1].question").value(question2.getQuestion()));
        verify(triviaService, times(1)).getAllQuestions();
    }


}

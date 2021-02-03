package com.orion.trivia.controller;

import com.orion.trivia.service.TriviaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

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


}

package com.orion.trivia.controller;

import com.orion.trivia.entity.Answer;
import com.orion.trivia.entity.Question;
import com.orion.trivia.repository.TriviaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class TriviaControllerITTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TriviaRepository triviaRepository;

    @Test
    public void getAllQuestions() throws Exception {
        Question question1 = Question.builder().question("What did Yankee Doodle stick in his cap?")
                .created_at(new Date())
                .question_number(1L)
                .quiz_id(1L).build();
        Answer answer1 = Answer.builder().text("Feather").correct(true).choice("A").question_id(1L).build();
        Answer answer2 = Answer.builder().text("Noodle soup").correct(false).choice("B").question_id(1L).build();

        List<Answer> answerList = new ArrayList<Answer>();
        answerList.add(answer1);
        answerList.add(answer2);
        question1.setAnswers(answerList);

        List<Question> expectedList = new ArrayList<Question>();
        expectedList.add(question1);

        triviaRepository.save(question1);
        mockMvc.perform(get("/api/v1/trivia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].answers[0]").value(question1.getAnswers().get(0)))
                .andExpect(jsonPath("$[0].answers[1]").value(question1.getAnswers().get(1)));
    }
}
















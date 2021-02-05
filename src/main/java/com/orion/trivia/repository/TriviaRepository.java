package com.orion.trivia.repository;

import com.orion.trivia.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriviaRepository extends JpaRepository<Question, Long> {
}

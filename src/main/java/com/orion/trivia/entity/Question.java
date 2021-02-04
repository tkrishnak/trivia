package com.orion.trivia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer question_num;
    private Date timestamp;
    private String question;
}

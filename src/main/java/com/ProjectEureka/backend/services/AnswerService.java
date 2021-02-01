package com.ProjectEureka.backend.services;

import java.util.List;

import com.ProjectEureka.backend.models.Answer;

public interface AnswerService {
    Answer createAnswer(Answer answer);

    Answer updateAnswer(String id, Answer answer);

    List<Answer> getAllAnswers();

    Answer getAnswerById(String id);

    void deleteAnswer(String id);
}
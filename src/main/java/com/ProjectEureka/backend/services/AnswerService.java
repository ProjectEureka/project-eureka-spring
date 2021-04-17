package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Answer answer);

    Answer updateAnswer(String id, Answer answer);

    List<Answer> getAllAnswers();

    Answer getAnswerById(String id);

    Answer deleteAnswer(String id);
}
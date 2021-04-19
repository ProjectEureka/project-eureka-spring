package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);

    Question updateQuestion(String id, Question question);

    Question updateQuestionVisibility(String id);

    List<Question> getAllQuestions();

    Question getQuestionById(String id);

    Question deleteQuestion(String id);
}
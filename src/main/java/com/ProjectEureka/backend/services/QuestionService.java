package com.ProjectEureka.backend.services;

import java.util.List;


import com.ProjectEureka.backend.models.Question;

public interface QuestionService {
    Question createQuestion(Question question);

    Question updateQuestion(String id, Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(String id);

    Question deleteQuestion(String id);
}
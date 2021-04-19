package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.Question;

public interface QuestionCloseService {

    Question updateQuestionClose(String id, String answerId);
}

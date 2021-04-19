package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.Answer;
import com.ProjectEureka.backend.models.Question;
import com.ProjectEureka.backend.repositories.AnswerRepository;
import com.ProjectEureka.backend.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class QuestionCloseServiceImpls implements QuestionCloseService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Question updateQuestionClose(String id, String answerId) {

        Optional<Question> questionResult = this.questionRepository.findById(id);
        Optional<Answer> answerResult = this.answerRepository.findById(answerId);
        if (questionResult.isPresent()) {
            Question questionUpdate = questionResult.get();
            questionUpdate.setClosed(true);
            Answer answerUpdate = answerResult.get();
            answerUpdate.setBestAnswer(true);

            this.answerRepository.save(answerUpdate);

            return this.questionRepository.save(questionUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}

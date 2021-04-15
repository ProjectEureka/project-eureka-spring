package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.*;
import com.ProjectEureka.backend.repositories.AnswerRepository;
import com.ProjectEureka.backend.repositories.QuestionRepository;
import com.ProjectEureka.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoreDetailServiceImpl implements MoreDetailService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public MoreDetail getQuestionById(String id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            Question questionResult = question.get();
            Optional<User> user = userRepository.findById(questionResult.getUserId());
            List<Answer> answers = answerRepository.findByQuestionId(questionResult.getId());
            List<UserAnswer> userAnswerArrayParent = new ArrayList<>();
            for (Answer answer : answers) {
                Optional<User> userByAnswer = userRepository.findById(answer.getUserId());
                userAnswerArrayParent.add(new UserAnswer(userByAnswer.get(), answer));
            }
            return new MoreDetail(user.get(), question.get(), userAnswerArrayParent);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
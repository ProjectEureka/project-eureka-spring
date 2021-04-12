package com.ProjectEureka.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.Answer;
import com.ProjectEureka.backend.models.MoreDetail;
import com.ProjectEureka.backend.models.Question;
import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.AnswerRepository;
import com.ProjectEureka.backend.repositories.QuestionRepository;
import com.ProjectEureka.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            List<List<Object>> userAnswerArrayParent = new ArrayList<>();
            for (Answer answer : answers) {
                List<Object> userAnswersChild = new ArrayList<>();
                Optional<User> userByAnswer = userRepository.findById(answer.getUserId());
                userAnswersChild.add(userByAnswer.get());
                userAnswersChild.add(answer);
                userAnswerArrayParent.add(userAnswersChild);
            }
            return new MoreDetail(user.get(), question.get(), userAnswerArrayParent);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
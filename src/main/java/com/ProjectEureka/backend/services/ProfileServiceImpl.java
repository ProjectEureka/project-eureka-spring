package com.ProjectEureka.backend.services;

import java.util.List;
import java.util.Optional;

import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.Answer;
import com.ProjectEureka.backend.models.Profile;
import com.ProjectEureka.backend.models.Question;
import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.AnswerRepository;
import com.ProjectEureka.backend.repositories.QuestionRepository;
import com.ProjectEureka.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Profile getProfile(String id) {
        Optional<User> user = userRepository.findById(id);
        List<Question> questionsByUserId = questionRepository.findByUserId(id);
        List<Answer> answersByUserId = answerRepository.findByUserId(id);

        if (user.isPresent()) {
            return new Profile(user.get(), questionsByUserId, answersByUserId);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

}
